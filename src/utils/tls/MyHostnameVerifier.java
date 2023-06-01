package utils.tls;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

public class MyHostnameVerifier implements HostnameVerifier {
    static final Set<String> ALLOWED = Set.of("users_ourorg0", "feeds_ourorg0");
    public boolean verify(String hostname, SSLSession session) {
        String resolvedName = null;
        try {
            resolvedName = InetAddress.getByName(hostname).getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return ALLOWED.contains( resolvedName);
    }
}
