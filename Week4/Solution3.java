import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Accomplished using the EduTools plugin by JetBrains https://plugins.jetbrains.com/plugin/10081-edutools
 */

public class Solution3 {
    public static void main(String[] args) {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) break;
                int n = Integer.parseInt(line);
                int[] histogram = new int[100_002];
                for (int range = 0; range < n; range++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    histogram[start]++;
                    histogram[end+1]--;
                }
                int count = 0;
                for (int i = 1; i <= 100_000; ++i) {
                   count += histogram[i];
                   if (count > 0) {
                      System.out.println(i + " " + count);
                   }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}