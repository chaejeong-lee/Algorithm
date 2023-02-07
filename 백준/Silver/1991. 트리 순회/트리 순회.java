import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	static class Node{
		char data;
		Node leftNode;
		Node rightNode;
		
		public Node(char data, Node leftNode, Node rightNode) {
			this.data = data;
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Node start = new Node('A', null, null);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char rootNode = st.nextToken().charAt(0);//노드
			char leftNode = st.nextToken().charAt(0);//왼쪽 자식 노드
			char rightNode = st.nextToken().charAt(0);//오른쪽 자식 노드
			//노드에 삽입하기
			insertNode(start, rootNode, leftNode, rightNode);
		}
		
		
		preOrder(start);
		sb.append("\n");
		inOrder(start);
		sb.append("\n");
		postOrder(start);
		sb.append("\n");
		
		System.out.print(sb);
	}
	
	//노드 삽입
	public static void insertNode(Node temp, char rootNode, char leftNode, char rightNode) {
		if(temp.data == rootNode) {//루트 노드와 시작 데이터가 동일할 경우
			//왼쪽 노드
			if(leftNode == '.') {//.일 경우 null로
				temp.leftNode = null;
			}else {
				temp.leftNode = new Node(leftNode, null, null);
			}
			
			//오른쪽 노드
			if(rightNode == '.') {//.일 경우 null로
				temp.rightNode = null;
			}else {
				temp.rightNode = new Node(rightNode, null, null);
			}
		}
		else {
			if(temp.leftNode != null) {
				insertNode(temp.leftNode, rootNode, leftNode, rightNode);
			}
			if(temp.rightNode != null) {
				insertNode(temp.rightNode, rootNode, leftNode, rightNode);
			}
		}
	}

	//전위 순회 : 노드 -> 왼 -> 오
	public static void preOrder(Node nd) {
		if(nd == null) return;
		sb.append(nd.data);
		preOrder(nd.leftNode);
		preOrder(nd.rightNode);
	}
	
	//중위순회 : 왼 -> 노드 -> 오
	public static void inOrder(Node nd) {
		if(nd == null)return;
		inOrder(nd.leftNode);
		sb.append(nd.data);
		inOrder(nd.rightNode);
	}
	
	//후위순회 : 왼 -> 오 -> 노드
	public static void postOrder(Node nd) {
		if(nd == null) return;
		postOrder(nd.leftNode);
		postOrder(nd.rightNode);
		sb.append(nd.data);
	}
}
