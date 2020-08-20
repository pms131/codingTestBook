package codingTestBook.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class makeOne {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();		// (1 <= x <= 30,000)
		
		/* 내 풀이
		 * 
		int answer = 0;
		
		while (x != 1) {
			int tmp = 5* (x/5);
			answer += x - tmp;
			x = tmp;
			
			if (x >= 5) {
				x /= 5;
			} else if (x >= 3) {
				x /= 3;
			} else {
				x /=2;
			}
			answer++;
		}
		
		System.out.println(answer);
		
		*/
		
		/************* dp 정답 *************/
		
		int[] dp = new int[30001];
		
		dp[0] = 0;
		dp[1] = 0;
		
		for (int i = 2; i <= x; i++) {
			dp[i] = dp[i-1] + 1;
			
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			else if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			else if (i % 5 == 0)
				dp[i] = Math.min(dp[i], dp[i/5]+1);
		}
		
		System.out.println(dp[x]);
	}

}
