package swexpert;

import java.util.*;
import java.io.*;

public class Solution_보급로 {

	static int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	static int n;
	static int[][] map;
	static int[][] weight;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			ans=0;
			n=Integer.parseInt(br.readLine());
			map=new int[n][n];
			visit=new boolean[n][n];
			weight=new int[n][n];
			
			for(int i=0;i<n;i++) {
				String str = br.readLine();
				for(int j=0;j<n;j++) {
					map[i][j]=str.charAt(j)-'0';
					weight[i][j]=Integer.MAX_VALUE;
				}
			}
	
			bfs(0,0,0);
			sb.append("#"+t+" "+weight[n-1][n-1]+"\n");
			
		}
		
		System.out.println(sb);
	}

	static int ans;
	static boolean[][] visit;
	
	static void bfs(int x,int y,int w) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		visit[x][y]=true;
		weight[x][y]=map[x][y];
		
		while(!q.isEmpty()) {
			int tx=q.peek()[0];
			int ty=q.poll()[1];
			
			for(int i=0;i<4;i++) {
				int tr=tx+d[i][0];
				int tc=ty+d[i][1];
				if(isIn(tr,tc)&&weight[tr][tc]>weight[tx][ty]+map[tr][tc]) {
					int tww=weight[tx][ty]+map[tr][tc];
					weight[tr][tc]=tww;
					q.add(new int[] {tr,tc});
				}
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return 0<=x&&x<n&&0<=y&&y<n;
	}
}
