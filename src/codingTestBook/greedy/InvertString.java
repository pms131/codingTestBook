package codingTestBook.greedy;

import java.util.Scanner;

public class InvertString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();			// 0과 1로만 이루어진0 문자열

		char[] chArr = str.toCharArray();
		int count0 = 0;
		int count1 = 0;
		
		for (int i=0; i<chArr.length -1; i++) {
			if (chArr[i] != chArr[i+1]) {
				if (chArr[i] == '0')
					count0++;
				else
					count1++;
			}
		}
		
		if (count0 > count1)
			System.out.println(count0);
		else
			System.out.println(count1);
	}

}
