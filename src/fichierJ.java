import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class fichierj implements IJournal{

  @Override
  public void outPut_Msg(String message) {
    
    String randName = System.currentTimeMillis() + Integer.toString(ThreadLocalRandom.current().nextInt(100, 1000));
    
    new File(randName + "_message.txt");
    
  }
  
}