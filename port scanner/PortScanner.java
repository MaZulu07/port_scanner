import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class PortScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter target IP address: ");
        String ip = scanner.nextLine();

        System.out.print("Enter start port: ");
        int startPort = scanner.nextInt();

        System.out.print("Enter end port: ");
        int endPort = scanner.nextInt();

        System.out.println("Scanning ports from " + startPort + " to " + endPort + " on " + ip);

        for (int port = startPort; port <= endPort; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ip, port), 200);
                socket.close();
                System.out.println("Port " + port + " is open.");
            } catch (IOException e) {
                // Port is closed or unreachable
                System.out.println("Port " + port + " is closed.");
            }
        }

        System.out.println("Port scanning completed.");
    }
}
