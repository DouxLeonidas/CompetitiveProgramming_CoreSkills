import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			int i = 0;
			while (st.hasMoreTokens()) {
				arr[i++] = Integer.parseInt(st.nextToken());
			}
			solve(arr, n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void solve(int[] arr, int n) {
		int max = Integer.MIN_VALUE;
		int imax = -1;
		int maxs = 0;
		for (int i = 0; i < n; ++i) {
			if (arr[i] > max) {
				max = arr[i];
				imax = i;
				maxs = 1;
			} else if (arr[i] == max) {
				maxs++;
				if (maxs == 3) {
					imax = i;
				}
			}
		}
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			if (i == imax) continue;
			res.append(arr[i] + " ");
		}
		res.deleteCharAt(res.length() - 1);
		System.out.println(res.toString());
	}

}
