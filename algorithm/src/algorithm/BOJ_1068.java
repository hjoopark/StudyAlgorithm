package algorithm;
import java.util.*;

//연결 요소의 개수
public class BOJ_1068 {
	static int n,target,start,cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		 ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n];
	        for (int i=1; i<n; i++) {
	            a[i] = new ArrayList<Integer>();
	        }
	        for (int i=0; i<n; i++) {
	            int u = sc.nextInt();
	            if(u != -1) {
	            	a[i].add(u);	
	            }else {
	            	start = i;
	            }
	        }
	        target = sc.nextInt();
	        delete(a);
	        if(target == start) {
	        	System.out.println(0);
	        } else {
	        	search(start,a);
	        }
	}
	public static void delete(ArrayList<Integer>[] a) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<a[i].size(); j++) {
				if(a[i].get(j) == target) {
					a[i].remove(j);
				}				
			}
		}
	}
	public static void search(int i, ArrayList<Integer>[] a) {
		if(a[i].size() == 0) {
			cnt++;
			return;
		}
		int next = a[i].get(0);
		if(a[i].size()==1 && next == target) {
			cnt++;
			return;
		}
		if(next<n && next!=target) {
			search(next,a);
		}
	}

}
