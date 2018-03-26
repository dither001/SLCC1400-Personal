
public class Adventure {
   // fields
   private String dungeonGoal;
   
   // constructors
   
   // methods
   public String goalSwitchA(int n) {
      switch(n) {
         case 1: return "Stop the inhabitants from raiding the surface.";
         case 2: return "Foil a villain's plot.";
         case 3: return "Destroy a magical threat.";
         case 4: return "Acquire treasure.";
         case 5: return "Locate a specific object to a purpose.";
         case 6: return "Retrieve a stolen item hidden in the dungeon.";
         case 7: return "Find information needed to a purpose.";
         case 8: return "Rescue a captive.";
         case 9: return "Discover the fate of previous party.";
         case 10: return "Find an NPC who disappeared nearby.";
         case 11: return "Slay a dragon or other monster.";
         case 12: return "Discover the nature of a strange location.";
         case 13: return "Pursue fleeing foes into dungeon.";
         case 14: return "Escape from captivity in dungeon.";
         case 15: return "Clear ruin so it can be reoccupied.";
         case 16: return "Discover villain's interested in dungeon.";
         case 17: return "Survive in dungeon for length of time.";
         case 18: return "Parley with villain in dungeon.";
         case 19: return "Hide from threat outside dungeon.";
         case 20: return ""; // roll twice, ignoring 20s
         default: return "Acquire treasure.";
      }
   }
   
   public String goalSwitchB(int n) {
      switch(n) {
         case 1: return "Find a dungeon"; // roll dungeon goal to find why
         case 2: return "Assess scope of disaster.";
         case 3: return "Escort (an) NPC(s) to destination.";
         case 4: return "Stealthily arrive at destination.";
         case 5: return "Stop monsters from raiding caravans/farms.";
         case 6: return "Establish trade with distant town.";
         case 7: return "Protect caravan traveling to distant town.";
         case 8: return "Map a new land.";
         case 9: return "Find a place to establish a colony.";
         case 10: return "Find a natural resource.";
         case 11: return "Hunt a specific monster.";
         case 12: return "Return home from a distant place.";
         case 13: return "Obtain information from reclusive hermit.";
         case 14: return "Locate object lost in the wilds.";
         case 15: return "Learn fate of expedition group.";
         case 16: return "Pursue fleeing enemies.";
         case 17: return "Scout size of approaching army.";
         case 18: return "Escape tyrannous reign of tyrant.";
         case 19: return "Protect wilderness site from attackers.";
         case 20: return ""; // roll twice, ignoring 20s
         default: return "Stop monsters from raiding caravans/farms.";
      }
   }
   
   public String goalSwitchC(int n) {
      switch(n) {
         case 1: return "Seize control of fortified location.";
         case 2: return "Defend location from attackers.";
         case 3: return "Retrieve object from secure location.";
         case 4: return "Retrieve object from caravan.";
         case 5: return "Salvage goods from lost vessel.";
         case 6: return "Break prisoner from prison camp.";
         case 7: return "Escape from jail or prison camp.";
         case 8: return "Complete obstacle course for reward.";
         case 9: return "Infiltrate fortified location.";
         case 10: return "Discover source of strange phenomenon.";
         case 11: return "Interfere with operation of business.";
         case 12: return "Rescue character from natural disaster.";
         default: return "Retrieve object from secure location.";
      }
   }
   
   public static void main(String[] args) {
   }
}