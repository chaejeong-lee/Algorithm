import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//메시지의 길이
		int C = Integer.parseInt(st.nextToken());//숫자 범위
		
		HashMap<Integer, Integer> hm = new LinkedHashMap<>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(hm.containsKey(num)) {
				hm.replace(num, hm.get(num)+1);
			}
			else {
				hm.put(num, 1);
			}
		}
		
		//key값들 배열에 저장
		ArrayList<Integer> key = new ArrayList<Integer>(hm.keySet());
		
		Collections.sort(key, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(hm.get(o2), hm.get(o1));
			}
		});
		
		
		Iterator<Integer> it = key.iterator();
		while(it.hasNext()) {
			Integer value = it.next();
			for(int i=0;i<hm.get(value);i++) {
				sb.append(value+" ");
			}
		}
		System.out.print(sb);
	}

}
