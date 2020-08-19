package codingTestBook.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IcedDrink {
	public static int[][] graph = new int[1000][1000];
	public static int n;
	public static int m;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();		// 열의 갯수 (1 <= n)
		m = scan.nextInt();		// 행의 갯수 (m <= 1,000)
		
        scan.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            
            for (int j = 0; j < m; j++) {
            	graph[i][j] = str.charAt(j) - '0';
            }
            
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (dfs(i, j)) {
                    result += 1;
                }
        	}
        }
		
        System.out.println(result);
	}
	
	public static boolean dfs (int x, int y) {
		
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		
		if (graph[x][y] == 0) {
			
			graph[x][y] = 1;		

            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
			
		}
		
		return false;
	}

}
