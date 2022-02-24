package networking;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Geocoder {
    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json?";

    private Function<String, String> encoder = s -> {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    };

    public String encodeAddress(List<String> address) {
        return address.stream()
                .map(encoder)
                .collect(Collectors.joining(","));
    }

    public String getData(List<String> address) {
        String encoded = encodeAddress(address);
        String response = "";
        try {
            URL url = new URL(String.format("%saddress=%s", BASE, encoded));
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream())
            )) {
                String line = "";
                while ((line = br.readLine()) != null) {
                    response += "\n" + line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public void fillInLatLng(Location location) throws JsonException {
        String encoded = encodeAddress(
                Arrays.asList(location.getStreet(), location.getCity(), location.getState())
        );
        try {
            URL url = new URL(String.format("%saddress=%s", BASE, encoded));
            try (InputStream is = url.openStream();
                 JsonReader jr = Json.createReader(is)) {
                JsonObject jo = jr.readObject();
                if (jo.containsKey("error_message")) {
                    throw new JsonException(
                            String.format("Json contains error message: %s", jo.getString("error_message"))
                    );
                }

                JsonObject loc = jo.getJsonArray("results")
                        .getJsonObject(0)
                        .getJsonObject("geometry")
                        .getJsonObject("locaation");
                location.setLatitute(loc.getJsonNumber("lat").doubleValue());
                location.setLatitute(loc.getJsonNumber("lng").doubleValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
