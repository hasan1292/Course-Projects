package combinatoricsProjects;

import java.math.BigInteger;
import java.util.Scanner;

public class Integer_Partition {
	
	static int count = 0;
	
	public static void main(String args[]) {
		System.out.println("Welcome to Integer Partition Project by Hasan Iqbal!");
		
		System.out.println("Press 1 if you just want total number of partitions. Press 2"
				+ " if you want possible enumrations as well");
		Scanner sc = new Scanner(System.in);
		String inputS = sc.nextLine();
		
		switch (inputS) {
		
			case "1": {
				try {
					System.out.println("Enter the number for calculating total number of partitions: ");
					
					sc = new Scanner(System.in);
					
					inputS = sc.nextLine();
					
					int input = Integer.parseInt(inputS);
					
					System.out.print("Total number of partitions of number "+input+" = ");
					
					long start = System.currentTimeMillis();
					
					//call the method for calculating total number of partitions.
					System.out.println(TotalNumberOfPartitions(input));
					
					long end = System.currentTimeMillis();
					
					System.out.println("\nTotal time spent = "+(end-start)+" ms");
					
				} catch (Exception ex) {
					System.out.println("Wrong Input! Please try again!");
				}
				break;
			}
			case "2": {
				try {
					System.out.println("Enter the number for enumerating number of partitions: ");
					
					sc = new Scanner(System.in);
					
					inputS = sc.nextLine();
					
					int input = Integer.parseInt(inputS);
					
					long start = System.currentTimeMillis();
					
					//call the method for enumerating all the partitions
					partitionNumber(input);
					
					System.out.println("\nTotal number of partitions: "+count);
					
					long end = System.currentTimeMillis();
					
					System.out.println("\nTotal time spent = "+(end-start)+" ms");
					
				} catch (Exception ex) {
					System.out.println("Wrong Input! Please try again!");
				}
				break;
			}
			default:
				System.out.println("Wrong Input! Please try again!");
				break;
		}
				
	}
	
	//method called from main for Partitioning of number (all possible scenarios)
    public static void partitionNumber(int number) {
    	//calls overloaded method with the same number for the purpose of number and maximum
        partitionNumber(number, number, "");
    }
    
    //method called by other overloaded method (partitionNumber)
    public static void partitionNumber(int number, int maximum, String smallerIntegers) {
        
    	//if the number becomes 0, output the the last possible smaller integer and return
    	if (number == 0) {
            System.out.println(smallerIntegers);
        	count++;
            return;
        }
  
    	//enumerate all the possibilities by decrementing from the maximum number and check all the possibilities
    	//initial value of i is taken by taking the minimum between maximum and number.
        for (int i = Math.min(maximum, number); i >= 1; i--) {
            partitionNumber(number-i, i, smallerIntegers + " " + i);
        }
    }

	
	
	//method to get just the total number of partitions.
	public static String TotalNumberOfPartitions(int number) {
		//return 0 if entered number is less than 0 as partition of negative numbers is not possible
		if (number < 0)
			return "0";
		
		//convert the number into double and take its squareRoot
		int sqrtNumber = (int) Math.sqrt(1.0d + number);
		
		//here I applied the method shown by Ma'am in the videos
		
		//I created an array of size 2 times of sqrtNumber + 2 for saving the respective signs needed ahead
		int signedArray[] = new int[2 * sqrtNumber + 2];
		
		//I created an other array of size 2 times of sqrtNumber + 2 for saving the processed digits.
		int calculationsArray[] = new int[2 * sqrtNumber + 2];
		
		//initializations of first and seconds values of signedArray and calculationsArray
		signedArray[0] = -1;
		signedArray[1] = 1;
		calculationsArray[0] = 0;
		calculationsArray[1] = 1;
		
		//running a for loop from 1 till sqrtNumber
		for (int a = 1; a <= sqrtNumber; a++) {
			
			//2 lines below initiates signedArray in a way that even numbers are negative and odd are positive
			signedArray[2 * a] = -signedArray[2 * a - 2];
			signedArray[2 * a + 1] = -signedArray[2 * a - 1];
			
			//here is the chain multiplication happening 
			calculationsArray[2 * a] = (a * (3 * a + 1)) / 2;
			calculationsArray[2 * a + 1] = ((a + 1) * (3 * a + 2)) / 2;
		}
		//end of a loop
		
		//declared a BigInteger array to store more values inside each index of mainArray
		BigInteger mainArray[] = new BigInteger[number + 1];
		
		//initializing mainArray by long of 1.
		mainArray[0] = BigInteger.valueOf(1l);
		
		//running another array from 1 to the given number
		for (int b = 1; b <= number; b++) {
			
			//declaring a BigInteger partialSum to hold values in between values of calculations
			BigInteger partialSum = BigInteger.valueOf(0l);
			
			//running an inner for loop such that value of particular calculationsArray[k] index is less than outer loop b
			for (int k = 1; calculationsArray[k] <= b; k++) {
				
				//if index k of Signed array is positive i.e. 1, add in partial sum
				if (signedArray[k] == 1) {
					partialSum = partialSum.add(mainArray[b - calculationsArray[k]]);
				}
				//else subtract from the partial sum
				else 
				{	
					partialSum = partialSum.subtract(mainArray[b - calculationsArray[k]]);
				}
			}

			//save the value of partialSum in particular index of mainArray
			mainArray[b] = partialSum;
		} 
		// end of b loop
		
		//Now we will have many values in array from x^1, x^2 till...... x^n. We will need the value which is x^number
		//return the number in the array by converting it into string
		return mainArray[number].toString();
	}
}