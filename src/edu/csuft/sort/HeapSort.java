package edu.csuft.sort;

import java.util.Arrays;

public class HeapSort {
	public static int[] arr = { 2, 5, 3, 5, 5, 2, 5, 7, 3, 4, 9, 4, 6, 10 };

	public static void heapsort(int[] arr) {
		if (arr == null || arr.length - 1 < 1)
			return;
		//构造最大或最小堆
		for (int i = arr.length / 2 - 1; i >= 0; --i)
			heapadjust(arr, i, arr.length - 1);
		//将堆内最大或最小元素移至末尾
		for (int j = arr.length - 1; j > 0; --j) {
			swap(arr, 0, j);
			heapadjust(arr, 0, j - 1);
		}
	}

	//从S的位置开始在S-M范围内保持最大或最小堆
	public static void heapadjust(int[] arr, int s, int m) {
		int rc = arr[s];
		for (int j = 2 * s + 1; j <= m; j = j * 2 + 1) {
			if (j < m && compare(arr[j], arr[j + 1]))
				++j;
			if (!compare(rc, arr[j]))
				break;
			arr[s] = arr[j];
			s = j;
		}
		arr[s] = rc;
	}

	private static boolean compare(int num1, int num2) {
		// 小于号为最小堆，大于号为最大堆
		if (num1 < num2)
			return true;
		return false;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		heapsort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
