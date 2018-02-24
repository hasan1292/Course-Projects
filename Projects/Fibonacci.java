import java.util.*;
import java.math.BigInteger;

public class Fibonacci {


	public static void main(String[] args) {

		System.out.println("Enter the number: ");
		
		//take input 
		Scanner sc = new Scanner(System.in); 
		
			String inputS = sc.nextLine();
			try{
				long start = System.currentTimeMillis();
				
				//check if the entered input is integer
				int input = Integer.parseInt(inputS);
				
				//declare first BigInteger a and initialize with 0
				BigInteger a=BigInteger.valueOf(0);
				
				//declare second BigInteger b and initialize with 1
				BigInteger b=BigInteger.valueOf(1);
				
				//declare BigInteger result and initialize with 0
				BigInteger result=BigInteger.valueOf(0);
				
				//run for loop from 0 until input-1
				for (int i=0;i<input-1;i++){
					result = a.add(b);
					a=b;
					b= result;
				}
				
				//output result
				System.out.println("F"+inputS+"= "+result);
				
				long end = System.currentTimeMillis();
				
				System.out.println("\nTotal time taken: "+(end-start)+" ms");
			}
			catch(Exception ex){
				System.out.println("Wrong input!");
			}
		}
	
}

