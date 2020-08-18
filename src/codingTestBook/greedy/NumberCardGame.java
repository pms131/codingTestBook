package codingTestBook.greedy;

import java.util.Scanner;

public class NumberCardGame {

	public static void main(String[] args) {
		System.out.print("숫자를 입력하세요 ");
		Scanner scan = new Scanner(System.in);
		int answer = 0;
		

		int n = scan.nextInt();	// 행의 갯수 (1 <=N, m <= 100), 각 숫자는 1이상 10,000 이하
		int m = scan.nextInt();	// 열의 갯수
		
		int[][] cards = new int[m][n];
		int max = -1;
		
		for (int i=0; i<m; i++) {
			int min = 10001;
			
			for (int j=0; j<n; j++) {
				cards[i][j] = scan.nextInt();
				
				if (min > cards[i][j]) {			//헹의 최소값 구하기
					min = cards[i][j];
				}
			}

			if (max < min) {						//행 최소값의 최대값 구하기
				max = min;
			}
		}
		
		System.out.println(max);
	}

}
