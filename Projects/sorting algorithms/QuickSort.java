package lab2;

public class QuickSort {

	public static int partition(int arr[],int p, int r){
		int temp,pivot=arr[p];
		int i=p;
		for(int j=p+1;j<=r;j++){
			if(arr[j]<=pivot){
				i++;
				//swap i and j
				temp = arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		//swap pivot with current index of i.
		temp = arr[p];
		arr[p]=arr[i];
		arr[i]=temp;
		
		return i;
	}
	
	public static void quicksort(int arr[], int p, int r){
		if(p<r){
			int q= partition(arr,p,r);
			quicksort(arr,p,q-1);
			quicksort(arr,q+1,r);
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
		//using Quick  sort to sort input integers;
		quicksort(Arr, 0, Arr.length-1);
		long end = System.nanoTime();
		System.out.print("\nOutput Array after QuickSort = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}

		System.out.println("\nTotal time spent by Quick Sort= "+(end-start)+" nanoseconds");


	}

}
