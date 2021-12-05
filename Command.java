import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Command {
  public static void runCommand(String command) throws IOException {
    Process p = Runtime.getRuntime().exec("cmd /c" + command);
    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line;
    while ((line = stdInput.readLine()) != null)
      System.out.println(line); 
  }
  
  public static ArrayList<String> getProfiles() throws IOException {
    Process p = Runtime.getRuntime().exec("cmd /c netsh wlan show profiles");
    ArrayList<String> profiles = new ArrayList<>();
    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line;
    while ((line = stdInput.readLine()) != null) {
      if (line.contains("    All User Profile     : ")) {
        String profile = line.substring(27);
        profiles.add(profile);
      } 
    } 
    return profiles;
  }
  
  public static String getPassword(String profile) throws IOException {
    Process p = Runtime.getRuntime().exec("cmd /c netsh wlan show profile " + profile + " key=clear");
    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line;
    while ((line = stdInput.readLine()) != null) {
      if (line.contains("    Key Content            : "))
        return line.substring(29); 
    } 
    return null;
  }
}
