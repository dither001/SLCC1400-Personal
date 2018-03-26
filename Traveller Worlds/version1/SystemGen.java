
// system presence
// system features
// place components ()
// generate worlds
// determine satellites
// generate satellites
// designate main world
// determine add'l details

public class SystemGen {
   // fields
   private final DiceRoller dice = new DiceRoller();

   public int[] scores = new int[0];
   
   
   // constructors
   
   // methods
   public void rollScores() {
      scores[0] = dice.deeRoll(2,6);            // sysNature
      
   }
   
   public void rollStars() {
   }
}