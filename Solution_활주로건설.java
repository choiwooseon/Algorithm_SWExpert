package swexpert;

import java.util.*;
import java.io.*;

public class Solution_활주로건설 {

	static int n,x;
	static int[][] map;
	static ArrayList<int []> threelist = new ArrayList<>();
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		st=new StringTokenizer(br.readLine());
		int ans=0;
		n=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		map=new int[n][n];
			
			
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int x=Integer.parseInt(st.nextToken());
				map[i][j]=x;
			}
		}
			
		int[] height=new int[11];
		for(int i=0;i<n;i++) {
			int down=0;
			int flag=0;
			Arrays.fill(height, 0);
			height[map[i][0]]++;
			for(int j=1;j<n;j++) {
				if(map[i][j]==map[i][j-1]) {
					height[map[i][j]]++;
				}
				else if(map[i][j]==map[i][j-1]+1) { //하나 높아질 때
					if(down==1&&height[map[i][j-1]]<2*x) { //이미 한번 낮아져 있고
						flag=1;
						break;
					}
					if(height[map[i][j-1]]<x) {
						flag=1;
						break;
					}
					height[map[i][j]]++;
					height[map[i][j-1]]=0;
					down=0;
				}
				else if(map[i][j]==map[i][j-1]-1) { //하나 낮아질 때
					if(down==1) { //이미 이전에 한번 낮아진것
						if(height[map[i][j-1]]<x) {
							flag=1;
							break;
						}
					}
					height[map[i][j-1]]=0;
					height[map[i][j]]++;
					down=1;
				}
				else { //1이상의 차이가 날 때 
					flag=1;
					break;
				}
			}
				if(down==1&&height[map[i][n-1]]<x) continue;
				if(flag==0) ans++;
			}
			
			for(int j=0;j<n;j++) {
				int down=0;
				int flag=0;
				Arrays.fill(height, 0);
				height[map[0][j]]++;
				int i=1;
				for(i=1;i<n;i++) {
					if(map[i][j]==map[i-1][j]) {
						height[map[i][j]]++;
					}
					else if(map[i][j]==map[i-1][j]+1) { //하나 높아질 때
						if(down==1&&height[map[i-1][j]]<2*x) {//이미 한번 낮아진거면, 앞에서 경사로랑 겹치는지 확인해야함 
							flag=1;
							break;
						}
						if(height[map[i-1][j]]<x) {
							flag=1;
							break;
						}
						height[map[i][j]]++;
						height[map[i-1][j]]=0;
						down=0;
					}
					else if(map[i][j]==map[i-1][j]-1) { //하나 낮아질 때
						if(down==1) { //이미 이전에 한번 낮아진거면 경사로를 세울 수 있는지 점검
							if(height[map[i-1][j]]<x) {
								flag=1;
								break;
							}
						}
						height[map[i-1][j]]=0;
						height[map[i][j]]++;
						down=1;
					}
					else { //1이상의 차이가 날 때 
						flag=1;
						break;
					}
				}
				if(down==1&&height[map[n-1][j]]<x) continue;
				if(flag==0) ans++;
			}
			
			
			System.out.println(ans);
			
		
		
	}

	
}
