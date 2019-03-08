package edu.csuft.sort;

import java.util.Arrays;

public class ExchangeSort {
	public static int[] arr = {2,5,3,5,5,2,5,7,3,4,9,4,6,10};
	
	public static void bubbleup(int[] arr) {
		int temp;
		for(int end = arr.length;end>0;end--) {
			for(int start = 1;start<end;start++) {
					if(arr[start-1]>arr[start]) {
						temp =arr[start-1];
						arr[start-1]=arr[start];
						arr[start]=temp;
					}		
			}	
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		bubbleup(arr);
	}
}
