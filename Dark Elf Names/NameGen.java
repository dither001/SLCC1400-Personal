import java.util.Random;
import java.util.Scanner;

public class NameGen {
   // fields
   private static final Random rand = new Random();
   private static final Scanner input = new Scanner(System.in);
   
   private static final Prefixes pre = new Prefixes();
   private static final FSuffixes fsuf = new FSuffixes();
   private static final MSuffixes msuf = new MSuffixes();
   
   
   
   // methods
   public static void main(String[] args) {
      userPrompt();
   }
   
   public static void userPrompt() {
      int userNum = 1;
      int gender = 0;
      
      while (userNum != 0) {
         System.out.print("Enter a number or 0 to quit: ");
         userNum = input.nextInt();
         
         if (userNum > 0) {
            System.out.print("Enter 0 for female or 1 for male: ");
            gender = input.nextInt();
            printNames(userNum, gender);
         }
      }

   }
   
   public static void printNames(int n, int g) {
      if (g == 1) {
         for (int i = 1; i <= n; ++i) {
            System.out.println(buildMaleName());
         }
      }
      else {
         for (int i = 1; i <= n; ++i) {
            System.out.println(buildFemName());
         }
      }
   }
   
   public static String buildFemName() {
      int build = deeRoll(1,100);
      String name = "";
      
      if (build >= 1 && build <= 30) {
         name = selectPrefix();
         name += selectFSuffix();
      }
      else if (build >= 31 && build <= 70) {
         name = selectPrefix();
         name += selectFSuffix();
         name += selectFSuffix();
      }
      else if (build >= 71 && build <= 90) {
         name = selectPrefix();
         name += selectFSuffix();
         name += " ";
         name += selectPrefix();
         name += selectFSuffix();
      }
      else {
         name = selectFSuffix();
         name += "'";
         name += selectPrefix();
         name += selectFSuffix();
         name += selectFSuffix();
      }
      
      // appends build number in parentheses
      //name += " (" + build + ")";
      return name;
   }
   
   public static String buildMaleName() {
      int build = deeRoll(1,100);
      String name = "";
      
      if (build >= 1 && build <= 30) {
         name = selectPrefix();
         name += selectMSuffix();
      }
      else if (build >= 31 && build <= 70) {
         name = selectPrefix();
         name += selectMSuffix();
         name += selectMSuffix();
      }
      else if (build >= 71 && build <= 90) {
         name = selectPrefix();
         name += selectMSuffix();
         name += " ";
         name += selectPrefix();
         name += selectMSuffix();
      }
      else {
         name = selectMSuffix();
         name += "'";
         name += selectPrefix();
         name += selectMSuffix();
         name += selectMSuffix();
      }
      
      // appends build number in parentheses
      //name += " (" + build + ")";
      return name;
   }
   
   public static String selectPrefix() {
      return pre.assignPrefix(deeRoll(1,100));
   }
   
   public static String selectFSuffix() {
      return fsuf.assignSuffix(deeRoll(1,100));
   }
   
   public static String selectMSuffix() {
      return msuf.assignSuffix(deeRoll(1,100));
   }
   
   public static int deeRoll (int num, int sides) {
      int n = 0;
      for (int i = 1; i <= num; ++i) {
         n += deeFace(sides);
      }
      return n;
   }
   
   // overloaded deeRoll returns 1d6
   public static int deeRoll () {
      return deeRoll(1,6);
   }
   
   public static int deeFace (int sides) {
      return rand.nextInt(sides) + 1;
   }
   
   // overloaded deeFace returns d6
   public static int deeFace () {
      return deeFace(6);
   }
}