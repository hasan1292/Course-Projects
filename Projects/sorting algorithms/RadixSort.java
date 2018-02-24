package lab2;

public class RadixSort {

	public static void radixsort( int[] A)
	{
		int MaxNum = A[0];
		int Exponent = 1;
		int n = A.length;
		int[] B = new int[n];
		
		//find max number
		for (int i = 1; i < n; i++)
			if (A[i] > MaxNum)
				MaxNum = A[i];
		
		//run the loop until max number divided by exponent becomes 0
		while (MaxNum / Exponent > 0)
		{
			int[] bucket = new int[10];

			for (int i = 0; i < n; i++)
				bucket[(A[i] / Exponent) % 10]++;
			for (int i = 1; i < 10; i++)
				bucket[i] += bucket[i - 1];
			for (int i = n - 1; i >= 0; i--)
				B[--bucket[(A[i] / Exponent) % 10]] = A[i];
			for (int i = 0; i < n; i++)
				A[i] = B[i];
			Exponent *= 10;        
		}
	} 

	public static void main(String[] args) {
		//Input integers, radix sort works primarily for non-negative integers
		int Arr[] = {78,10,4,123,43,12,211,32,11,45,87,243,1,321,54,0,89};

		System.out.print("Input Array = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}
		long start = System.nanoTime();
		//using Radix sort to sort input integers;
		radixsort(Arr);
		long end = System.nanoTime();
		System.out.print("\nOutput Array after Radix sort = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}

		System.out.println("\nTotal time spent by Radix Sort= "+(end-start)+" nanoseconds");

	}

}
