package codingTestBook.implement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Samsung SW 역량 테스트
 * https://www.acmicpc.net/problem/3190
 *
 */
class Node  {
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

class Info {
	private int time;
	private String direction;
	
	public Info(int time, String direction) {
		this.time = time;
		this.direction = direction;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}

public class Snake {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();				// 보드의 크기 (2 <= n <= 100)
		int k = sc.nextInt();				// 사과의 개수 (0 <= k <= 100)
		
		int[][] map = new int[101][101];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int x = 0;
		int y = 0;
		int direction = 0;
		int time = 0;
		
		// 사과가 있는 곳은 1로 표시
		for (int i=0; i<k; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			map[row-1][col-1] = 1;
		}
		
		// 뱀이 있는 곳은 2로 표시 (첫 위치는 0,0)
		map[x][y] = 2;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x,y));
		
		int l = sc.nextInt();				// 뱀의 방향 전환 개수 (1 <= l <= 100)
		
		List<Info> list = new ArrayList<Info>();
		
		for(int i=0; i<l; i++) {
			int timeInfo = sc.nextInt();
			String dirStr = sc.next();
			
			list.add(new Info(timeInfo, dirStr));
		}
		
		int idx =0;
		
		while(true) {
			int sx = x + dx[direction];
			int sy = y + dy[direction];
			time++;
			
			// 벽에 안부딪치거나 자기 자신과 안부딪친 경우
			if (0 <= sx && sx < n && 0 <= sy && sy < n && map[sy][sx] != 2) {
				//사과가 있는 경우 길이 증가 (꼬리 미제거)
				if (map[sy][sx] == 1) {
					map[sy][sx] = 2;
					q.offer(new Node(sx, sy));
				} else if (map[sy][sx] == 0) {	// 사과가 없는 경우 꼬리 제거
					map[sy][sx] = 2;
					q.offer(new Node(sx, sy));
					Node prev = q.poll();
					map[prev.getY()][prev.getX()] = 0;
				}
				
			} else {
				break;
			}
			
			//머리 이동
			x = sx;
			y = sy;
			
			if (idx < list.size() && list.get(idx).getTime() == time) {
				if (list.get(idx).getDirection().equals("D")) {
					direction = (direction+1) % 4;
				} else if (list.get(idx).getDirection().equals("L")) {
					direction = direction == 0 ? 3 : direction - 1;
				}
				
				idx++;
			}
		}
		
		
		System.out.println(time);
	}

}
