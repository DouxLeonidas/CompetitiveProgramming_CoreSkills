import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {

   private static final String[] outcome = new String[]{"SUM(A)<SUM(B)",
                                                        "SUM(A)=SUM(B)",
                                                        "SUM(A)>SUM(B)"};

   public static void main(String[] args) {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String line;
      try {
         while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            int n = Integer.parseInt(line);
            int[] a = readArray(n, br.readLine());
            int[] b = readArray(n, br.readLine());
            solution(a, b);
         }
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   private static void solution(int[] a, int[] b) {
      // TODO Auto-generated method stub
      int out = Integer.compare(sum(a), sum(b)) + 1;
      System.out.println(outcome[out]);
   }

   private static int sum(int[] a) {
      int sum = 0;
      for (int i = 0; i < a.length; ++i) {
         sum += a[i];
      }
      return sum;
   }

   private static int[] readArray(int n, String line) {
      StringTokenizer st = new StringTokenizer(line);
      int[] array = new int[n];
      for (int i = 0; i < n && st.hasMoreTokens(); ++i) {
         String token = st.nextToken();
         int a = token.indexOf('.');
         if (a > 0) token = token.substring(0,a) + token.substring(a+1);
         array[i] = Integer.parseInt(token);
      }
      return array;
   }
}
