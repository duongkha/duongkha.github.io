import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		int[] array1 = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15};
		int[] array2 = {4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15};
		int[] array3 = {5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9};
		int[][] arrays = {array,array1,array2,array3};
		//build max-heap top down and sorting
		for(int[] a: arrays){
			int[] arr = a.clone();
			System.out.println(Arrays.toString(arr));
			int count = buildMaxHeapTopDown(arr, arr.length);
			System.out.println(Arrays.toString(arr));
			System.out.println("Comparison Count:" + count);
			heapSortTopDown(a.clone(), a.clone().length);
		}
		
		//build max heap bottom up and sorting
		for(int[] a: arrays){
			int[] arr = a.clone();
			System.out.println(Arrays.toString(arr));
			int count = buildMaxHeapBottomUp(arr, arr.length);
			System.out.println(Arrays.toString(arr));
			System.out.println("Comparison Count:" + count);
			heapSortBottomUp(a.clone(), a.clone().length);
		}
		
	}
	public static void swap(int[] a, int i, int j) {
	    int temp = a[i];
	    a[i]=a[j];
	    a[j] = temp;
	}
	static int buildMaxHeapTopDown(int arr[], int n)
	  {
		int count = 0 ;
	    for (int i = 1; i < n; i++)
	    {
	      // if child is bigger than parent
	      if (arr[i] > arr[(i - 1) / 2])
	      {
	        int j = i;
	        // swap child and parent until
	        // parent is smaller
	        while (arr[j] > arr[(j - 1) / 2])
	        {
	          swap(arr, j, (j - 1) / 2);
	          j = (j - 1) / 2;
	          count++;
	        }
	      }
	    }
	    return count;
	  }
	
	public static void heapSortTopDown(int[] array, int n) {
		System.out.println("heapSortTopDown Input Array:");
		System.out.println(Arrays.toString(array));
		int count = 0;
		count = buildMaxHeapTopDown(array,n);
		
		for(int i = n-1; i > 0 ; i--) {
			swap(array, 0, i);
			count += buildMaxHeapTopDown(array,i);
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Comparison Count:" + count);
	}
	
	static int heapifyBottomUp(int arr[], int n, int i)
    {
		int count = 0;
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) 
            largest = l;
        if (l < n)
            count++;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) 
            largest = r;
        if (r < n)
            count++;
 
        // If largest is not root
        if (largest != i) {
        	swap(arr,i,largest);
            // Recursively heapify the affected sub-tree
            count += heapifyBottomUp(arr, n, largest);
        }
        return count;
    }
	public static int buildMaxHeapBottomUp(int[] array, int n) {
		int count = 0 ;
		for (int i = n / 2 - 1; i >= 0; i--)
			count += heapifyBottomUp(array, n, i);
		return count;
	}
	public static void heapSortBottomUp(int[] array, int n) {
		System.out.println("heapSortBottomUp Input Array:");
		System.out.println(Arrays.toString(array));
		int count = 0 ;
		for (int i = n / 2 - 1; i >= 0; i--)
			count += heapifyBottomUp(array, n, i);
		
		for(int i = n-1; i > 0 ; i--) {
			swap(array, 0, i);
			count += heapifyBottomUp(array,i,0);
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Comparison Count:" + count);
	}
}
