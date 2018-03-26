
public class StarGen {
   // fields
   public char starType = '?';
   public String starSize = "";
   
   // Spectral type F is index 3 (7 total)
   private final char[] SPECTRAL_TYPES = {
     'O', 'B', 'A', 'F', 'G', 'K', 'M'
   };
   
   // star sizes
   private final String[] STAR_SIZES = {
      "Ia", "Ib", "II", "III", "IV", "V", "VI", "Dw"
   };
   
   // constructors
   public StarGen(int type, int size) {
      switch (type) {
         case 2: starType = SPECTRAL_TYPES[2]; break;
         case 3:
         case 4:
         case 5:
         case 6:
         case 7: starType = SPECTRAL_TYPES[6]; break;
         case 8: starType = SPECTRAL_TYPES[5]; break;
         case 9: starType = SPECTRAL_TYPES[4]; break;
         case 10:
         case 11:
         case 12: starType = SPECTRAL_TYPES[3]; break;
         default: starType = SPECTRAL_TYPES[6]; break;
      }
      
      switch (size) {
         case 2: starSize = STAR_SIZES[2]; break;
         case 3: starSize = STAR_SIZES[3]; break;
         case 4: starSize = STAR_SIZES[4]; break;
         case 5: 
         case 6:
         case 7:
         case 8:
         case 9:
         case 10: starSize = STAR_SIZES[5]; break;
         case 11: starSize = STAR_SIZES[6]; break;
         case 12: starSize = STAR_SIZES[7]; break;
         default: starSize = STAR_SIZES[5]; break;
      }
   }
   
   
   // methods
   
}