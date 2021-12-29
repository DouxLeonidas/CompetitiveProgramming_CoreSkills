import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String num = br.readLine();
			StringTokenizer st = new StringTokenizer(num);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			System.out.println(solve(x,y,z));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int solve(int x, int y, int z) {
		int inc = x - y;
		if (z == 0) return 0;
		if (inc == 0) {
			if (x == z) {
				return 1;
			} else {
				return -1;
			}
		} else if (inc < 0) {
			int idx = 1;
			for (int i = x; i > 0; i += inc, idx += 2) {
				if (z == i) return idx;
			}
			return -1;
		} else {
			int i = 0;
			int idx = 0;
			while (i <= z) {
				int hi = i + x;
				idx++;
				if (z == hi) {
					return idx;
				}
				i = hi - y;
				idx++;
				if (z == i) {
					return idx;
				}
			}
			return -1;
		}
		// 0 9 -1 8 -2 7
	}

}
