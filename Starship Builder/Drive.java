
public class Drive extends Component {
   // fields
   private final char[] DRIVE_CODES = {
      'A', 'B', 'C', 'D', 'E', 'F',
      'G', 'H', 'J', 'K', 'L', 'M',
      'N', 'P', 'Q', 'R', 'S', 'T',
      'U', 'V', 'W', 'X', 'Y', 'Z'
   };
   
   private int jDrive = 0;
   private int mDrive = 0;
   private int pDrive = 0;
   
   private int jTons = setJTons(jDrive);
   private int mTons = setMTons(mDrive);
   private int pTons = setPTons(pDrive);
   
   private int jCost = setJCost(jDrive);
   private int mCost = setMCost(mDrive);
   private int pCost = setPCost(pDrive);
   
   // constructors
   
   // methods
   public int setJTons(int drive) {
      return drive * 5 + 10;
   }
   
   public int setJCost(int drive) {
      return drive * 10 + 10;
   }
   
   public int setMTons(int drive) {
      int n = drive * 2 + 1;
      n += (n < 1) ? 1 : 0;
      return n;
   }
   
   public int setMCost(int drive) {
      return drive * 4 + 4;
   }
   
   public int setPTons(int drive) {
      return drive * 3 + 4;
   }
   
   public int setPCost(int drive) {
      return drive * 8 + 8;
   }
   
   public int minDrive(int hull) {
      int n = (hull % 200 != 0) ? hull / 200 : hull / 200 - 1;
      return n;
   }
   
   public void minPower(int j, int m, int p) {
      p = (j >= m) ? j : m;
   }
}