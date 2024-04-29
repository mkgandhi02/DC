import java.io.*;
import java.net.*;
public class Client {
 private static final String SERVER_IP = "localhost";
 private static final int PORT = 12345;
 private static final long Stop = 60000;
 public static void main(String[] args) {
 long startTime = System.currentTimeMillis();
 try {
 Socket socket = new Socket(SERVER_IP, PORT);
 System.out.println("Connected to Time Server.");
 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 while (System.currentTimeMillis() - startTime <= Stop) {
 out.println("getTime");
 long serverTime = Long.parseLong(in.readLine());
 long clientTime = System.currentTimeMillis();
 long timeDifference = serverTime - clientTime;
 System.out.println("Server Time: " + serverTime);
 System.out.println("Client Time: " + clientTime);
 System.out.println("Time Difference: " + timeDifference + " ms");
 System.out.println("--------------------------");
 Thread.sleep(10000);
 }
 socket.close();
 System.exit(0);
 } catch (IOException | InterruptedException e) {
 e.printStackTrace();
 }
 }
}
