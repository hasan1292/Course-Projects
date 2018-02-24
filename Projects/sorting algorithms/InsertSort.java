package lab2;

public class InsertSort {

	public static void insertsort(int arr[]){
		int key,j;
		for(int i=1;i<arr.length;i++)
		{
			key = arr[i];
			j=i-1;
			while(j>=0 && arr[j]>key){
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1]= key;
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
		//using insert sort to sort input integers;
		insertsort(Arr);
		long end = System.nanoTime();
		System.out.print("\nOutput Array after Insert sort = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}

		System.out.println("\nTotal time spent by Insert Sort= "+(end-start)+" nanoseconds");


	}

}
