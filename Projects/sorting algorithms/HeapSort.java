package lab2;

public class HeapSort {

	private static int A[];
	private static int length;


	public static void createheap(int A[]){
		length=A.length-1;
		for(int i=length/2;i>=0;i--){
			siftdown(A,i);
		}
	}

	public static void siftdown(int[] A, int i){ 
		int left=2*i;
		int right=2*i+1;
		int largest;
		if(left <= length && A[left] > A[i]){
			largest=left;
		}
		else{
			largest=i;
		}

		if(right <= length && A[right] > A[largest]){
			largest=right;
		}
		if(largest!=i){
			swap(i,largest);
			siftdown(A, largest);
		}
	}

	public static void swap(int i, int j){
		int t=A[i];
		A[i]=A[j];
		A[j]=t; 
	}

	public static void heapsort(int Arr[]){
		A=Arr;
		createheap(A);

		for(int i=length;i>0;i--){
			swap(0, i);
			length=length-1;
			siftdown(A, 0);
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
		//using Heap sort to sort input integers;
		heapsort(Arr);
		long end = System.nanoTime();
		System.out.print("\nOutput Array after Heap sort = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}

		System.out.println("\nTotal time spent by Heap Sort= "+(end-start)+" nanoseconds");

	}

}
