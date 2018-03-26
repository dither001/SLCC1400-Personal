
public class GenWorld {
   // fields
   private final DiceRoller dice = new DiceRoller();
   
   public int[] scores = new int[7];
   public String atmoType = "";
   public String tempType = "";
   public String hydroType = "";
   public String govType = "";
   public int techLevel = 0;
   public char portClass = 'X';
   public int portFee = 0;
   public String travelCode = "Green";
   
   public int[] factionGov = new int[4];
   public String[] factionStr = new String[4];
   public String[] factionDescrip = new String[4];
   
   public String gasGiant = "";
   public String[] bases = new String[6];
   
   public String[] tradeCodes = {
      "", "", "", "", "", "", "", "", "",
      "", "", "", "", "", "", "", "", ""
   };
   
   // atmosphere types
   public final String[] ATMO_TYPES = {
      "None", "Trace", "Very Thin (Tainted)",
      "Very Thin", "Thin (Tainted)", "Thin",
      "Standard", "Standard (Tainted)", "Dense",
      "Dense (Tainted)", "Exotic", "Corrosive",
      "Insidious", "Dense (High)", "Thin (Low)",
      "Unusual"
   };
   
   // temperature types
   public final String[] TEMP_TYPES = {
      "Frozen", "Cold", "Temperate", "Hot", "Roasting"
   };
   
   // hydrosphere types
   public final String[] HYDRO_TYPES = {
      "Dust Ball", "Wasteland", "Dead Seas",
      "Scattered Seas", "Wet World", "Large Oceans",
      "Near-Earth", "Earth-like", "Scattered Land",
      "Marine World", "Underwater"
   };
   
   // there are a total of 14 govs, Balk is index[7]
   public final String[] GOV_TYPES = {
      "None/Tribal/Anarchy", "Company/Corporation",
      "Participating democracy", "Self-perpetuating oligarchy",
      "Representative democracy", "Feudal technocracy",
      "Puppet government", "Balkanisation",
      "Civil Service bureaucracy", "Impersonal bureaucracy",
      "Charismatic dictatorship", "Non-charismatic leader",
      "Charismamatic oligarchy", "Religious dictatorship"
   };
   
   public final String[] TRADE_CODES = {
      "Ag", "As", "Ba", "De", "Fl", "Ga", "Hi", "Ht", "IC",
      "In", "Lo", "Lt", "NA", "NI", "Po", "Ri", "Va", "Wa"
   };
   
   // constructors
   GenWorld() {
      rollScores();
      rollFactions();
      checkPort();
      checkPortFee(portClass);
      checkTech();
      checkTrade();
      checkTravel();
      checkGiant();
      rollBases();
   }
   
   // methods
   public void checkGiant() {
      gasGiant = (dice.deeRoll(2,6) > 4) ? "Gas Giant" : "No Gas Giant";
   }
   
   public void rollScores() {
      scores[0] = dice.deeRoll(2,6) - 2;     // size
      scores[1] = atmoCheck(scores[0]);      // atmo
      scores[2] = tempCheck(scores[1]);      // temp
      scores[3] = hydroCheck(scores[0]);     // hydro
      scores[4] = dice.deeRoll(2,6) - 2;     // pop
      scores[5] = govCheck(scores[4]);       // gov
      scores[6] = lawCheck(scores[5]);       // law
   }
   
   public void rollBases() {
      bases[0] = checkNavy();
      bases[1] = checkScout();
      bases[2] = checkScience();
      bases[3] = checkConsul();
      bases[4] = checkTAS();
      bases[5] = checkPirate();
   }
   
   // generates atmosphere between 0-15
   public int atmoCheck(int size) {
      int n = size + dice.deeRoll(2,6) - 7;
      
      n = (n < 0) ? 0 : n;
      atmoType(n);
      minTech(n); // runs minTech method
      return n;
   }
   
   //
   public void atmoType(int atmo) {
      atmoType = ATMO_TYPES[atmo];
   }
   
