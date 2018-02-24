package lab2;

import java.util.*;
public class TopKnumbers {

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

	public static void topKnumbers(){
		System.out.print("How many integers do you want to enter? ");

		Scanner sc = new Scanner(System.in);
		String inputs = sc.nextLine();

		try{

			int input = Integer.parseInt(inputs);
			int Arr[] = new int[input];

			System.out.println("Enter the numbers:");

			for(int i=0;i<Arr.length;i++){
				inputs = sc.nextLine();
				input = Integer.parseInt(inputs);
				Arr[i]= input;
			}

			//input integers
			System.out.print("Input Array = ");
			for(int i=0;i<Arr.length;i++){
				System.out.print(Arr[i]+" ");
			}

			//using Quick  sort to sort input integers;
			quicksort(Arr, 0, Arr.length-1);

			//Ask user to get how many top numbers
			System.out.print("\nHow many largest numbers do you want? ");
			inputs = sc.nextLine();

			input = Integer.parseInt(inputs);
			int topK[] = new int[input];
			int k =0;
			for(int i=Arr.length-1; i> (Arr.length- input- 1); i--)
			{
				topK[k]= Arr[i];
				k++;
			}

			System.out.print("Largest "+input+" numbers are :" );
			for(int i=0;i<k;i++){
				System.out.print(topK[i]+" ");
			}
		}
		catch(Exception ex){
			System.out.println("Wrong entry!");
		}
	}

	public static void main(String[] args) {
		//call function to find top K numbers!
		topKnumbers();
	}

}
