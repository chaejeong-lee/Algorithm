import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class Node {
		int num;
		Node left, right;
		
		public Node (int num) {
			this.num = num;
		}
		
		public Node (int num, Node left, Node right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}
		
		public void insert(int n) {
			// 현재 노드보다 작으면 왼쪽 노드로
			if(n < this.num) {
				if(this.left == null) {
					this.left = new Node(n);
				}
				else {
					this.left.insert(n);
				}
			}
			else {
				if(this.right == null) {
					this.right = new Node(n);
				}
				else {
					this.right.insert(n);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Node root = new Node(num);// 루트 노드
		
		while(true) {
			String str = br.readLine();
			if(str == null || str.equals("")) break;
			root.insert(Integer.parseInt(str));
		}
		postOrder(root);
	}
	
	private static void postOrder(Node node) {
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}

}
