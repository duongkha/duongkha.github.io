import java.util.Arrays;
import java.util.Random;

public class Main {
	//Problem statement
	//Find the largest distance between any two even integers in an integer array.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Random rand = new Random();
		 int n = rand.nextInt(500000);
		//int[] array = {7, 20, 18, 4, 20, 19, 20, 3};
		int[] array = generateIntArray(n);
		System.out.println(Arrays.toString(array));
		algorithm1(array);
		algorithm2(array);
	}
	public static int[] generateIntArray(int n) {
		Random rand = new Random();
		System.out.println("n: " + n);
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			int v = rand.nextInt(n);
			arr[i] = v;
		}
		return arr;
	}
	public static void algorithm1(int[] array) {
		if(array.length < 3) return;
		long start = System.currentTimeMillis();
		int maxIndex = 0;
		int preMaxIndex = 0;
		int prePreMaxIndex = 0;
		for(int i = 1; i < array.length; i++) {
			if(array[i] >= array[maxIndex]) {
				maxIndex = i;
			}
		}
		for(int i = 1; i < array.length; i++) {
			if(array[i] >= array[preMaxIndex] && i != preMaxIndex) {
				preMaxIndex = i;
			}
		}
		for(int i = 1; i < array.length; i++) {
			if(array[i] >= array[prePreMaxIndex] && i != maxIndex && i != preMaxIndex) {
				prePreMaxIndex = i;
			}
		}
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println("algorithm 1: max: " + array[maxIndex] + "; preMax: " + array[preMaxIndex] + "; prePreMax: " + array[prePreMaxIndex]);
		System.out.println("elapsedTime 1: " + elapsedTime + "ms");	
	}
	
	public static void algorithm2(int[] array) {
		if(array.length < 3) return;
		long start = System.currentTimeMillis();
		int max = array[0];
		int preMax = array[0];
		int prePreMax = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] >= max) {
				prePreMax = preMax;
				preMax = max;
				max = array[i];
			}
		}
		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println("algorithm 2: max: " + max + "; preMax: " + preMax + "; prePreMax: " + prePreMax);
		System.out.println("elapsedTime 2: " + elapsedTime + "ms");	
	}
	
}
