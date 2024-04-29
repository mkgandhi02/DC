import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
public class server {
public static void main(String[] args) {
try {
ServerSocket serverSocket = new ServerSocket(12345); 
System.out.println("Server started. Waiting for clients...");
while (true) {
Socket clientSocket = serverSocket.accept();
System.out.println("Client connected from: " + 
clientSocket.getInetAddress().getHostName());
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
out.println("Hi this comp c 41");
clientSocket.close();
}
} catch (IOException e) {
e.printStackTrace();
}
}
}
