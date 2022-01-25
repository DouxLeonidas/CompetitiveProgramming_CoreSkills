import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 *
 * To modify the template, go to Preferences -> Editor -> File and Code Templates -> Other
 */

public class Solution4 {
   public static void main(String[] args) {
      String line;
      InputStreamReader ir = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(ir);
      try {
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] mat = new int[n][n];
            for (int row = 0; row < n; row++) {
               st = new StringTokenizer(br.readLine());
               for (int col = 0; col < n; ++col) {
                  mat[row][col] = Integer.parseInt(st.nextToken());
               }
            }
            solve(n, k, mat);
         }
      } catch(Exception ex) {
         ex.printStackTrace();
      }
   }

   private static void solve(int n, int k, int[][] mat) {
      for (int row = 0; row < n; ++row) {
         for (int col = 0; col < n; ++col) {
            int sum = mat[row][col];
            if (row > 0) {
               sum += mat[row - 1][col];
            }
            if (col > 0) {
               sum += mat[row][col - 1];
            }
            if (row > 0 && col > 0) {
               sum -= mat[row-1][col-1];
            }
            mat[row][col] = sum;
         }
      }
      int max = 0;
      for (int row = k - 1; row < n; ++row) {
         for (int col = k - 1; col < n; ++col) {
            int sum = mat[row][col];
            if (row - k >= 0) {
               sum -= mat[row - k][col];
            }
            if (col - k >= 0) {
               sum -= mat[row][col - k];
            }
            if (row - k >= 0 && col - k >= 0) {
               sum += mat[row-k][col-k];
            }
            max = Math.max(max, sum);
         }
      }
      System.out.println(max);
   }
}