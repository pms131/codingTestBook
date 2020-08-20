package codingTestBook.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AntWarrior {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();		// (3 <= n <= 100)
		
		scan.nextLine();
		
		String str = scan.nextLine();
		
		StringTokenizer st = new StringTokenizer(str);
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i=0; i<n; i++) {
			int val = Integer.parseInt(st.nextToken());
			list.add(val);
		}
		
		int[] dp = new int[n];
		

		dp[0] = list.get(0);
		dp[1] = list.get(1);
		
		
		
		for (int i = 2; i <n; i++) {
			dp[i] = Math.max(dp[i-2] + list.get(i), dp[i-1]);
		}
		
		
		System.out.println(dp[n-1]);
	}

}
