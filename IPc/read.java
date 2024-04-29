import java.io.*;
public class read {
public static void main(String[] args) {
try {
BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
String input;
while ((input = reader.readLine()) != null) {
System.out.println("Received: " + input);
}
reader.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}
