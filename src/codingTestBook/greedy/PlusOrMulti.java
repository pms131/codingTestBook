package codingTestBook.greedy;

import java.util.Scanner;

public class PlusOrMulti {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		String str = sc.next();

		
		
		char[] chArr = str.toCharArray();
		int answer = Character.getNumericValue(chArr[0]);
		for (int i=1; i<chArr.length; i++) {
			int num = Character.getNumericValue(chArr[i]);
			if (answer == 0)
				answer += num;
			else
				answer  *= num;
		}
		
		System.out.println(answer);
	}

}
