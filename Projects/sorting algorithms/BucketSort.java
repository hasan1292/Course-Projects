package lab2;

public class BucketSort {

	public static void bucketsort(int A[], int B[]) 
	{
		int lowest=A[0], highest = A[0];

		//we find the lowest and highest to find the range.
		for(int i=0;i <A.length; i++)
		{
			if(A[i]<lowest)
				lowest = A[i];
			if(A[i]>highest)
				highest= A[i];
		}
		//create new bucket
		int[] Bucket = new int[(highest - lowest) + 1];

		//find the right bucket for each element
		for (int i = 0; i < A.length; i++)
			Bucket[A[i]-lowest]++;

		int outPos = 0;
		for (int i = 0; i < Bucket.length; i++)
			for (int j = 0; j < Bucket[i]; j++)
				B[outPos++] = i + lowest;

	}

	public static void main(String[] args) {
		//Input integers
		int Arr[] = {10,5,-7,3,11,2,13,1,14,0,4,9,11,-3,7,12};

		System.out.print("Input Array = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}
		long start = System.nanoTime();
		//using Bucket sort to sort input integers;
		int Bar[]=new int[Arr.length];
		bucketsort(Arr,Bar);
		long end = System.nanoTime();
		System.out.print("\nOutput Array after Bucket sort = ");
		for(int i=0;i<Bar.length;i++){
			System.out.print(Bar[i]+" ");
		}

		System.out.println("\nTotal time spent by Bucket Sort= "+(end-start)+" nanoseconds");

	}

}
