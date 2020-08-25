package codingTestBook.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CantMakeNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		// 1 <= n <= 1,000
		
		sc.nextLine();
		
		String str = sc.nextLine();
		int answer = 1;
		
		str = str.replaceAll(" ", "");
		
		List<Integer> list = str.chars().mapToObj(c -> Character.getNumericValue(c)).sorted().collect(Collectors.toList());
		
		for (int i=0; i<list.size(); i++) {
			// 현재 answer -1 까지는 만들 수 있음. 
			// 따라서 새로 들어오는 값이 answer보다 크면 answer+1 은 만드는 것이 불가능 (왜냐하면 answer까지 모두 가능했었기 때문에 새로 들어온 값 + answer까지는 모두 가능)
			
			if (answer < list.get(i)) {
				break;
			}
			answer += list.get(i);
		}
		
		System.out.println(answer);
	}

}
