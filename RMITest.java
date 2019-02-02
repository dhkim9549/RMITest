import java.io.*;
import java.rmi.*;
import org.json.*;
import com.dhkim9549.mlptictactoe.RMIInterface;

public class RMITest {
  
  public static void main(String[] args) throws IOException {
    
    RMIInterface look_up = null;
    String a = "";
    
    try {
      
      // {"board":["","","","","","","","",""],"currentPlayer":"X"}
    
      JSONArray boardArray = new JSONArray();
      for(int i = 0; i < 9; i++) {
        boardArray.put("");
      }
    
      JSONObject board2 = new JSONObject();
      board2.put("board", boardArray);
      board2.put("currentPlayer", "X");
    
      System.out.println("board2 = " + board2);
      
      while(true) {
        look_up = (RMIInterface)Naming.lookup("//bada.ai/MyServer");
        a += look_up.helloTo(board2.toString());
        System.out.println(a);
        System.out.println();
      }
      
    } catch(Exception ex){
      ex.printStackTrace();
    }
    
    
  }
}