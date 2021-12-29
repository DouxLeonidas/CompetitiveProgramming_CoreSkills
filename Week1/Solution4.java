import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.isEmpty()) break;
				System.out.println(solve(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String solve(String line) {
		StringTokenizer st = new StringTokenizer(line);
		char kind = 'N';
		boolean[] nums = new boolean[15];
		while (st.hasMoreTokens()) {
			String card = st.nextToken();
			if (kind == 'N' || card.charAt(1) == kind) {
				kind = card.charAt(1);
				switch(card.charAt(0)) {
					case 'A': nums[1] = true; nums[14] = true; break;
					case 'K': nums[13] = true; break;
					case 'Q': nums[12] = true; break;
					case 'J': nums[11] = true; break;
					case 'T': nums[10] = true; break;
					default: nums[card.charAt(0) - '0'] = true;
				}
			} else {
				return "NO";
			}
		}
		
		int consec = 0;
		int max = 0;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i]) {
				consec++;
				if (consec > max) {
					max = consec;
				}
			} else {
				consec = 0;
			}
		}
		return (max == 5) ? "YES" : "NO";
	}

}
