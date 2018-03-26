/****************************************
* Last edited: 5/17/2017
* 
* 
****************************************/

public class Monster {
   private enum Terrain {CLEAR, PLAINS, DESERT, HILLS, MOUNTAIN,
                           FOREST, WOODS, JUNGLE, RAINFOREST,
                           ROUGH, SWAMP, SHORE, RIVER,
                           OCEAN_DEEP, OCEAN_OPEN, OCEAN_SHOAL}
   private enum Diet {SCAVENGER, OMNIVORE, HERBIVORE, CARNIVORE}
   private enum Role {CARRION_EATER, CHASER, EATER, FILTER, GATHERER,
                        GRAZER, HUNTER, HIJACKER, INTIMIDATOR, KILLER,
                        INTERMITTENT, POUNCER, REDUCER, SIREN, TRAPPER}
   private enum Move {AMPHIBIOUS, FLYER, SWIMMER, WALKER}
   
   // fields
   private Terrain terrain;
   private Diet diet;
   private Move move;
   private Role role;
   
   private int size;
   private int weight;
   
   private int strength;
   private int dexterity;
   private int endurance;
   private int intelligence;
   private int instinct;
   private int pack;
   
   // constructors
   public Monster() {
      terrain = terrainSwitch(Dice.deeRoll(1,16));
      diet = dietSwitch(Dice.deeRoll(2,6));
      move = moveSwitch(terrain,Dice.deeRoll(1,16));
      role = roleSwitch(Dice.deeRoll(2,6));
      size = sizeRoll(Dice.deeRoll(2,6));
      strength = strengthRoll();
   }
   
   // methods
   public Terrain terrainSwitch(int n) {
      switch (n) {
         case 1: return Terrain.CLEAR;
         case 2: return Terrain.PLAINS;
         case 3: return Terrain.DESERT;
         case 4: return Terrain.HILLS;
         case 5: return Terrain.MOUNTAIN;
         case 6: return Terrain.FOREST;
         case 7: return Terrain.WOODS;
         case 8: return Terrain.JUNGLE;
         case 9: return Terrain.RAINFOREST;
         case 10: return Terrain.ROUGH;
         case 11: return Terrain.SWAMP;
         case 12: return Terrain.SHORE;
         case 13: return Terrain.RIVER;
         case 14: return Terrain.OCEAN_DEEP;
         case 15: return Terrain.OCEAN_OPEN;
         case 16: return Terrain.OCEAN_SHOAL;
         default: return Terrain.WOODS;
      }
   }
   
   public Diet dietSwitch(int n) {
      switch (n) {
         case 2: return Diet.SCAVENGER;
         case 3: return Diet.OMNIVORE;
         case 4: return Diet.SCAVENGER;
         case 5: return Diet.OMNIVORE;
         case 6: return Diet.HERBIVORE;
         case 7: return Diet.HERBIVORE;
         case 8: return Diet.HERBIVORE;
         case 9: return Diet.CARNIVORE;
         case 10: // unusual event or natural feature
         case 11: return Diet.CARNIVORE;
         case 12: return Diet.CARNIVORE;
         default: return Diet.HERBIVORE;
      }
   }
   
   public Move moveSwitch(Terrain t, int n) {
      switch (t) {
         case CLEAR: moveA(n);
         case PLAINS: moveA(n);
         case DESERT: moveB(n);
         case HILLS: moveB(n);
         case MOUNTAIN: moveC(n);
         case FOREST: moveB(n);
         case WOODS: moveA(n);
         case JUNGLE: moveA(n);
         case RAINFOREST: moveA(n);
         case ROUGH: moveB(n);
         case SWAMP: moveD(n);
         case SHORE: moveD(n);
         case RIVER: moveE(n);
         case OCEAN_DEEP: moveF(n);
         case OCEAN_OPEN: moveF(n);
         case OCEAN_SHOAL: return Move.SWIMMER;
         default: return Move.WALKER;
      }
   }
   
   // clear, plains, woods, jungle, rainforest
   public Move moveA(int n) {
      switch (n) {
         case 1: return Move.WALKER;
         case 2: return Move.WALKER;
         case 3: return Move.WALKER;
         case 4: return Move.WALKER;
         case 5: return Move.WALKER;
         case 6: return Move.FLYER;
         default: return Move.WALKER;
      }
   }
   
   // desert, hills, forest, rough
   public Move moveB(int n) {
      switch (n) {
         case 1: return Move.WALKER;
         case 2: return Move.WALKER;
         case 3: return Move.WALKER;
         case 4: return Move.WALKER;
         case 5: return Move.FLYER;
         case 6: return Move.FLYER;
         default: return Move.WALKER;
      }
   }
   
   // mountain
   public Move moveC(int n) {
      switch (n) {
         case 1: return Move.WALKER;
         case 2: return Move.WALKER;
         case 3: return Move.WALKER;
         case 4: return Move.FLYER;
         case 5: return Move.FLYER;
         case 6: return Move.FLYER;
         default: return Move.WALKER;
      }
   }
   
