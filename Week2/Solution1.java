import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {

   public static void main(String[] args) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      try {
         String line;
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            int n = Integer.parseInt(line);
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; ++row) {
               StringTokenizer st = new StringTokenizer(br.readLine());
               int col = 0;
               while (st.hasMoreTokens()) {
                  matrix[row][col] = Integer.parseInt(st.nextToken());
                  col++;
               }
            }
            System.out.println(solve(n, matrix));
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static String solve(int n, int[][] matrix) {
      int[] permutation = new int[n];
      String res = "";
      long minCost = Long.MAX_VALUE;
      for (int i = 0; i < n; ++i) {
         permutation[i] = i + 1;
      }
      int fact = factorial(n);
      for (int i = 0; i < fact; ++i) {
         long cost = getCost(permutation, matrix, n);
         if (cost < minCost) {
            minCost = cost;
            res = arrToString(permutation, n);
         }
         nextPermutation(permutation);
      }
      return res;
   }

   private static int factorial(int n) {
      int f = 1;
      for (int i = 1; i <= n; ++i) {
         f *= i;
      }
      return f;
   }

   private static String arrToString(int[] permutation, int n) {
      StringBuilder sb = new StringBuilder();
      sb.append(permutation[0]);
      for (int i = 1; i < n; ++i) {
         sb.append(" " + permutation[i]);
      }
      return sb.toString();
   }

   private static long getCost(int[] permutation, int[][] matrix, int n) {
      long cost = 0;
      for (int i = 0; i < n - 1; ++i) {
         cost += matrix[permutation[i] - 1][permutation[i+1] - 1];
      }
      return cost;
   }

   public static void nextPermutation(int[] nums) {
      int i = nums.length - 2;
      while (i >= 0 && nums[i] >= nums[i+1]) --i;
      if (i >= 0) {
         int j = nums.length - 1;
         while (nums[j] <= nums[i]) --j;
         swap(nums, i, j);
      }
      reverse(nums, i+1);
   }

   private static void reverse(int[] nums, int start) {
      int i = start, j = nums.length - 1;
      while (i < j) {
         swap(nums, i, j);
         ++i;
         --j;
      }
   }

   private static void swap(int[] nums, int i, int j) {
      int aux = nums[i];
      nums[i] = nums[j];
      nums[j] = aux;
   }

}