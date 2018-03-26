
import java.util.ArrayList;

public class Starship {
   // fields
   private int shipHull = 0;
   private int shipConfig = 1;
   private int armorType = 0;
   private int armorAmt = 0;
   private int armorCost = 0;
   
   private final int[] HULL_TONS = {
      100, 200, 300, 400, 500,
      600, 700, 800, 900, 1000,
      1100, 1200, 1300, 1400, 1500,
      1600, 1700, 1800, 1900, 2000
   };
   
   private final int[] HULL_COST = {
      2, 8, 12, 16, 32,
      48, 64, 80, 90, 100,
      110, 120, 130, 140, 150,
      160, 170, 180, 190, 200
   };
   
   private final String[] CONFIGURATIONS = {
      "Streamlined", "Standard", "Distributed"
   };
   
   private final double[] CONFIG_COST = {
      1.10, 1.00, 0.90
   };
   
   private final String[] ARMOR_TYPES = {
      "None", "Titanium Steel", "Crystaliron", "Bonded Superdense"
   };
   
   private final int[] ARMOR_TL = {
      0, 7, 10, 14
   };
   
   private final int[] ARMOR_POINTS = {
      0, 2, 4, 6
   };
   
   private final double[] ARMOR_COST = {
      0.00, 0.05, 0.20, 0.50
   };
   
   private int bridgeTons = setBridge(HULL_TONS[shipHull]);
   private double bridgeCost = bridgeCost(HULL_TONS[shipHull]);
   
   private int staterooms = 1;
   private int stateroomTons = setRoomTons(staterooms);
   private double stateroomCost = setRoomCost(staterooms);
   
   private int lowPassage = 0;
   private double lowPassTons = setLowTons(lowPassage);
   private double lowPassCost = setLowCost(lowPassage);
   
   private int hardpoints = setHardpoints(HULL_TONS[shipHull]);
   
   private static ArrayList<Component> componentList = new ArrayList<>();
   
   private double fuel = jumpFuel(HULL_TONS[shipHull]); // + twoWeeksFuel(pDrive);
   private int cargoHold = setCargoHold(HULL_TONS[shipHull],componentList);
   
   // constructors
   public Starship() {
//       Drive jumpDriveA = new Drive();
      componentList.add(new Drive());
      componentList.add(new Computer());
      componentList.add(new Electronics());
   }
   
   // methods
   
   // TODO insert int jump distance
   public double jumpFuel(int tons) { // int dist
      return 0.1 * tons * 1; // multiply by dist
   }
   
   public int twoWeeksFuel(int drive) {
      return drive * 2 + 2;
   }

   public int setBridge(int hull) {
      int n = 0;
      
      n += (hull <= 200) ? 10 : 0;
      n += (hull >= 300 && hull <= 1000) ? 20 : 0;
      n += (hull >= 1100 && hull <= 2000) ? 40 : 0;
      n += (hull > 2000) ? 60 : 0;
      
      return n;
   }
   
   public double bridgeCost(int hull) {
      return hull * 0.5;
   }
   
   public int setRoomTons(int rooms) {
      return rooms * 4;
   }
   
   public double setRoomCost(int rooms) {
      return rooms * 0.05;
   }
   
   public double setLowTons(int lowPass) {
      return lowPass; // TODO
   }
   
   public double setLowCost(int lowPass) {
      return lowPass; // TODO
   }
   
   public int setHardpoints(int hull) {
      return hull / 50;
   }
   
   public int setCargoHold(int hull, ArrayList<Component> list) {
      return hull; // TODO
   }
}