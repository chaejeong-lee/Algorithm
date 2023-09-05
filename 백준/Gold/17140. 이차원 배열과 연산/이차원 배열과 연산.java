import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Number implements Comparable<Number>{
		int num;
		int len;
		public Number(int num, int len) {
			super();
			this.num = num;
			this.len = len;
		}
		@Override
		public int compareTo(Number o) {
			if(this.len == o.len) {
				return this.num<o.num?-1:1;
			}
			return this.len<o.len?-1:1;
		}
	}
	
	static int[][] map;
	static int[] cnt;
	static ArrayList<Number> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[3][3];
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = -1;
		
		while(true) {
			time++;
			
			if(time > 100) {
				time = -1;
				break;
			}
			
			if(r<map.length&&c<map[0].length) {
				if(map[r][c] == k) break;
			}
			
			int row = map.length;
			int col = map[0].length;
			
			int[][] tmp = new int[101][101];
			if(row>=col) {
				int max = Integer.MIN_VALUE;
				
				for(int i=0;i<row;i++) {
					cnt = new int[101];
					for(int j=0;j<col;j++) {
						if(map[i][j] == 0) continue;
						int n = map[i][j];
						cnt[n]++;
					}
					list = new ArrayList<>();
					
					for(int j=1;j<cnt.length;j++) {
						if(cnt[j] != 0) list.add(new Number(j, cnt[j]));
					}
					
					Collections.sort(list);
					
					int z = 0;
					
					for(int j=0;j<list.size();j++) {
						tmp[i][z] = list.get(j).num;
						tmp[i][z+1] = list.get(j).len;
						z += 2;
					}
					if(max<list.size()*2) max = list.size()*2;
				}
				if(max > 100) max = 100;
				
				map = new int[row][max];
				
				for(int i=0;i<row;i++) {
					for(int j=0;j<max;j++) {
						map[i][j] = tmp[i][j];
					}
				}
			}
			else {
				int max = Integer.MIN_VALUE;
				
				for(int i=0;i<col;i++) {
					cnt = new int[101];
					for(int j=0;j<row;j++) {
						if(map[j][i] == 0) continue;
						int n = map[j][i];
						cnt[n]++;
					}
					list = new ArrayList<>();
					
					for(int j=1;j<cnt.length;j++) {
						if(cnt[j] != 0) list.add(new Number(j, cnt[j]));
					}
					
					Collections.sort(list);
					
					int z = 0;
					
					for(int j=0;j<list.size();j++) {
						tmp[z][i] = list.get(j).num;
						tmp[z+1][i] = list.get(j).len;
						z += 2;
					}
					if(max<list.size()*2) max = list.size()*2;
				}
				if(max > 100) max = 100;
				
				map = new int[max][col];
				
				for(int i=0;i<max;i++) {
					for(int j=0;j<col;j++) {
						map[i][j] = tmp[i][j];
					}
				}
				
			}
		}
		System.out.println(time);
	}

}