   // minimum Tech level based on atmosphere
   public void minTech(int atmo) {
      switch(atmo) {
         case 0: techLevel = 8; break;    // 0, 1
         case 1: techLevel = 8; break;
         case 2: techLevel = 5; break;    // 2, 3
         case 3: techLevel = 5; break;
         case 4: techLevel = 3; break;    // 4, 7, 9
         case 7: techLevel = 3; break;
         case 9: techLevel = 3; break;
         case 10: techLevel = 8; break;   // 10
         case 11: techLevel = 9; break;   // 11
         case 12: techLevel = 10; break;  // 12
         case 13: techLevel = 5; break;   // 13, 14
         case 14: techLevel = 5; break;
         case 15: techLevel = 8; break;   // 15
         default: break;
      }
   }
   
   // rolls 2d6 and adds mods for world temp
   public int tempCheck(int atmo) {
      int n = dice.deeRoll(2,6);
      
      switch(atmo) {
         case 2: n -= 2; break;     // 2, 3
         case 3: n -= 2; break;
         case 4: n -= 1; break;     // 4, 5, 14
         case 5: n -= 1; break;
         case 8: n += 1; break;     // 8, 9
         case 9: n += 1; break;
         case 10: n += 2; break;    // 10, 13, 15
         case 11: n += 6; break;    // 11, 12
         case 12: n += 6; break;
         case 13: n += 2; break;
         case 14: n -= 1; break;
         case 15: n += 2; break;
         default: n += 0; break;    // 0-1, 6, 7
      }
      
      tempType(n);
      return n;
   }
   
   //
   public void tempType(int temp) {
      if (temp <= 2)
         tempType = TEMP_TYPES[0];
      else if (temp == 3 || temp == 4)
         tempType = TEMP_TYPES[1];
      else if (temp > 4 && temp < 10)
         tempType = TEMP_TYPES[2];
      else if (temp == 10 || temp == 11)
         tempType = TEMP_TYPES[3];
      else
         tempType = TEMP_TYPES[4];
   }
   
   // generates hydro score between 0-10
   public int hydroCheck(int size) {
      int n = size + dice.deeRoll(2,6) - 7;
      
      // adds modifier based on atmo
      switch (scores[1]) {
         case 0: n -= 4; break;
         case 1: n -= 4; break;
         case 10: n -= 4; break;
         case 11: n -= 4; break;
         case 12: n -= 4; break;
         default: break;
      }
      
      // check atmo for !13; then apply hot/roasting temp
      if (scores[1] != 13) {
         n = (scores[2] >= 10 && scores[2] <= 11) ? n - 2 : n;
         n = (scores[2] >= 12) ? n - 6 : n;
      }
      
      // sets hydro to 0 for size 0-1; or hydro 0-10
      n = (scores[0] <= 1) ? 0 : n;
      n = (n < 0) ? 0 : n;
      n = (n > 10) ? 10 : n;
      hydroType(n);
      return n;
   }
   
   //
   public void hydroType(int hydro) {
      hydroType = HYDRO_TYPES[hydro];
   }
   
   // generates government score between 0-13
   public int govCheck(int pop) {
      int n = pop + dice.deeRoll(2,6) - 7;
      
      // sets gov to 0 if pop is 0
      n = (scores[4] < 1) ? 0 : n;
      n = (n < 0) ? 0 : n;
      n = (n > 13) ? 13 : n;
      govType(n);
      return n;
   }
   
   public void govType(int gov) {
      govType = GOV_TYPES[gov];
   }
   
   public void rollFactions() {
      int n = numFactions();
      for (int i = 0; i < factionGov.length; ++i) {
         if (i <= n) {
            factionGov[i] = govCheck(scores[4]);
            factionStr[i] = factionStr();
            factionDescrip[i] = GOV_TYPES[factionGov[i]];
         }
         else {
            factionGov[i] = 0;
            factionStr[i] = "";
            factionDescrip[i] = "";
         }
      }
   }
   
   public int numFactions() {
      int n = dice.deeRoll(1,3);
      
      // scores[5] gov
      n = (scores[5] == 0 || scores[5] == 7) ? n + 1 : n;
      n = (scores[5] > 9) ? n - 1 : n;
      
      return n;
   }
   
