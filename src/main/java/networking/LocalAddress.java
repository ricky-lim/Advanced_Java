package networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalAddress {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
    }
}
