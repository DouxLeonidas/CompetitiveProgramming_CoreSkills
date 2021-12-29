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
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int sol = solution(x, y);
				System.out.println(sol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int solution(int x, int y) {
		return (int)Math.ceil((double)x / y);
	}

}
