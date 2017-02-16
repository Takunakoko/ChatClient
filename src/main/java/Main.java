import java.net.Socket;

/**
 * Created by takunaka on 15.02.17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Socket socket = ClientSocket.createClientSocket(Configurator.getHost(), Configurator.getPort());
        SocketHandler.handleSocket(socket);
    }
}
