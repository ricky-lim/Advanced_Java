package networking;

import java.net.MalformedURLException;
import java.net.URL;

public class ParseURL {
    public static void main(String[] args) throws MalformedURLException {
        URL aURL = new URL("http://search.oreilly.com:80/index.html?q=kousen#REFERENCE");
        System.out.println("Protocol " + aURL.getProtocol());
        System.out.println("Authority " + aURL.getAuthority());
        System.out.println("Host " + aURL.getHost());
        System.out.println("Port " + aURL.getPort());
        System.out.println("Path " + aURL.getPath());
        System.out.println("Query " + aURL.getQuery());
        System.out.println("filename " + aURL.getFile());
        System.out.println("Ref " + aURL.getRef());
    }
}
