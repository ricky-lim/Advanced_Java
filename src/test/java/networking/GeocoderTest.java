package networking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.json.JsonException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GeocoderTest {
    private Geocoder geocoder = new Geocoder();

    @Test
    void encodeAddress() {
        String encoded = geocoder.encodeAddress(
                Arrays.asList("1600 Amphitheatre Parkway", "Mountain View", "CA"));
        assertEquals("1600+Amphitheatre+Parkway,Mountain+View,CA", encoded);
    }

    @Test
    void getData(){
        String data = geocoder.getData(
                Arrays.asList("1600 Amphitheatre Parkway", "Mountain View", "CA"));
        System.out.println(data);
    }

    @Test
    @DisplayName("fill in latitute and longitude without API key should throw error")
    void fillInLatituteAndLongitudeWithoutApiKeyShouldThrowError() {
        Location location = new Location("1600 Amphitheatre Parkway", "Mountain View", "CA");
        assertThrows(JsonException.class, () -> geocoder.fillInLatLng(location));

    }

}