package lab2;

public class CountingSort {

	public static void countingsort(int A[], int B[]){
		int lowest=A[0], highest = A[0];

		//we find the lowest and highest to find the range.
		for(int i=0;i <A.length; i++)
		{
			if(A[i]<lowest)
				lowest = A[i];
			if(A[i]>highest)
				highest= A[i];
		}
		//define the range.
		int range = highest - lowest +1;
		int C[] = new int[range];
		for(int i=0;i<C.length;i++)
			C[i] = 0;

		//calculate frequencies of each number
		for(int j=0;j<A.length;j++)
		{
			C[A[j]-lowest]++;
		}

		C[0]--;
		for(int i=1;i<C.length;i++)
			C[i]=C[i]+C[i-1];

		//sort using frequencies calculated before
		for(int j=A.length-1;j>=0;j--){
			B[C[A[j]-lowest]]=A[j];
			C[A[j]-lowest] = C[A[j]-lowest]-1;
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
		//using Counting sort to sort input integers;
		int Bar[]=new int[Arr.length];
		countingsort(Arr,Bar);
		long end = System.nanoTime();
		System.out.print("\nOutput Array after Counting sort = ");
		for(int i=0;i<Bar.length;i++){
			System.out.print(Bar[i]+" ");
		}

		System.out.println("\nTotal time spent by Counting Sort= "+(end-start)+" nanoseconds");


	}

}
