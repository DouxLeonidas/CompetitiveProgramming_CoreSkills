import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution4 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(solve(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static long solve(String line) {
		long total = 0L;
		StringBuilder current = new StringBuilder();
		int sign = 1;
		for (char c : line.toCharArray()) {
			if (c == '+' || c == '-') {
				total += sign * Integer.parseInt(current.toString());
				current.setLength(0);
				sign = c == '+' ? 1 : -1;
			} else {
				current.append(c);
			}
		}
		total += sign * Integer.parseInt(current.toString());
		return total;
	}

}
