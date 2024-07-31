import java.io.*;
import java.util.*;

public class Main {
	
	static class Room {
		String roomType;
		int amount;
		ArrayList<Integer> possibleRoom;
		boolean visited;
		
		public Room(String roomType, int amount, ArrayList<Integer> possibleRoom) {
			this.roomType = roomType;
			this.amount = amount;
			this.possibleRoom = possibleRoom;
		}
	}
	
	static boolean result;
	static int n;
	static Room[] rooms;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			result = false;
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			rooms = new Room[n];
			
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String roomType = st.nextToken();
				int amount = Integer.parseInt(st.nextToken());
				ArrayList<Integer> posRoom = new ArrayList<>();
				while(st.hasMoreTokens()) 
					posRoom.add(Integer.parseInt(st.nextToken()));
				
				posRoom.remove(posRoom.size()-1);// 마지막 0은 방 정보 X
				rooms[i] = new Room(roomType, amount, posRoom);
			}
			move(0, 0);
			if(!result) sb.append("No\n");
		}
		System.out.print(sb);
	}
	
	public static void move(int start, int money) {
		if(rooms[start].roomType.equals("T")) {
			money -= rooms[start].amount;
		}
		else {
			if(money < rooms[start].amount) {
				money = rooms[start].amount;
			}
		}
		
		if(money >= 0) {
			if(start + 1 == n) {
				sb.append("Yes\n");
				result = true;
			}
			
			rooms[start].visited = true;
			
			for(int i=0;i<rooms[start].possibleRoom.size();i++) {
				if(!rooms[rooms[start].possibleRoom.get(i)-1].visited) {
					move(rooms[start].possibleRoom.get(i)-1, money);
				}
			}
			
			rooms[start].visited = false;
		}
		else {
			if(rooms[start].roomType.equals("T")) {
				money += rooms[start].amount;
				return;
			}
		}
	}
}