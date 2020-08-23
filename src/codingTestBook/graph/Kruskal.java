package codingTestBook.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Node implements Comparable<Node> {
	private int from;
	private int to;
	private int distance;
	
	public Node(int from, int to, int distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		if (this.distance < o.distance)
			return -1;
		return 1;
	}
	
}

public class Kruskal {

	public static List<Node> graph = new ArrayList<Node>();
	public static int[] parent = new int[10001];
	private static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();			// 노드의 갯수
		int m = sc.nextInt();			// 간선의 갯수
		
		for (int i=1; i<=n; i++) {
			parent[i] = i;
		}
		
		for (int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.add(new Node(a,b,c));
		}
		
		Collections.sort(graph);
		
		for (int i=0; i<graph.size(); i++) {
			int cost = graph.get(i).getDistance();
			int to = graph.get(i).getTo();
			int from = graph.get(i).getFrom();
			
			if (findParent(to) != findParent(from)) {
				unionParent(to, from);
				result += cost;
			}
		}
				
		System.out.println(result);
	}

	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b)
			parent[b] = parent[a];
		
		parent[a] = parent[b];
	}
	
	public static int findParent(int x) {
		if (parent[x] != x)
			x = findParent(parent[x]);
		
		return parent[x];
	}
}
