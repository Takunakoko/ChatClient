import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by takunaka on 15.02.17.
 */
public class SocketHandler {
    private static InputStream inStr;
    private static OutputStream outStr;
    private static Scanner sc;
    private static PrintWriter pw;


    private SocketHandler() {

    }

    public static void handleSocket(Socket s) throws IOException {
        inStr = s.getInputStream();
        outStr = s.getOutputStream();
        sc = new Scanner(inStr);
        pw = new PrintWriter(outStr);

        Thread th = new Thread(new ConsoleReader(pw));
        th.start();

        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }

}
