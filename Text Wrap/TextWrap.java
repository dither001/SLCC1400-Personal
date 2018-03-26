
import java.util.ArrayList;

public class TextWrap {
   public static void main(String[] args) {
      String sentence = "But I must explain to you how all this mistaken idea of denouncing of a pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?";
      
      char wrapKey = ' ';
      int LINE_LENGTH = 40;
      int start = 0;
      int end = 0;
      int pointer = LINE_LENGTH;
      ArrayList<String> parser = new ArrayList<>();
      
      boolean atEnd = false;
      while (atEnd != true) {
         if (pointer >= sentence.length()) {
            pointer = sentence.length() - 1;
            atEnd = true;
         }
         while (sentence.charAt(pointer) != wrapKey) {--pointer;}
         end = pointer;
         parser.add(sentence.substring(start, end));
         // reset
         start = end;
         pointer += LINE_LENGTH;
         if (pointer >= sentence.length()) {
            end = sentence.length();
            parser.add(sentence.substring(start, end));
            atEnd = true;
         }
      }
      
      for (String el : parser) {System.out.println(el);}
      
   }
   
   /************************************************
   * Experiments
   ************************************************/
   public static void substringTest(char wrapKey) {
      String newLine;
      int start = 0;
      int end;
      
      String sentence = "The quick brown fox jumped over the lazy dog.";
      System.out.println(sentence);
      
      end = sentence.indexOf(wrapKey);
      newLine = sentence.substring(start, end);
      System.out.println(newLine);
   }
   
   
   public static void indexOfChar(char wrapKey) {
      String sentence = "The quick brown fox jumped over the lazy dog.";
      System.out.println(sentence);
      
      int i = sentence.indexOf(wrapKey);
      System.out.println("The first '" + wrapKey + "' is at: " + i);
   }
   
   public static void identifyChar(char wrapKey) {
      String sentence = "The quick brown fox jumped over the lazy dog.";
      System.out.println(sentence);
      
      for (int i = 0; i < sentence.length(); ++i) {
         if (sentence.charAt(i) == wrapKey)
            System.out.println("" + i + ". This is a '" + wrapKey + "'");
         else
            System.out.println("" + i + ". Obviously not a '" + wrapKey + "'");
      }
   }
   
   // end of code
}