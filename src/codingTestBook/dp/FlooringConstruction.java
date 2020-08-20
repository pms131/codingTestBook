package codingTestBook.dp;

import java.util.Scanner;

public class FlooringConstruction {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();		// (1 <= n <= 1,000)
		
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		
		for (int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2] * 2 ) % 796796;
		}
		
		System.out.println(dp[n]);
	}

}
