import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.isEmpty()) break;
				StringTokenizer st = new StringTokenizer(line);
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int maxKings = solve(r, c);
				System.out.println(maxKings);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int solve(int r, int c) {
		return r * c - spaces(r) * spaces(c);
	}

	private static int spaces(int c) {
		return (int)Math.ceil((double)c / 3);
	}

}
