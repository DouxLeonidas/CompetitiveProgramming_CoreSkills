import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Solution3 {

   public static void main(String[] args) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      try {
         String line;
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            int n = Integer.parseInt(line);
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = 0;
            while (st.hasMoreTokens()) {
               arr[i] = Integer.parseInt(st.nextToken());
               ++i;
            }
            System.out.println(solve2(n, arr));
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static String solve2(int n, int[] arr) {
      BigDecimal bd = new BigDecimal("0");
      for (int i = 0; i < arr.length; ++i) {
         bd = bd.add(new BigDecimal(arr[i]));
         bd = bd.add(new BigDecimal(1.0/(double)arr[i]));
      }
      DecimalFormat df = new DecimalFormat("0.0000000000");
      return df.format(bd);
   }

   private static class Decimal {
      long numerator;
      long denominator;
      long integer;

      public Decimal(long integer, long numerator, long denominator) {
         this.integer = integer;
         this.numerator = numerator;
         this.denominator = denominator;
      }

      public void sum(Decimal d) {
         long GCD = gcd(d.denominator, this.denominator);
         long lcm = d.denominator * this.denominator / GCD;
         long num = lcm / d.denominator * d.numerator;
         num += lcm / this.denominator * this.numerator;

         long commonGCD = gcd(num, lcm);

         this.integer += d.integer;
         this.numerator = num / commonGCD;
         this.denominator = lcm / commonGCD;
      }

      @Override
      public String toString() {
         return integer + "(" + numerator + "/" + denominator + ")";
      }

      public double getValue() {
         return integer + (double)numerator / denominator;
      }

      private long gcd(long a, long b) {
         if (b == 0) return a;
         return gcd(b,a % b);
      }
   }

   private static String solve(int n, int[] arr) {
      if (arr.length == 0) return "0.0000000000";
      Decimal total = new Decimal(arr[0], 1, arr[0]);
      //System.out.println("\nSolving-.....");
      //System.out.println(total);
      for (int i = 1; i < arr.length; ++i) {
         total.sum(new Decimal(arr[i], 1, arr[i]));
         //System.out.println(total);
      }
      //return total.getResult();
      BigDecimal bd = new BigDecimal(total.integer);
      bd = bd.add(new BigDecimal((double)total.numerator / total.denominator));
      DecimalFormat df = new DecimalFormat("0.0000000000");
      return df.format(bd);
   }

}
