package codingTestBook.greedy;

import java.util.Scanner;

public class UntilBeOne {

	public static void main(String[] args) {
		System.out.print("숫자를 입력하세요 ");
		Scanner scan = new Scanner(System.in);
		

		int n = scan.nextInt();	// (2 <= N <= 100,000)
		int k = scan.nextInt();	// (2 <= K <= 100,000)
		
		
		int num = n;
		int count = 0;
		
		
		
			
		/* 내 풀이 */
		/*
		 while (num != 1) {
			if (num % k == 0)
				num /= k;
			else
				num -=1;
			
			count++;
		}
		*/
			
		/* 정답 */
		while (true) {
			int target = (n / k) * k;	// 딱 나누어 떨어지는 수
			count += (n - target);		// n에서 딱 떨어지는 수까지 카운트
			
			n = target;					// 이제 n은 딱 나누어 떨이지는 수
			
			if (n < k)
				break;
			
			count++;					// 나누어야 하기 때문에 count + 1
			n /= k;
		}
		
		count += (n -1);				// 남은 수를 1로 만들기 위해 카운트에 n-1을 더해줌
		System.out.println(count);
		
		return ;
	}
	
}
