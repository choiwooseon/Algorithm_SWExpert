 package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1251하나로 {

	static ArrayList<int []> list;
	static int parents[];
	static Edge[] edgeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			int[][] v=new int[2][n];
			list = new ArrayList<>();
			
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					v[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			parents=new int[n];
			edgeList=new Edge[n*(n-1)/2];
			
			int idx=0;
			
			for(int i=0;i<n;i++) {
				int tx=v[0][i];
				int ty=v[1][i];
				for(int j=i+1;j<n;j++) {
					int ti=v[0][j];
					int tj=v[1][j];
					//c++;

					long weight=(long)(tx-ti)*(tx-ti)+(long)(ty-tj)*(ty-tj);
					//System.out.println(weight);
					//sb.append(weight+" ");
					edgeList[idx++]=new Edge(i,j,weight);
				}
				
			}
			
			
			//sb.append("#"+t+" "+c+"\n");
			
			
			double e=Double.parseDouble(br.readLine());
			//System.out.println(e);
			
			Arrays.sort(edgeList);
			
			make(n);
			double result=0.0;
			int count=0;
			for(Edge edge:edgeList) {
				if(union(edge.x,edge.y)) {
					result+=edge.w*e;
					
					if(++count==(n-1)) break;
				}
			}
			
			
			
			sb.append("#"+t+" "+(long)Math.round(result)+"\n");
			
			
		}
		System.out.println(sb);

	}
	
	static class Edge implements Comparable<Edge>{
		int x,y;
		long w;
		
		public Edge(int x,int y,long w) {
			this.x=x;
			this.y=y;
			this.w=w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.w, o.w);
		}
		
	}
	
	static void make(int n) {
		for(int i=0;i<n;i++) {
			parents[i]=i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		
		return parents[a]=findSet(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}

}
