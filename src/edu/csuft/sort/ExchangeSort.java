package edu.csuft.sort;

import java.util.Arrays;

public class ExchangeSort {
	public static int[] arr = { 2, 5, 3, 5, 5, 2, 5, 7, 3, 4, 9, 4, 6, 10 };
	//冒泡排序
	public static void bubbleup(int[] arr) {
		int temp;
		for (int end = arr.length; end > 0; end--) {
			for (int start = 1; start < end; start++) {
				if (arr[start - 1] > arr[start]) {
					temp = arr[start - 1];
					arr[start - 1] = arr[start];
					arr[start] = temp;
				}
			}
		}
	}
	
	public static void Quick(int[] arr) {
		if(arr == null||arr.length<=1)
			return;
		queckProcess(arr,0,arr.length-1);
	}
	
	private static void queckProcess(int[] arr, int left, int right) {
		if(left>=right)
			return;
		int core=partition(arr,left,right);
		queckProcess(arr,left,core-1);
		queckProcess(arr,core+1,right);
	}

	private static int partition(int[] arr, int left, int right) {
		int key = arr[left];
		int pivot = left;
		for(int i =left+1;i<=right; i++) {
			if(arr[i]<key)
				swap(arr,i,++pivot);
		}
		swap(arr,pivot,left);
		return pivot;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
	    arr[i] = arr[j]; 
	    arr[j] = temp;
	}

	public static void main(String[] args) {
		//bubbleup(arr);
		Quick(arr);
		System.out.println(Arrays.toString(arr));
	}
}
