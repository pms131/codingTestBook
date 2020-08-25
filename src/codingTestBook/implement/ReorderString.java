package codingTestBook.implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReorderString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();				// (1 <= s의 길이 <= 10,000)
		
		List<Character> chList = new ArrayList<Character>();
		List<Integer> intList = new ArrayList<Integer>();
		StringBuilder answer = new StringBuilder();
		
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch))
				intList.add(Character.getNumericValue(ch));
			else
				chList.add(ch);
		}

		Collections.sort(chList);
		
		
		
		answer.append(chList.stream().map(Object::toString).collect(Collectors.joining())).append(intList.stream().mapToInt(Integer::intValue).sum());
		
		System.out.println(answer.toString());
	}

}
