import java.io.*;
import java.net.*;
public class Server {
 private static final int PORT = 12345;
 public static void main(String[] args) {
 try {
 ServerSocket serverSocket = new ServerSocket(PORT);
 System.out.println("Time Server started.");
 while (true) {
 Socket clientSocket = serverSocket.accept();
 System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
 new Thread(new ClientHandler(clientSocket)).start();
 synchronizeTime(clientSocket);
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 private static void synchronizeTime(Socket clientSocket) throws IOException {
 try {
 while (true) {
 Thread.sleep(10000); 
 
 long currentTime = System.currentTimeMillis();
 
 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
 out.println(currentTime);
 }
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 }
}
class ClientHandler implements Runnable {
 private Socket clientSocket;
 public ClientHandler(Socket clientSocket) {
 this.clientSocket = clientSocket;
 }
 public void run() {
 try {
 BufferedReader in = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream()));
 String request;
 while ((request = in.readLine()) != null) {
 System.out.println("Client request: " + request);
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}
