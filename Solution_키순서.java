package swexpert;

import java.util.*;
import java.io.*;

public class Solution_키순서 {

	static int n,m;
	static ArrayList<Integer>[] up;
	static ArrayList<Integer>[] down;
	static boolean[] visit;
	static int[] count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			n=Integer.parseInt(br.readLine());
			m=Integer.parseInt(br.readLine());
			up=new ArrayList[n+1];
			down=new ArrayList[n+1];
			visit= new boolean[n+1];
			
			count=new int[n+1];
			
			for(int  i=1;i<=n;i++) {
				up[i]=new ArrayList<>();
				down[i]=new ArrayList<>();
			}//인접리스트 생성
			
			
			for(int i=0;i<m;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				up[b].add(a);
				down[a].add(b);
			}
			
			int ans=0;
			for(int i=1;i<=n;i++) {
				bfs(i,up);
				//System.out.println();
				Arrays.fill(visit, false);
				bfs(i,down);
				Arrays.fill(visit, false);
				//System.out.println(count[i]);
				if(count[i]==n-1) {
					//System.out.println(i);
					ans++;
				}
			}
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);

	}
	
	static void bfs(int idx,ArrayList<Integer>[] l) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visit[idx]=true;
		
		int cnt=0;
		while(!q.isEmpty()) {
			
			int ti=q.poll();
			
			int size=l[ti].size();
			//System.out.println(size);
			for(int i=0;i<size;i++) {
				int tidx=l[ti].get(i);
				if(!visit[tidx]) {
					cnt++;
					visit[tidx]=true;
					q.add(tidx);
				}
			}
		}
		//System.out.println(idx+" "+cnt);
		count[idx]+=cnt;
	}
	


}