   // determines faction strength
   public String factionStr() {
      String s = "";
      
      switch (dice.deeRoll(2,6)) {
         case 2: 
         case 3: s = "obscure"; break;
         case 4: 
         case 5: s = "fringe"; break;
         case 6: 
         case 7: s = "minor"; break;
         case 8: 
         case 9: s = "notable"; break;
         case 10: 
         case 11: s = "significant"; break;
         case 12: s = "popular"; break;
      }
      
      return s;
   }
   
   public int lawCheck(int gov) {
      int n = gov + dice.deeRoll(2,6) - 7;
      n = (n < 0) ? 0 : n;
      
      return n;
   }
   
   // rolls 2d6 and determines starport class
   public void checkPort() {
      switch (dice.deeRoll(2,6)) {
         case 2: portClass = 'X'; break;
         case 3:
         case 4: portClass = 'E'; break;
         case 5:
         case 6: portClass = 'D'; break;
         case 7:
         case 8: portClass = 'C'; break;
         case 9:
         case 10: portClass = 'B'; break;
         case 11:
         case 12: portClass = 'A'; break;
      }
   }
   
   // determines if tech is greater than minimum
   public void checkTech() {
      int n = dice.deeRoll(1,6);
      
      // starport bonus
      switch (portClass) {
         case 'A': n += 6; break;
         case 'B': n += 4; break;
         case 'C': n += 2; break;
         case 'X': n -= 4; break;
         default: break;
      }
      
      // size bonus
      n = (scores[0] < 2) ? ++n : n;
      n = (scores[0] < 5) ? ++n : n;
      
      // atmo bonus
      n = (scores[1] < 4 || scores[1] > 9) ? ++n : n;
      
      // hydro bonus
      n = (scores[3] == 0 || scores[3] == 9) ? ++n : n;
      n = (scores[3] == 10) ? n + 2 : n;
      
      // pop bonus
      n = (scores[4] > 0 && scores[4] < 6) ? ++n : n;
      
      if (scores[4] > 8 && scores[4] < 13) {
         ++n;
         n = (scores[4] > 9) ? ++n : n;
         n = (scores[4] > 10) ? ++n : n;
         n = (scores[4] > 11) ? ++n : n;
      }
      
      // gov bonus
      n = (scores[5] == 0 || scores[5] == 5) ? ++n : n;
      n = (scores[5] == 7) ? n + 2 : n;
      n = (scores[5] == 13 || scores[5] == 14) ? n - 2 : n;
      
      // compares to minTech (set earlier)
      n = (n < techLevel) ? techLevel : n;
      // finally, sets tech to 0 if pop is 0
      n = (scores[4] < 1) ? 0 : n;
      techLevel = n;
   }
   
   // checks for presence of naval base
   public String checkNavy() {
      int n = dice.deeRoll(2,6);
      String s = "";
      if (portClass == 'A' || portClass == 'B')
         s = (n > 7) ? "Navy" : "";

      return s;
   }
   
   // checks for presence of scout base
   public String checkScout() {
      int n = dice.deeRoll(2,6);
      String s = "";
      
      if (n > 9 && portClass == 'A')
         s = "Scout";
      if (n > 7 && (portClass == 'B' || portClass == 'C'))
         s = "Scout";
      if (n > 6 && portClass == 'D')
         s = "Scout";
         
      return s;
   }
   
   // checks for presence of consulate
   public String checkConsul() {
      int n = dice.deeRoll(2,6);
      String s = "";
      
      if (n > 5 && portClass == 'A')
         s = "Consul";
      if (n > 7 && portClass == 'B')
         s = "Consul";
      if (n > 9 && portClass == 'C')
         s = "Consul";
      
      return s;
   }
   
   // checks for presence of science lab
   public String checkScience() {
      int n = dice.deeRoll(2,6);
      String s = "";
      
      if (n > 7 && portClass == 'A')
         s = "Science";
      if (n > 9 && (portClass == 'B' || portClass == 'C'))
         s = "Science";
      
      return s;
   }
   
