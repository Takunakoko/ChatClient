/**
 * Created by takunaka on 15.02.17.
 */
public class Configurator {
    private Configurator() {

    }

    private static String host = "localhost";
    private static int port = 8080;

    public static String getHost() {
        return host;
    }

    public static int getPort() {
        return port;
    }

}
