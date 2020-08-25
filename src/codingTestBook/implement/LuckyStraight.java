package codingTestBook.implement;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LuckyStraight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();	// (10 <= n <= 99,999,999), n의 자리수는 항상 짝수
		
		List<Integer> list = n.chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());
		
		int before = 0;
		int after = 0;
		
		for (int i=0; i<list.size(); i++) {
			if (i < list.size()/2)
				before += list.get(i);
			else
				after += list.get(i);
		}
		
		System.out.println(before == after ? "LUCKY" : "READY");
	}

}
