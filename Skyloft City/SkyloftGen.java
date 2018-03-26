/****************************************
* Last edited: 5/9/2017
* 
* Instantiates multiple Skylofts
****************************************/

public class SkyloftGen {
   public static void main(String[] args) {
//       Skyloft myLoft = new Skyloft();
//       System.out.println(myLoft.toString());
      
      Skyloft[] cities = new Skyloft[30];
      for (Skyloft el : cities) {
         el = new Skyloft();
         System.out.println(el.toString());
      }
   }
}