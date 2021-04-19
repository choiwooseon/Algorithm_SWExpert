package swexpert;

import java.util.*;
import java.io.*;

public class Solution_5656벽돌깨기 {

	static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] map;
	static int[][] sum;
	static int[][] tmp;
	static int w,h,n,ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			min=Integer.MAX_VALUE; //초기화 꼭...
			ans=0;
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken()); //구슬의 개수
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			map=new int[h][w];
			tmp=new int[h][w];
			choice=new int[n];

			
			for(int i=0;i<h;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					int x=Integer.parseInt(st.nextToken());
					map[i][j]=x;
					tmp[i][j]=x;
				}
			}
			
			ducomb(0);
			
			sb.append("#"+t+" "+min+"\n");
			
		}
		
		System.out.println(sb);

	}
	
	static boolean isIn(int x,int y) {
		return 0<=x&&x<h&&0<=y&&y<w;
	}

	//visit 생성위치 ???? 
	static void bomb(int x,int y) {
		
		Queue<int []> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});

		while(!q.isEmpty()) {
			int r=q.peek()[0];
			int c=q.poll()[1];
			int size=map[r][c];
			map[r][c]=0;
			
			for(int i=0;i<4;i++) {
				int tx=r;
				int ty=c;
				
				for(int j=0;j<size-1;j++) {
					tx+=deltas[i][0];
					ty+=deltas[i][1];
					
					if(isIn(tx,ty)&&map[tx][ty]>1) {
						q.add(new int[] {tx,ty});
					}
					else if(isIn(tx,ty)&&map[tx][ty]==1) {
						map[tx][ty]=0;
					}
				}
			}
		}
		
		
		
		
		//빈공간이 생기면 아래로 떨어짐.
		int d=0;
		ArrayList<Integer> list=new ArrayList<>();
		for(int j=0;j<w;j++) {
			d=0;
			for(int i=0;i<h;i++) {
				if(map[i][j]!=0) {
					list.add(map[i][j]);
					d++;
					map[i][j]=0;
				}
			}
			
			int idx=d-1;
			for(int i=0;i<d;i++) {
				//System.out.println(idx);
				map[h-1-i][j]=list.get(idx--);
			}
			list.clear();
		}
		

	}
	
	static int[] choice;
	static int min=Integer.MAX_VALUE;
	
	static void ducomb(int cnt) {
		if(min==0) return;
		int count=0;
		if(cnt==n) {
			for(int i=0;i<n;i++) { //뽑은 숫자 순서대로 공을 던진다.(몇 열인지)
				int idx=choice[i];
				for(int j=0;j<h;j++) {
					if(map[j][idx]!=0) {
						bomb(j,idx);
						break;
					}
				}
			}

			//총 n번 폭발 후
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]!=0) {
						count++;
					}
				}
			}
			min=Math.min(min,count);
			
			for(int i=0;i<h;i++) { //초기화
				for(int j=0;j<w;j++) {
					map[i][j]=tmp[i][j];
				}
			}
			

			return;
		}
		
		for(int i=0;i<w;i++) {
			choice[cnt]=i;
			ducomb(cnt+1);
		}
	}

}
