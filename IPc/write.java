import java.io.*;
public class write {
  public static void main(String[] args) {
    try{
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter writer = new PrintWriter(new FileWriter("data.txt"));
      String input;
      while ((input = reader.readLine()) != null) {
        writer.println(input);
        writer.flush();
      }
      reader.close();
      writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
