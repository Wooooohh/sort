package edu.csuft.sort;

import java.util.Arrays;

public class MergeSort {
	public static int[] arr = { 2, 5, 3, 5, 5, 2, 5, 7, 3, 4, 9, 4, 6, 10 };
	
	public static void mergesort(int[] arr){
		if(arr == null || arr.length <=1) return;
		mergeProcess(arr,0,arr.length-1);
	}

	private static void mergeProcess(int[] arr, int left, int right) {
		if(left>=right) return;
		//取中点
		int mid = left +((right-left)>>1);
		//左右分别递归
		mergeProcess(arr,left,mid);
		mergeProcess(arr,mid+1,right);
		//合并
		if(arr[mid]>arr[mid+1])
			merge(arr,left,mid,right);
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int[] temp =new int[right-left+1];
		int k=0;
		int p1=left,p2=mid+1;
		
		//左右两边相等的话，就先拷贝左边的(实现稳定性)
		while (p1 <= mid && p2 <= right)
			temp[k++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];  
		//左边剩余的部分
		while (p1 <= mid)  
	    	temp[k++] = arr[p1++];
		//右边剩余的部分
		while (p2 <= right) 
	    	temp[k++] = arr[p2++];
		//覆盖原数组的这段区域
		for(int i=0;i<temp.length;i++) {
			arr[left+i]=temp[i];
		}
	}
	public static void main(String[] args) {
		mergesort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
