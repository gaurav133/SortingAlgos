import java.util.Scanner;


public class RadixSort {
	
	public int[] countingSort(int arr[], int range) {
		
		int output[] = new int[arr.length];
		
		if (arr == null || arr.length == 0) 
			return null;
		
		//Create temp array equal to range.
		int temp[] = new int[range + 1];
		
		//Traverse array.
		for (int i = 0; i < arr.length; i++) {
			temp[arr[i]]++;
		}
		
		//Add elements to determine positions.
		for (int i = 1; i < range + 1; i++) {
			temp[i] += temp[i-1];
		}
		
		//Store in output array.
		for (int i = 0; i < arr.length; i++) {
			output[temp[arr[i]]-1] = arr[i];
			temp[arr[i]]--;
		}
		
		return output;
	}

    public int[] countingRadixSort(int arr[], int range, int factor) {
		
		int output[] = new int[arr.length];
		
		if (arr == null || arr.length == 0) 
			return null;
		
		//Create temp array equal to range.
		int temp[] = new int[range + 1];
		
		//Traverse array.
		for (int i = 0; i < arr.length; i++) {
			temp[(arr[i]/factor)%10]++;
		}
		
		//Add elements to determine positions.
		for (int i = 1; i < range + 1; i++) {
			temp[i] += temp[i-1];
		}
		
		//Store in output array.
		for (int i = arr.length - 1; i >= 0; i--) {
			output[temp[(arr[i]/factor)%10]-1] = arr[i];
			temp[(arr[i]/factor)%10]--;
		}
		
		return output;
	}
	
	public static void main(String args[]) {
		int array[], num, range;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of elements and range:");
		num = scanner.nextInt();
		range = scanner.nextInt();
		
		array = new int[num];
		
		System.out.println("Enter array:");
		for (int i = 0; i < num; i++) {
			array[i] = scanner.nextInt();
		}
		
		RadixSort sort = new RadixSort();
		array = sort.radixSortWrapper(array);
		
		System.out.println("Output: ");
		for (int i = 0; i < num; i++) {
			System.out.println(array[i] + " ");
		}
	}
	
	public int returnMaxNumber (int arr[]) {
		int max = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) 
				max = arr[i];
		}
		
		return max;
	}
	
	public int[] radixSortWrapper(int arr[]) {
		
		int dividingFactor = 1;
		int max;
		
		//Call radix sort n times, where n is max number of digits.
		max = returnMaxNumber(arr);
		
		for (; max/dividingFactor > 0; dividingFactor *= 10) {
			arr = radixSort(arr, dividingFactor);
		}
		
		return arr;
	}
	
	public int[] radixSort(int arr[], int factor) {
		
		int output[] = new int[arr.length];
		
		output = countingRadixSort(arr, 9, factor);
		
		return output;
		
	}
}
