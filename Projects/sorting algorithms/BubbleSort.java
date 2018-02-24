package lab2;

public class BubbleSort {

	public static void bubblesort(int arr[]){
		//this bool variable to check if the array is already sorted then for loop terminates
		Boolean check = true;
		for(int i=0; i< arr.length-1; i++){
			for(int j=0;j<arr.length-1; j++){
				if(arr[j]> arr[j+1]){
					//perform swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]= temp;
					check = true;
				}
			}
			//check if all the array is already sorted, then break out of the main loop
			if(!check)
				break;
			check = false;
		}
	}

	public static void main(String[] args) {
		//Input integers
		int Arr[] = {10,5,-7,3,11,2,13,1,14,0,4,9,11,-3,7,12};

		System.out.print("Input Array = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}
		long start = System.nanoTime();
		//using bubble sort to sort input integers;
		bubblesort(Arr);
		long end = System.nanoTime();
		System.out.print("\nOutput Array after BubbleSort = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}
		
		System.out.println("\nTotal time spent by Bubble Sort= "+(end-start)+" nanoseconds");

	}

}
