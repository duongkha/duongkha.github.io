import java.util.Arrays;
import java.util.Random;

public class Main {
	//Problem statement
	//Find the largest distance between any two even integers in an integer array.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Random rand = new Random();
		int n = rand.nextInt(4000);
		System.out.println("n: " + n);
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			int v = rand.nextInt(n);
			arr[i] = v;
		}
		System.out.println(Arrays.toString(arr));
		algorithm1(arr);
		algorithm2(arr);
		algorithm3(arr);
		algorithm4(arr);
	}
	
	public static void algorithm1(int[] array) {
		long start = System.currentTimeMillis();
		int[] newArray = new int[array.length];
		int j = 0;
		for(int i = 0; i < array.length; i++) {
			if( array[i] % 2 == 0) {
				newArray[j] = array[i];
				j++;
			}
		}
		int distance = 0;
		for(int i = 0; i < newArray.length -1;i++){
			for(int k = i + 1; k < newArray.length; k++ ) {
				if(Math.abs(newArray[k] - newArray[i]) > distance)
					distance = Math.abs(newArray[k] - newArray[i]);
			}
		}
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println("algorithm 1: " + distance);
		System.out.println("elapsedTime 1: " + elapsedTime + "ms");	
	}
	public static void algorithm2(int[] array) {
		long start = System.currentTimeMillis();
		int distance = 0;
		for(int i = 0; i < array.length -1;i++){
			if(array[i]%2 == 0) {
				for(int k = i + 1; k < array.length; k++ ) {
					if(array[k]%2 == 0) {
						if(Math.abs(array[k] - array[i]) > distance)
							distance = Math.abs(array[k] - array[i]);
					}
				}
			}
		}
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println("algorithm 2: " + distance);
		System.out.println("elapsedTime 2: " + elapsedTime + "ms");	
	}
	public static void algorithm3(int[] array) {
		long start = System.currentTimeMillis();
		int min = array[0];
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if( array[i] % 2 == 0) {
				if(array[i] < min)
					min = array[i];
				if(array[i] > max)
					max = array[i];
			}
		}
		int distance = max - min;
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println("algorithm 3: " + distance);
		System.out.println("elapsedTime 3: " + elapsedTime + "ms");	
	}
	public static void algorithm4(int[] array) {
		long start = System.currentTimeMillis();
		
		int min = Arrays.stream(array).filter(x->x%2 == 0).min().getAsInt();
		int max = Arrays.stream(array).filter(x->x%2 == 0).max().getAsInt();
		int distance = max - min;
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println("algorithm 4: " + distance);	
		System.out.println("elapsedTime 4: " + elapsedTime + "ms");	
	}
}
