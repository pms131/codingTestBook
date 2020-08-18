package codingTestBook.greedy;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BigNumberRule {

	public static void main(String[] args) {
		System.out.print("숫자를 입력하세요 ");
		Scanner scan = new Scanner(System.in);
		int[] list = {2, 4, 5, 4, 6};
		int answer = 0;

		int n = scan.nextInt();	// 배열의 크기 (2 <= N <= 1,000)
		int m = scan.nextInt();	// 숫자가 더해지는 횟수 (1 <= M <= 10,000)
		int k = scan.nextInt();	// 연속해서 사용할 수 있는 횟수 (1 <= K <= 10,000)
		
		list = IntStream.of(list).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();
		
		/* 내 풀이 */
		/*
		for (int i=0; i<m; i++) {
			if (i != 0 && i%k == 0) {
				answer += list[1];
			} else {
				answer += list[0];
			}
		}
		*/
		
		/* 정답 풀이 */
		int cnt = (m / (k+1)) * k;
		cnt += m % (k+1);
		
		answer += cnt * list[0];
		answer += (m - cnt) * list[1];
		
		System.out.println(answer);
	}

}
