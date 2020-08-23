package codingTestBook.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class City implements Comparable<City> {
	
	private int distance;
	private int nodeA;
	private int nodeB;
	
	public City(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public int getDistance() {
		return distance;
	}

	public int getNodeA() {
		return nodeA;
	}

	public int getNodeB() {
		return nodeB;
	}

	@Override
	public int compareTo(City o) {
		if (this.distance < o.distance)
			return -1;
		return 1;
	}
	
}

public class DivideCityPlan {

	public static List<City> graph = new ArrayList<City>();
	public static int[] parent = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		// 집 개수 (2 <= n <= 100,000)
		int m = sc.nextInt();		// 도로 개수 (1 <= m <= 1,000,000)
		int result = 0;
		
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.add(new City(c,a,b));
		}
		
		Collections.sort(graph);
		
		int max = 0;				// 최소 신장 트리에 포함되는 간선 중 가장 비용이 큰 간선
		
		for(int i=0; i<graph.size(); i++) {
			int cost = graph.get(i).getDistance();
			int to = graph.get(i).getNodeA();
			int from = graph.get(i).getNodeB();
			
			if (findParent(to) != findParent(from)) {
				unionParent(to, from);
				result += cost;
				max = cost;			
			}
		}
		
		System.out.println(result - max);	// 최소 신장 트리에서 가장 큰 노드를 빼서 2개의 최소 신장 트리로 분할
	}
	
	public static void unionParent(int a, int b)	 {
		a = findParent(a);
		b = findParent(b);
		
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	public static int findParent(int x) {
		if (parent[x] != x)
			parent[x] = findParent(parent[x]);
		
		return parent[x];
	}

}
