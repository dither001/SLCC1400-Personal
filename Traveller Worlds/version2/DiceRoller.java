
import java.util.Random;

public class DiceRoller {
   private static final Random rand = new Random();
   
   public static int deeRoll(int num, int sides) {
      int n = 0;
      for (int i = 1; i <= num; ++i) {
         n += deeFace(sides);
      }
      return n;
   }
   
   public static int deeFace(int sides) {
      return rand.nextInt(sides) + 1;
   }
}