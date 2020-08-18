package codingTestBook.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class UDLR {

	public static void main(String[] args) {
		System.out.print("숫자 입력 : ");
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();	//(1 <= n <= 100)
		List<String> list = new ArrayList<String>();
		int row = 1;
		int col = 1;
		
		
		System.out.print("상하좌우 입력 : ");
		
        scan.nextLine(); // 버퍼 비우기
        list = Arrays.asList(scan.nextLine().split(" "));

		
		for (int i=0; i < list.size(); i++) {
			switch (list.get(i)) {
				case "L":
					if (row > 1)
						row -= 1;
					break;
				case "R":
					if (row < 5)
						row += 1;
					break;
				case "U":
					if (col > 1)
						col -= 1;
					break;
				case "D":
					if (col < 5)
						col += 1;
					break;
				default:
					break;
			}
		}
		
		
		System.out.println(col + " " + row);
	}

}
