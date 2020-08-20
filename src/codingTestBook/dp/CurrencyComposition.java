package codingTestBook.dp;

import java.util.Arrays;
import java.util.Scanner;

public class CurrencyComposition {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();		// (1 <= n <= 100)
		int m = scan.nextInt();		// (1 <= m<= 10,000)

		int[] currency = new int[n];
		
		int[] dp = new int[m+1];
		Arrays.fill(dp, 10001);
		
		for (int i=0; i<n; i++) {
			int val = scan.nextInt();
			currency[i] = val;
		}
		
		dp[0] = 0;
		for (int i=0; i<n; i++) {
			for (int j=currency[i]; j <= m; j++ ) {
				if (dp[j - currency[i]] != 10001) {
					dp[j] = Math.min(dp[j], dp[j-currency[i]] + 1);
				}
			}
		}
		
		if (dp[m] == 10001)
			System.out.println(-1);
		else
			System.out.println(dp[m]);
		
	}

}
