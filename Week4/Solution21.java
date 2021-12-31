import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 */

public class Solution21 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line;
        try {
            while ((line = br.readLine()) != null) {
               if (line.isEmpty()) break;
               int n = Integer.parseInt(line);
               int[] candidates = new int[4];
               int maxDist = Integer.MIN_VALUE;
               int minDist = Integer.MAX_VALUE;
               int maxSum = Integer.MIN_VALUE;
               int minSum = Integer.MAX_VALUE;
               for (int i = 1; i <= n; ++i) {
                   StringTokenizer st = new StringTokenizer(br.readLine());
                   int x = Integer.parseInt(st.nextToken());
                   int y = Integer.parseInt(st.nextToken());
                   if (x + y > maxSum) {
                      maxSum = x + y;
                      candidates[0] = i;
                   }
                   if (x + y < minSum) {
                      minSum = x + y;
                      candidates[1] = i;
                   }
                   if (x - y > maxDist) {
                      maxDist = x - y;
                      candidates[2] = i;
                   }
                   if (x - y < minDist) {
                      minDist = x - y;
                      candidates[3] = i;
                   }
                   if (maxSum - minSum > maxDist - minDist) {
                      System.out.println(candidates[0] + " " + candidates[1]);
                   } else {
                      System.out.println(candidates[2] + " " + candidates[3]);
                   }
               }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}