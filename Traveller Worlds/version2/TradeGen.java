import java.util.Random;

public class TradeGen {
   //fields
   private static final Random rand = new Random();
   // private static byte[] scores = new byte[7];
   
   // size, atmo, temp, hydro, pop, gov, law
   
   private static final String[] tradeList = {
      "Ag", "As", "Ba", "De", "Fl", "Ga", "Hi", "Ht", "IC",
      "In", "Lo", "Lt", "NA", "NI", "Po", "Ri", "Va", "Wa",
   };
   
   private static String[] tradeCodes = new String[18];
   
   //methods
   
   
   public static void main(String[] args) {
      for (String el : tradeList) {
         System.out.printf("%s ", el);
      }
      
      String[] tradeCodes = new String[18];
      for (String el : tradeCodes) {
         el = "";
      }
   }
   
   
}