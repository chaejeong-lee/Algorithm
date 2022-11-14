import java.util.Scanner;

public class Main {

	static int[] temp;
	static int cnt = 0;
	static int K;
	static int result = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 배열의 크기
		K = sc.nextInt();// 저장횟수
		int[] arr = new int[N];
		
		temp = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		merge_sort(arr, 0, arr.length - 1);
		System.out.println(result);

	}

	public static void merge_sort(int[] arr, int low, int high) {//arr 오름차순 정렬
		if (low < high) {
			int mid = (low + high) / 2;//mid는 low와 high의 중간 지점
			merge_sort(arr, low, mid);//전반부 정렬
			merge_sort(arr, mid + 1, high);//후반부 정렬
			merge(arr, low, mid, high);//병합
		}
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int t = 0;

		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j])
				temp[t++] = arr[i++];
			else
				temp[t++] = arr[j++];
		}
		
		while(i<=mid) {
			temp[t++] = arr[i++];
		}
		
		while(j<=high) {
			temp[t++] = arr[j++];
		}
		t=0;
		i=low;
		while(i<=high) {
			cnt++;
			if(cnt==K) {
				result = temp[t];
				break;
			}
			arr[i++] = temp[t++];
		}
	}
}
