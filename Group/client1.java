import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class client1 {
public static void main(String[] args) {
try {
Socket socket = new Socket("localhost", 12345); 
BufferedReader in = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
String message = in.readLine();
System.out.println("Message from server: " + message);
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
