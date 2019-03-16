package edu.csuft.sort;

import java.util.Arrays;

public class ExchangeSort {
	public static int[] arr = { 7, 2, 8, 1, 5, 11, 3, 7, 8, 4, 9, 4, 6, 10 };

	// 冒泡排序
	public static void bubbleup(int[] arr) {
		for (int end = arr.length; end > 0; end--) {
			for (int start = 1; start < end; start++) {
				if (arr[start - 1] > arr[start]) {
					swap(arr, start - 1, start);
					// temp = arr[start - 1];
					// arr[start - 1] = arr[start];
					// arr[start] = temp;
				}
			}
		}
	}

	// 选择排序
	public static void select(int[] arr) {
		int min;
		for (int i = 0; i < arr.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, min, i);
		}
	}

	// 插入排序
	public static void insert(int[] arr) {
		int p;
		int m;
		for (int i = 1; i < arr.length; i++) {
			p = i;
			m = i - 1;
			while (m >= 0 && arr[p] > arr[m]) {
				swap(arr, p--, m--);
			}

		}
	}

	public static void quick(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		queckProcess(arr, 0, arr.length - 1);
	}

	private static void queckProcess(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int core = partition(arr, left, right);
		queckProcess(arr, left, core - 1);
		queckProcess(arr, core + 1, right);
	}

	private static int partition(int[] arr, int left, int right) {
		int key = arr[left];
		int pivot = left;
		for (int i = left + 1; i <= right; i++) {
			if (arr[i] < key)
				swap(arr, i, ++pivot);
		}
		swap(arr, pivot, left);
		return pivot;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// bubbleup(arr);
		// quick(arr);
		// select(arr);
		insert(arr);
		System.out.println(Arrays.toString(arr));
	}
}
