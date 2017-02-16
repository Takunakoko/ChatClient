
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by takunaka on 15.02.17.
 */
public class ConsoleReader implements Runnable {
    private PrintWriter pr;

    public ConsoleReader(PrintWriter pr) {
        this.pr = pr;
    }

    public void run() {
        InputStream inStream = new BufferedInputStream(System.in);
        Scanner scan = new Scanner(inStream);

        while (true){
            pr.println(scan.nextLine());
        }

    }
}