   // checks for presence of TAS outpost
   public String checkTAS() {
      int n = dice.deeRoll(2,6);
      String s = "";
      
      if (n > 3 && portClass == 'A')
         s = "TAS";
      if (n > 5 && portClass == 'B')
         s = "TAS";
      if (n > 9 && portClass == 'C')
         s = "TAS";
      
      return s;
   }
   
   // checks for presence of pirate base
   public String checkPirate() {
      int n = dice.deeRoll(2,6);
      String s = "";
      
      if (n > 9 && (portClass == 'B' || portClass == 'D' || portClass == 'E'))
         s = "Pirate";
      if (n > 11 && portClass == 'C')
         s = "Pirate";
      
      return s;
   }
   
   // takes portClass and returns Port Fee
   public void checkPortFee(char port) {
      switch (port) {
         case 'A': portFee = dice.deeRoll(1,6) * 1000; break;
         case 'B': portFee = dice.deeRoll(1,6) * 500; break;
         case 'C': portFee = dice.deeRoll(1,6) * 100; break;
         case 'D': portFee = dice.deeRoll(1,6) * 10; break;
         case 'E': 
         case 'X': portFee = 0; break;
      }
   }
   
   // checks for each trade code
   public void checkTrade() {
      
      if (scores[1] > 3 && scores[1] < 10)
         if (scores[3] > 3 && scores[3] < 9)
            if (scores[4] > 4 && scores[4] < 8)
               tradeCodes[0] = "Ag";
      
      if (scores[0] < 1 && scores[1] < 1 && scores[3] < 1)
         tradeCodes[1] = "As";
      
      if (scores[4] < 1 && scores[5] < 1 && scores[6] < 1)
         tradeCodes[2] = "Ba";
      
      if (scores[1] > 1 && scores[3] < 1)
         tradeCodes[3] = "De";
      
      if (scores[1] > 9 && scores[3] > 0)
         tradeCodes[4] = "Fl";
      
      if (scores[0] > 4)
         if (scores[1] > 3 && scores[1] < 10)
            if (scores[3] > 3 && scores[3] < 9)
               tradeCodes[5] = "Ga";
      
      tradeCodes[6] = (scores[4] > 8) ? "Hi" : "";
      tradeCodes[7] = (techLevel > 11) ? "Ht" : "";
      
      if (scores[1] == 0 || scores[1] == 1)
         tradeCodes[8] = (scores[3] > 11) ? "IC" : "";
      
      if (scores[4] > 8)
         if (scores[1] < 3)
            tradeCodes[9] = "In";
         else if ((scores[1] == 4) || (scores[1] == 7) || (scores[1] == 9))
            tradeCodes[9] = "In";
      
      tradeCodes[10] = (scores[4] > 0 && scores[4] < 4) ? "Lo" : "";
      tradeCodes[11] = (techLevel < 6) ? "LT" : "";
      
      if (scores[1] < 4 && scores[3] < 4 && scores[4] > 5)
         tradeCodes[12] = "NA";
      
      tradeCodes[13] = (scores[4] > 3 && scores[4] < 7) ? "NI" : "";
      
      if (scores[1] > 1 && scores[1] < 6)
         tradeCodes[14] = (scores[3] < 4) ? "Po" : "";
      
      if (scores[1] == 6 || scores[1] == 8)
         if (scores[4] > 5 && scores[4] < 9)
            tradeCodes[15] = "Ri";
      
      tradeCodes[16] = (scores[1] < 1) ? "Va" : "";
      tradeCodes[17] = (scores[3] > 9) ? "Wa" : "";
   }
   
   
   // checks for Amber travel code status
   public void checkTravel() {
      // exotic atmosphere
      travelCode = (scores[1] > 9) ? "Amber" : travelCode;
      
      // hostile or volatile government
      if (scores[5] == 0 || scores[5] == 7 || scores[5] == 10)
         travelCode = "Amber";
      
      // oppressive or non-existant law code
      travelCode = (scores[6] < 1 || scores[6] > 8) ? "Amber" : travelCode;
   }
}