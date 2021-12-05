import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Testing {
  public static void main(String[] args) throws IOException {
    ArrayList<String> profiles = Command.getProfiles();
    File file = new File("passwords.txt");
    FileWriter fw = new FileWriter(file);
    PrintWriter pw = new PrintWriter(fw);
    for (int i = 0; i < profiles.size(); i++)
      pw.println((String)profiles.get(i) + ": " + Command.getPassword(profiles.get(i))); 
    pw.close();
  }
}
