import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 *
 * To modify the template, go to Preferences -> Editor -> File and Code Templates -> Other
 */

public class Solution1 {
   public static void main(String[] args) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String line;
      try {
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            int q = Integer.parseInt(br.readLine());
            int[][] queries = new int[q][2];
            for (int i = 0; i < q; ++i) {
               StringTokenizer st = new StringTokenizer(br.readLine());
               queries[i][0] = Integer.parseInt(st.nextToken()) - 1;
               queries[i][1] = Integer.parseInt(st.nextToken()) - 1;
            }
            int[][] count = precompute(line);
            solution(queries, count);
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      }
   }

   private static void solution(int[][] queries, int[][] count) {
      for (int[] query : queries) {
         int max = -1;
         char res = '?';
         int cur;
         for (int c = 0; c < count.length; ++c) {
            cur = count[c][query[1]];
            if (query[0] > 0) {
               cur -= count[c][query[0] - 1];
            }
            if (cur >= max) {
               max = cur;
               res = (char)(c + 'a');
            }
         }
         System.out.println(res);
      }
   }

   private static int[][] precompute(String line) {
      int[][] compute = new int[27][line.length()];
      compute[line.charAt(0)-'a'][0]++;
      for (int i = 1; i < line.length(); ++i) {
         for (int c = 0; c < compute.length; c++) {
            compute[c][i] = compute[c][i-1];
         }
         compute[line.charAt(i) - 'a'][i]++;
      }
      return compute;
   }
}