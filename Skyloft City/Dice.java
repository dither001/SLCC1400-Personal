/****************************************
* Last edited: 4/28/2017
* 
* imports Random, sets up dice roller
****************************************/

import java.util.Random;

public class Dice {
   // fields
   private static final Random rand = new Random();
   
   // methods
   
   // returns X dice with Y sides each
   public static int deeRoll(int num, int sides) {
      int n = 0;
      for (int i = 1; i <= num; ++i) {
         n += deeFace(sides);
      }
      return n;
   }
   
   // returns a single die with N sides
   public static int deeFace(int sides) {
      return rand.nextInt(sides) + 1;
   }
}