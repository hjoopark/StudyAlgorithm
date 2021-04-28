package algorithm;
import java.util.*;

//DFS와 BFS

public class BOJ_1260 {
	static ArrayList<Integer>[] a;		// 그래프 저장할 배열
	static boolean[] c;					// 탐색한 곳인지 체크
	public static void dfs(int x) {
		if(c[x]==true) {
			return;						// 체크가 되어있으면 return으로 넘어감
		}
		c[x] = true;					// 들어온거 체크 
		System.out.print(x + " ");		// 출력 넣으면서 출력하는거!!!
		for(int y:a[x]) {				// a[x]에서 차례대로 꺼내서 y에 넣겠다
			if(c[y] == false) {			// 체크되지 않았으면
				dfs(y);					// 재귀
			}
		}
		
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();	//큐 만들어놓기
		q.add(start);		// 시작점을 큐에 넣기
		c[start] = true;	// 들어왔으니까 체크하기
		while (!q.isEmpty()) {
			int x = q.remove();	// 큐에서 뺀거 x에 저장
			System.out.print(x + " ");
			for(int y : a[x]) {
				if(c[y] == false) {
					c[y] = true;
					q.add(y);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		a = (ArrayList<Integer>[]) new ArrayList[n + 1];	//a라는 배열을 만들어 놓음
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {		//간선 만들기
			int u = sc.nextInt();		
			int v = sc.nextInt();
			a[u].add(v);				//u, v사이에 간선 만들기
			a[v].add(u);
		}
		for(int i=1; i<=n; i++) {
			Collections.sort(a[i]);		// a에 있는거 정렬
		}
		c = new boolean[n+1];
		dfs(start);
		System.out.println();
		c = new boolean[n+1];
		bfs(start);
		System.out.println();
	}
	
}