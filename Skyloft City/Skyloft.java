/****************************************
* Last edited: 5/9/2017
* 
* Represents a single Skyloft city
****************************************/

public class Skyloft {
   // fields
   private String shape;
   private String size;
   private int population;
   private int decks;
   private String mooring;
   private String economy;
   private String economy2;
   private String government;
   private String taxes;
   private String wealth;
   private String cityFacilities;
   private String dockFacilities;
   private String defenses;
   private String lawCode;
   private int approval;
   
   // constructors
   public Skyloft() {
      shape = shapeSwitch(Dice.deeRoll(2,6));
      size = sizeSwitch(Dice.deeRoll(1,6));
      population = popSwitch(Dice.deeRoll(1,6));
      decks = deckSwitch(Dice.deeRoll(1,6));
      mooring = mooringSwitch(Dice.deeRoll(1,6),size);
      economy = economySwitch(Dice.deeRoll(1,6));
      economy2 = secondEconomy(Dice.deeRoll(1,6),economy);
      government = governmentSwitch(Dice.deeRoll(2,6));
      taxes = taxSwitch(Dice.deeRoll(1,6));
      wealth = wealthSwitch(Dice.deeRoll(1,6));
      cityFacilities = facilitySwitch(Dice.deeRoll(1,6),taxes);
      dockFacilities = facilitySwitch(Dice.deeRoll(1,6),taxes);
      defenses = defenseSwitch(Dice.deeRoll(1,6),economy,taxes);
      lawCode = lawSwitch(Dice.deeRoll(1,6));
      approval = approvalSwitch(Dice.deeRoll(2,6),
                                 taxes, wealth, lawCode);
   }
   
   // methods
   public String shapeSwitch(int n) {
      switch (n) {
         case 2: return "Elliptical";
         case 3: return "Hexagonal";
         case 4: return "Boat";
         case 5:
         case 6: return "Donut";
         case 7:
         case 8: return "Circular";
         case 9: return "Ocatagonal";
         case 10: return "Figure eight";
         case 11:
         case 12: return "Irregular";
         default: return "Circular";
      }
   }
   
   public String sizeSwitch(int n) {
      switch (n) {
         case 1: return "Tiny";
         case 2: return "Small";
         case 3: return "Medium";
         case 4: return "Big";
         case 5: return "Large";
         case 6: return "Massive";
         default: return "Medium";
      }
   }
   
   public int popSwitch(int n) {
      switch (n) {
         case 1: return Dice.deeRoll(2,6) * 10;
         case 2: return Dice.deeRoll(1,6) * 100;
         case 3: return Dice.deeRoll(2,6) * 100;
         case 4: return Dice.deeRoll(3,6) * 100 + 600;
         case 5: return Dice.deeRoll(1,6) * 1000 + 2000;
         case 6: return Dice.deeRoll(2,6) * 1000 + 6000;
         default: return Dice.deeRoll(2,6) * 100;
      }
   }
   
   public int deckSwitch(int n) {
      switch (n) {
         case 1:
         case 2: return 1;
         case 3:
         case 4: return 2;
         case 5: return 3;
         case 6: return 4;
         default: return 2;
      }
   }
   
   public String mooringSwitch(int n, String size) {
      switch (size) {
         case "Tiny":
         case "Small": n += 0; break;
         case "Medium": n += 1; break;
         case "Big": n += 2; break;
         case "Large": n += 3; break;
         case "Massive": n += 4; break;
         default: n += 1; break;
      }
      
      if (n == 1) return "nomadic";
      else if (n == 2) return "traveling";
      else if (n == 3) return "semi-permanent";
      else if (n == 4) return "stationary";
      else return "permanent";
   }
   
   public String economySwitch(int n) {
      switch (n) {
         case 1: return "Market";
         case 2: return "Artisan-tech";
         case 3: return "Artisan-animal";
         case 4: return "Service";
         case 5: return "Mixed";
         case 6: return "Pirate";
         default: return "Pirate";
      }
   }
   
