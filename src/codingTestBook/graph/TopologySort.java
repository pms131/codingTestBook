package codingTestBook.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TopologySort {
	
	private static int v, e;
	private static int [] indgree= new int[100001];
	private static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	private static List<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		for (int i=0; i<=v; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i=0; i<e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
			
			indgree[b]++;
		}
		
		topologySort();
		
		result.stream().forEach(e -> System.out.print(e + " "));
	}
	
	public static void topologySort() {
		Queue<Integer> que = new LinkedList<>();
		
		for (int i=1; i <= v; i++) {
			if (indgree[i] == 0)
				que.offer(i);
		}
		
		while (!que.isEmpty()) {
			int now = que.poll();
			result.add(now);
			
			for(int i=0; i<graph.get(now).size(); i++) {
				indgree[graph.get(now).get(i)] -=1 ;
				
				if (indgree[graph.get(now).get(i)] == 0)
					que.offer(graph.get(now).get(i));
			}
			
		}
	}

}
