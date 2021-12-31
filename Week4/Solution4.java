import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 *
 * To modify the template, go to Preferences -> Editor -> File and Code Templates -> Other
 */

public class Solution4 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) break;
                int n = Integer.parseInt(line);
                long[] arr = new long[n];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; ++i) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                solution(arr, n);
                printArr(arr);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

   private static void printArr(long[] arr) {
      System.out.print(arr[0]);
      for (int i = 1; i < arr.length; ++i) {
         System.out.print(" " + arr[i]);
      }
      System.out.println();
   }

   private static void solution(long[] arr, int n) {
       long[] prefixSum = new long[n+1];
       long[] suffixSum = new long[n+1];
       for (int i = 0; i < n; i++) {
           prefixSum[i+1] = prefixSum[i] + arr[i];
       }
       for (int i = n-1; i >= 0; i--) {
           suffixSum[i] = suffixSum[i+1] + arr[i];
       }
       long sum = prefixSum[n];
       for (int i = 0; i < n; i++) {
           prefixSum[i+1] = Math.min(prefixSum[i+1], prefixSum[i]);
       }
       for (int i = n-1; i >= 0; i--) {
           suffixSum[i] = Math.min(suffixSum[i+1], suffixSum[i]);
       }
       for (int i = 0; i < n; ++i) {
           arr[i] = sum - prefixSum[i] - suffixSum[i+1];
       }
   }

}