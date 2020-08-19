package codingTestBook.search;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node {
	private int x;
	private int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}

public class EscapeMaze {

	public static int[][] graph = new int[200][200];
	public static int n, m;
	
	//상, 하, 좌, 우
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		
        scan.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            
            for (int j = 0; j < m; j++) {
            	graph[i][j] = str.charAt(j) - '0';
            }
            
        }
        

        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
	}
	
	public static int bfs(int x, int y) {
		Deque<Node> queue = new LinkedList<Node>();
		queue.add(new Node(x,y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			x = node.getX();
			y = node.getY();
			
			for (int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 맵 공간을 벗어났을 경우 무시
				if (nx <0 || nx >= n || ny < 0 || ny >= m)
					continue;
				// 괴물일 경우 무시
				if (graph[nx][ny] == 0)
					continue;

				if (graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] +1;
					queue.add(new Node(nx, ny));
				}
			}
		}
		
		
		
		return graph[n -1][m -1];
	}

}
