package lab2;

public class MergeSort {

	public static 
	
	void merge(int A[], int p, int q, int r){
        //declare sentinel value to some value which won't occur in our data set
		//ideally according to pseudocode it should have been +infinity for ascending list
		final int SENTINEL = 9999999;
        int n1= q-p+1;
        int n2= r-q;
        int L[] = new int[n1+1];
        int R[] = new int[n2+1];
        
        
        for(int i=0;i<n1;i++){
            L[i] = A[p+i];
        }
        for(int j=0;j<n2;j++){
            R[j] = A[q+j+1];
        }
        L[n1] = SENTINEL;
        R[n2] = SENTINEL;
        
        int i = 0;
        int j = 0;
        
        for(int k=p; k<r+1; k++){
            if(L[i]<= R[j]){
                A[k] = L[i];
                i++;
            }
            else{
                A[k]= R[j];
                j++;
            }
        }
	}
	
	public static void mergesort(int arr[],int p,int r){
		if(p<r){
            int q = (p+r)/2;
            mergesort(arr, p,q);
            mergesort(arr, q+1, r);
            merge(arr,p,q,r);
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
		//using merge sort to sort input integers;
		mergesort(Arr, 0, Arr.length-1);
		long end = System.nanoTime();
		System.out.print("\nOutput Array after MergeSort = ");
		for(int i=0;i<Arr.length;i++){
			System.out.print(Arr[i]+" ");
		}

		System.out.println("\nTotal time spent by Merge Sort= "+(end-start)+" nanoseconds");
	}

}
