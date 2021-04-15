package swexpert;

import java.util.*;
import java.io.*;

public class Solution_탈주범검거 {

	static int n,m,r,c,l;
	static int[][] map;
	static int[][] deltas1= {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우
	static int[][] deltas2= {{-1,0},{1,0}}; //상하
	static int[][] deltas3= {{0,-1},{0,1}}; //좌우
	static int[][] deltas4= {{-1,0},{0,1}}; //상우
	static int[][] deltas5= {{1,0},{0,1}}; //하우
	static int[][] deltas6= {{1,0},{0,-1}}; //하좌
	static int[][] deltas7= {{-1,0},{0,-1}}; //상좌
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			l=Integer.parseInt(st.nextToken());
			
			map=new int[n][m];
			visit= new boolean[n][m];
			tmap=new int[n][m];
			
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			find(r,c,0);
			int ans=0;

			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(0<tmap[i][j]&&tmap[i][j]<=l) {
						ans++;
					}
				}
			}
			
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);

	}
	
	static boolean[][] visit;
	static int[][] tmap;
	
	
	static void find(int x,int y,int time) {
		Queue<int []> q = new LinkedList<int[]>();
		visit[x][y]=true;
		time++;
		q.add(new int[] {x,y,time});
		tmap[x][y]=time;
		
		while(!q.isEmpty()) {
			
			int r=q.peek()[0];
			int c=q.peek()[1];
			int t=q.poll()[2];
			
			if(map[r][c]==1) {
				for(int i=0;i<4;i++) { // 상하좌우 
					int tx=r+deltas1[i][0];
					int ty=c+deltas1[i][1];
					if(i==0&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==2||map[tx][ty]==5||map[tx][ty]==6||map[tx][ty]==1)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
					else if(i==1&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==2||map[tx][ty]==4||map[tx][ty]==7)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
					else if(i==2&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==3||map[tx][ty]==4||map[tx][ty]==5)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
					else if(i==3&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==3||map[tx][ty]==6||map[tx][ty]==7)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
				}
			}
			else if(map[r][c]==2) {
				for(int i=0;i<2;i++) {
					int tx=r+deltas2[i][0];
					int ty=c+deltas2[i][1];
					if(i==0&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==2||map[tx][ty]==5||map[tx][ty]==6||map[tx][ty]==1)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
					else if(i==1&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==2||map[tx][ty]==4||map[tx][ty]==7)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
				}
			}
			else if(map[r][c]==3) {
				for(int i=0;i<2;i++) {
					int tx=r+deltas3[i][0];
					int ty=c+deltas3[i][1];
					if(i==0&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==3||map[tx][ty]==4||map[tx][ty]==5)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
					else if(i==1&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==3||map[tx][ty]==6||map[tx][ty]==7)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
				}
			}
			else if(map[r][c]==4) {
				for(int i=0;i<2;i++) {
					int tx=r+deltas4[i][0];
					int ty=c+deltas4[i][1]; //상
					if(i==0&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==2||map[tx][ty]==5||map[tx][ty]==6||map[tx][ty]==1)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}//우
					else if(i==1&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==3||map[tx][ty]==6||map[tx][ty]==7)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
				}
			}
			else if(map[r][c]==5) {
				for(int i=0;i<2;i++) {
					int tx=r+deltas5[i][0];
					int ty=c+deltas5[i][1]; //하
					if(i==0&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==2||map[tx][ty]==4||map[tx][ty]==7)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					} //우
					else if(i==1&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==3||map[tx][ty]==6||map[tx][ty]==7)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
				}
			}
			else if(map[r][c]==6) {
				for(int i=0;i<2;i++) {
					int tx=r+deltas6[i][0];
					int ty=c+deltas6[i][1];
					if(i==0&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==2||map[tx][ty]==4||map[tx][ty]==7)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
					else if(i==1&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==3||map[tx][ty]==4||map[tx][ty]==5)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
				}
			}
			else {
				for(int i=0;i<2;i++) {
					int tx=r+deltas7[i][0];
					int ty=c+deltas7[i][1];
					if(i==0&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==2||map[tx][ty]==5||map[tx][ty]==6||map[tx][ty]==1)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
					else if(i==1&&isIn(tx,ty)&&!visit[tx][ty]&&(map[tx][ty]==1||map[tx][ty]==3||map[tx][ty]==4||map[tx][ty]==5)) {
						visit[tx][ty]=true;
						tmap[tx][ty]=t+1;
						q.add(new int[] {tx,ty,t+1});
					}
				}
			}
			
		}
		
		
		
	}
	
	static boolean isIn(int x,int y) {
		return 0<=x&&x<n&&0<=y&&y<m;
	}

}
