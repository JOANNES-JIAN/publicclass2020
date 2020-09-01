package class17;

import java.util.ArrayList;
import java.util.List;

public class Code01_SubArrayMaxSum {

	public static int test(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int N = arr.length;
		int max = Integer.MIN_VALUE;
		for (int L = 0; L < N; L++) {
			for (int R = L; R < N; R++) {
				// arr[L...R]
				int sum = 0;
				for (int i = L; i <= R; i++) {
					sum += arr[i];
				}
				max = Math.max(max, sum);
			}
		}
		return max;
	}

	public static int maxSum1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		// 0结尾时候的答案
		int pre = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			// i结尾时候的答案
			pre = arr[i] + (pre > 0 ? pre : 0);
			max = Math.max(max, pre);
		}
		return max;
	}

	public static List<List<Integer>> maxSum2(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return ans;
		}
		int L = 0;
		int maxLen = 0;
		int maxSum = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i < arr.length; i++) {
			// L...i sum
			cur += arr[i];
			if (cur == maxSum && (i - L + 1) == maxLen) {
				List<Integer> curAns = new ArrayList<>();
				curAns.add(L);
				curAns.add(i);
				ans.add(curAns);
			}
			if (cur > maxSum || (cur == maxSum && (i - L + 1) > maxLen)) {
				ans.clear();
				List<Integer> curAns = new ArrayList<>();
				curAns.add(L);
				curAns.add(i);
				ans.add(curAns);
				maxLen = i - L + 1;
			}
			maxSum = Math.max(maxSum, cur);
			if (cur < 0) {
				cur = 0;
				L = i + 1;
			}
		}
		return ans;
	}

	public static int[] generateArray(int N, int V) {
		int n = (int) (Math.random() * N) + 1;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * V) - (int) (Math.random() * V);
		}
		return arr;
	}

	public static void main(String[] args) {
//		int N = 100;
//		int V = 100;
//		int testTime = 1000000;
//		System.out.println("test begin");
//		for (int i = 0; i < testTime; i++) {
//			int[] arr = generateArray(N, V);
//			int ans1 = maxSum1(arr);
//			int ans2 = maxSum2(arr);
//			if (ans1 != ans2) {
//				System.out.println("Oops!");
//			}
//		}
//		System.out.println("test finish");

		int[] test = { 2, 2, 1, -9, 2, 3, -9, 6, -9, 2, 2, 2, -9, 2, 2, 2, -9, 1, 4, 1 };

		List<List<Integer>> ans = maxSum2(test);

		for (List<Integer> cur : ans) {
			System.out.println("start : " + cur.get(0) + ", end : " + cur.get(1));
		}

	}

}
