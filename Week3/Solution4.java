import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      try {
         String line;
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int[][] items = new int[n][2];
            for (int i = 0; i < n; ++i) {
               StringTokenizer item = new StringTokenizer(br.readLine());
               items[i][0] = Integer.parseInt(item.nextToken()); // W
               items[i][1] = Integer.parseInt(item.nextToken()); // V
            }
            int maxValue = solveBinaryKnapsack(n, w, items);
            System.out.println(maxValue);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static int solveBinaryKnapsack(int N, int W, int[][] items) {
      // Base case all or none items:
      long sum = 0;
      int res = 0;
      int min = Integer.MAX_VALUE;
      for (int[] item : items) {
         sum += item[0];
         res += item[1];
         min = Math.min(min, item[0]);
      }
      if (sum <= W) return res;
      if (W < min) return 0;

      HashMap<Integer, PriorityQueue<Integer>> levels = new HashMap<>();
      for (int[] item : items) {
         if (!levels.containsKey(item[0])) {
            levels.put(item[0], new PriorityQueue<>(Collections.reverseOrder()));
         }
         levels.get(item[0]).add(item[1]);
      }
      //System.out.println(levels);

      res = 0;
      int val = 1;
      for (int i = 0; i <= 30; ++i, val <<= 1) {
         if (!levels.containsKey(val)) continue;
         //System.out.println("Val: " + val + " -> " + levels);
         if ((W & val) > 0) {
            int additional = levels.get(val).poll();
            res += additional;
            //System.out.println("Adding: " + additional);
         }
         while (levels.get(val).size() >= 2) {
            int first = levels.get(val).poll();
            int second = levels.get(val).poll();
            if (!levels.containsKey(2 * val)) {
               levels.put(2 * val, new PriorityQueue<>(Collections.reverseOrder()));
            }
            levels.get(2 * val).add(first + second);
         }
         while (!levels.get(val).isEmpty()) {
            int value = levels.get(val).poll();
            if (!levels.containsKey(2 * val)) {
               levels.put(2 * val, new PriorityQueue<>(Collections.reverseOrder()));
            }
            levels.get(2 * val).add(value);
         }
      }

      return res;
   }

   /*1073741824*/
   private static int solveKnapsack(int N, int W, int[][] items) {
      int[][] dp = new int[W+1][N+1];
      for (int wi = 1; wi <= W; wi++) {
         for (int n = 1; n <= N; n++) {
            if (items[n-1][0] > wi) {
               dp[wi][n] = dp[wi][n-1];
            } else {
               dp[wi][n] = Math.max(dp[wi][n-1], dp[wi - items[n-1][0]][n-1] + items[n-1][1]);
            }
         }
      }
      return dp[W][N];
   }

}