   public String secondEconomy(int n, String e) {
      switch (e) {
         case "Mixed": n += 1;
         case "Piracy": return "None";
         default: n += 0;
      }
      
      switch (n) {
         case 1:
         case 2:
         case 3: return "Farming";
         case 4:
         case 5: return "None";
         case 6: return "Piracy";
         default: return "Farming";
      }
   }
   
   public String governmentSwitch(int n) {
      switch (n) {
         case 2: return "Democratic Oligarchy";
         case 3: return "Oligarchy/Plutarchy";
         case 4: return "Hereditary Oligarchy";
         case 5: return "Elected Demarchy";
         case 6: 
         case 7: return "No Official Government";
         case 8: return "Council Democracy";
         case 9: return "Direct Democracy";
         case 10: return "Cooperative Associations";
         case 11: return "Governor-led Bureaucracy";
         case 12: return "Unelected Theocracy";
         default: return "No Official Government";
      }
   }
   
   
   public String taxSwitch(int n) {
      switch (n) {
         case 1: return "None";
         case 2: return "Very Low";
         case 3: return "Low";
         case 4: return "Medium";
         case 5: return "High";
         case 6: return "Very High";
         default: return "Medium";
      }
   }
   
   public String wealthSwitch(int n) {
      switch (n) {
         case 1: return "Impoverished";
         case 2: return "Poor";
         case 3: return "Getting By";
         case 4: return "Comfortable";
         case 5: return "Wealthy";
         case 6: return "Rich";
         default: return "Getting By";
      }
   }
   
   public String facilitySwitch(int n, String tax) {
      n += (tax == "High") ? 1 : 0;
      n += (tax == "Very High") ? 2 : 0;
      
      switch (n) {
         case 1: return "Negligible";
         case 2: return "Poor";
         case 3: return "Adequate";
         case 4: return "Comfortable";
         case 5: return "Good";
         case 6:
         case 7:
         case 8: return "Excellent";
         default: return "Adequate";
      }
   }
   
   public String defenseSwitch(int n, String e, String tax) {
      n += (tax == "High") ? 1 : 0;
      n += (tax == "Very High") ? 2 : 0;
      
      switch (n) {
         case 1: return "No defenses";
         case 2: return "Natural defense";
         case 3:
            if (e != "piracy") return "Small navy";
            else return "Volunteers";
         case 4:
            if (e != "piracy") return "Natural defense & navy";
            else return "Natural defense & volunteers";
         case 5:
            if (e != "piracy") return "Large navy";
            else return "Large volunteer force";
         case 6:
         case 7:
         case 8:
            if (e != "piracy") return "Natural defense & navy";
            else return "Natural defense & volunteers";
         default: return "No defenses";
      }
   }
   
   public String lawSwitch(int n) {
      switch (n) {
         case 1: return "Vigilantism";
         case 2: return "Neighborhood watch";
         case 3: return "Minimal police force";
         case 4: return "New Orleans police";
         case 5: return "Cruel but fair police";
         case 6: return "Fascist police state";
         default: return "Minimal police force";
      }
   }
   
   public int approvalSwitch(int n, String tax, String w, String law) {
      n += (tax != "Very high") ? 0 : 1;
      
      switch (w) {
         case "Impoverished": n = n + 2; break;
         case "Poor": ++n; break;
         case "Wealthy": --n; break;
         case "Rich": n = n - 2; break;
         default: break;
      }
      
      return n;
   }
   
   @Override
   public String toString() {
//       private String shape;
//       private String size;
//       private int population;
//       private int decks;
//       private String mooring;
//       private String economy;
//       private String economy2;
//       private String government;
//       private String taxes;
//       private String wealth;
//       private String cityFacilities;
//       private String dockFacilities;
//       private String defenses;
//       private String lawCode;
//       private int approval;
      
      return String.format("%s %d-floor %s %s skyloft, %s with %s economy",
         size, decks, mooring, shape, government, economy);
   }
}