import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution3 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			BigInteger res = new BigInteger("0");
			int num;
			boolean onlyNines = true;
			while ((num = br.read()) != '\n') {
				if (num == '\r') break;
				res = res.add(BigInteger.ONE);
				if (num != '9') {
					onlyNines = false;
				}
			}
			if (onlyNines) res = res.add(BigInteger.ONE);
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