   // swamp, shore
   public Move moveD(int n) {
      switch (n) {
         case 1: return Move.SWIMMER;
         case 2: return Move.AMPHIBIOUS;
         case 3: return Move.WALKER;
         case 4: return Move.WALKER;
         case 5: return Move.FLYER;
         case 6: return Move.FLYER;
         default: return Move.WALKER;
      }
   }
   
   // river
   public Move moveE(int n) {
      switch (n) {
         case 1: return Move.SWIMMER;
         case 2: return Move.AMPHIBIOUS;
         case 3: return Move.WALKER;
         case 4: return Move.WALKER;
         case 5: return Move.WALKER;
         case 6: return Move.FLYER;
         default: return Move.WALKER;
      }
   }
   
   // shoal, open
   public Move moveF(int n) {
      switch (n) {
         case 1: return Move.SWIMMER;
         case 2: return Move.SWIMMER;
         case 3: return Move.SWIMMER;
         case 4: return Move.SWIMMER;
         case 5: return Move.FLYER;
         case 6: return Move.FLYER;
         default: return Move.SWIMMER;
      }
   }
   
   public Role roleSwitch(int n) {
      switch (terrain) {
         case CLEAR: n += 3; break;
         case PLAINS: n += 4; break;
         case DESERT: n += 3; break;
         case HILLS: break;
         case MOUNTAIN: break;
         case FOREST: n -= 4; break;
         case WOODS: n -= 2; break;
         case JUNGLE: n -= 4; break;
         case RAINFOREST: n -= 2; break;
         case ROUGH: n -= 3; break;
         case SWAMP: n -= 2; break;
         case SHORE: n += 3; break;
         case RIVER: n += 1; break;
         case OCEAN_DEEP: 
         case OCEAN_OPEN: 
         case OCEAN_SHOAL: n += 4; break;
         default: break;
      }
      
      switch (diet) {
         case SCAVENGER: scavengerSwitch(n);
         case OMNIVORE: omnivoreSwitch(n);
         case HERBIVORE: herbivoreSwitch(n);
         case CARNIVORE: carnivoreSwitch(n);
         default:
            if (diet == Diet.SCAVENGER) return Role.CARRION_EATER;
            else if (diet == Diet.OMNIVORE) return Role.HUNTER;
            else if (diet == Diet.HERBIVORE) return Role.GRAZER;
            else return Role.CHASER;
      }
   }
   
   public Role scavengerSwitch(int n) {
      if (n % 4 == 0) return Role.INTIMIDATOR;
      else if (n % 4 == 1) return Role.CARRION_EATER;
      else if (n % 4 == 2) return Role.REDUCER;
      else return Role.HIJACKER;
   }
   
   public Role omnivoreSwitch(int n) {
      if (n % 3 == 0) return Role.HUNTER;
      else if (n % 3 == 1) return Role.GATHERER;
      else return Role.EATER;
   }
   
   public Role carnivoreSwitch(int n) {
      if (n % 5 == 0) return Role.TRAPPER;
      else if (n % 5 == 1) return Role.POUNCER;
      else if (n % 5 == 2) return Role.SIREN;
      else if (n % 5 == 3) return Role.KILLER;
      else return Role.CHASER;
   }
   
   public Role herbivoreSwitch(int n) {
      if (n <= 2) return Role.FILTER;
      else if (n >= 3 && n <= 6) return Role.INTERMITTENT;
      else return Role.GRAZER;
   }
   
   public int sizeRoll(int n) {
      switch (terrain) {
         case DESERT: n -= 3; break;
         case FOREST: n -= 4; break;
         case WOODS: n -= 1; break;
         case JUNGLE: n -= 3; break;
         case RAINFOREST: n -= 2; break;
         case ROUGH: n -= 3; break;
         case SWAMP: n += 4; break;
         case SHORE: n += 2; break;
         case RIVER: n += 1; break;
         case OCEAN_DEEP: n += 2; break;
         case OCEAN_OPEN: n -= 4; break;
         case OCEAN_SHOAL: n += 1; break;
         default: break;
      }
      
      return n;
   }
   
   public int strengthRoll() {
      int n = 0;
      
      switch (size) {
         case 1: n = 1; break;
         case 2: n = 2; break;
         case 3: 
         case 4: n = Dice.deeRoll(1,6); break;
         case 5: 
         case 6: n = Dice.deeRoll(2,6); break;
         case 7: 
         case 8: n = Dice.deeRoll(3,6); break;
         case 9: 
         case 10: n = Dice.deeRoll(4,6); break;
         case 11: n = Dice.deeRoll(5,6); break;
         case 12: n = Dice.deeRoll(6,6); break;
         case 13: n = Dice.deeRoll(7,6); break;
         default:
            if (size < 1) n = 1;
            else n = Dice.deeRoll(7,6);
            break;
      }
      
      return n;
   }
   
   public static void main(String[] args) {
   }
}