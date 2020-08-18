package codingTestBook.implement;

import java.util.Scanner;

public class KnightOfKingdom {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String val = scan.nextLine();
		
		int answer = 8;
		
		char[] valToArray = val.toCharArray();
		
		if (valToArray[0] < 'c' || valToArray[0] > 'f') {
			answer -= 4;
			if (Character.getNumericValue(valToArray[1]) < 3 || Character.getNumericValue(valToArray[1]) > 6) {
				answer -= 2;
			}
		} else if (Character.getNumericValue(valToArray[1]) < 3 || Character.getNumericValue(valToArray[1]) > 6) {
			answer -= 4;
		}
		
		
		System.out.println(answer);
		
		return;
	}

}
