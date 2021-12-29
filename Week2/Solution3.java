import java.io.BufferedReader;
import java.io.InputStreamReader;
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
				System.out.println(solve(n, arr));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static long solve(int n, int[] arr) {
		long total = 0L;
		for (int size = n; size >= 1; --size) {
			for (int i = 0; i < size; ++i) {
				total += arr[i];
				if (i + 1 < size)
				arr[i] = Math.min(arr[i], arr[i+1]);
			}
		}
		return total;
	}

}
