package codingTestBook.greedy;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChooseBowlingBall {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		// 볼링공의 개수 n (1 <= n <= 1,000)
		int m = sc.nextInt();		// 공의 최대 무게 m (1 <= k <= m)
		sc.nextLine();
		
		String k = sc.nextLine();
		
		k = k.replaceAll(" ", "");
		
		List<Integer> list = k.chars().mapToObj(ch -> Character.getNumericValue(ch)).collect(Collectors.toList());
		
		int answer = 0;
		
		for (int i=0; i<list.size() -1; i++) {
			int first = list.get(i);
			for (int j=i+1; j<list.size(); j++) {
				int second = list.get(j);
				
				if (first == second)
					continue;
				
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
