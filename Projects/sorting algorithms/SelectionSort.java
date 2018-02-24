package lab2;

public class SelectionSort {

	public static void selectionsort(int arr[]){
		int index,temp;
		
		for(int i=0;i<arr.length-1;i++){
			index=i;
			//check the minimum number in array for each loop
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[index])
					index= j;
			}
			if(i!= index){
				//swap places
				temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
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
		//using selection sort to sort input integers;
		selectionsort(Arr);
		long end = System.nanoTime();
		System.out.print("\nOutput Array after Selection sort = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}
		
		System.out.println("\nTotal time spent by Selection Sort= "+(end-start)+" nanoseconds");

	}

}
