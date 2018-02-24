package combinatoricsProjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Permutations Project.");
		System.out.println("This project has 2 implementations, Lexicographic and My own implementation");
		System.out.println("I call my own implementation = 'HasanAlgo'");

		System.out.println("\nPlease input the number!");

		Scanner sc = new Scanner(System.in);
		String inputS = sc.nextLine();

		String saveInput = inputS;
		try {
			Integer.parseInt(inputS);
		} catch (Exception ex) {
			System.out.println("Your input is non-numeric. Please try again");
			System.exit(-1);
		}

		int len = inputS.length();

		// declare an Integer array of size of input
		Integer input[] = new Integer[len];

		// Hashmap to check number of occurences of particular digit
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < len; i++) {
			input[i] = Character.getNumericValue(inputS.charAt(i));
			hm.put(input[i], 0);
		}

		// check the number of occurrences of particular digit in input
		for (int i = 0; i < len; i++) {

			int p = hm.get(input[i]);
			p++;
			hm.put(input[i], p);

		}

		Boolean repeatedValue = false;

		// check if there is repeated value
		for (int i = 0; i < len; i++) {
			if (hm.get(input[i]) > 1)
				repeatedValue = true;
		}

		if (repeatedValue) {
			System.out.println("Your input contains repeated element");
			System.out.println("Since Lexicographic method cannot handle repetitions, It will be processed"
							+ "By 'HasanAlgo'\n");
			System.out.println("Press any key to continue!");
			sc = new Scanner(System.in);
			sc.nextLine();
			HasanAlgo(saveInput);
		} else {
			System.out.println("Your input does not contain repeated elements");
			System.out.println("Now you have two choices");
			System.out.println("Press 0 for Lexicographic Method (faster)");
			System.out
					.println("Press 1 for 'HasanAlgo' which is relativily slower");

			sc = new Scanner(System.in);
			inputS = sc.nextLine();
			if (inputS.contains("0")) {
				System.out
						.println("Generating permutations by Lexicographic Method\n");

				Integer a[] = new Integer[len];
				try {
					for (int i = 0; i < len; i++) {
						a[i] = Character.getNumericValue(saveInput.charAt(i));
					}
				} catch (Exception ex) {

				}
				Arrays.sort(a);
				for (int i = 0; i < len; i++) {
					System.out.print(a[i] + " ");
				}
				Lexicographic(a);

			} else if (inputS.contains("1")) {
				System.out.println("Generating permutations by 'HasanAlgo'\n");
				HasanAlgo(saveInput);
			} else {
				System.out.println("Wrong input! Please try again");
			}

		}
	}

	public static boolean ContainsNext(Integer[] a) {
		int n = a.length;

		// search for elements on right of element a[k] i.e. smaller than
		// element to its right
		int k;
		for (k = n - 2; k >= 0; k--)
			if (a[k] < a[k + 1])
				break;

		// return false if no more permutations
		if (k == -1)
			return false;

		// search for elements on right of element a[j] that is greater than
		// a[k]
		int j = n - 1;
		while (a[k] > a[j])
			j--;

		// swap
		int temp = a[k];
		a[k] = a[j];
		a[j] = temp;

		for (int r = n - 1, s = k + 1; r > s; r--, s++) {
			// swap again
			temp = a[r];
			a[r] = a[s];
			a[s] = temp;
		}

		// return true because there are more permutations
		return true;
	}

	public static void Lexicographic(Integer[] a) {

		// initialize counter
		int count = 1;

		// print first permutation
		System.out.print("No" + count + " : ");
		count++;
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);

		System.out.print("\n");
		while (ContainsNext(a)) {
			// print rest of the permutations
			System.out.print("No" + count + " : ");
			count++;
			for (int i = 0; i < a.length; i++)
				System.out.print(a[i]);
			System.out.print("\n");
		}
		
		count--;
		System.out.println("Total number of Permutations: " +count);

	}

	public static void HasanAlgo(String inputS) {
		int len = inputS.length();

		// one of the hashmap to check the number of occurences of particular
		// digit in input
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		// other hashmap to check the number generated in while loop has many
		// particular digits
		HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();

		// declare an Integer array of size of input
		Integer digits2[] = new Integer[len];

		try {
			for (int i = 0; i < len; i++) {
				// put the number at particular posting of String in digits2 as
				// well as hm
				digits2[i] = Character.getNumericValue(inputS.charAt(i));
				hm.put(digits2[i], 0);
			}
		} catch (Exception ex) {

		}

		// declare another Integer array of size of input
		Integer digits[] = new Integer[len];
		int count = 0;

		// check the number of occurrences of particular digit in input
		for (int i = 0; i < len; i++) {

			int p = hm.get(digits2[i]);
			p++;
			hm.put(digits2[i], p);

			digits[i] = 0;
		}
		// an array list which contains the allowed digits
		ArrayList rl = new ArrayList();

		// initially add all the elements which appear more than once in rl
		for (int i = 0; i < len; i++) {
			if (hm.get(digits2[i]) > 1)
				rl.add(digits2[i]);
		}

		// declare new array list
		ArrayList al = new ArrayList();

		// add all elements of array list in digits2[i]
		for (int i = 0; i < len; i++) {
			al.add(digits2[i]);
		}

		// some boolean variables necessary for checking certain conditions
		Boolean check = false;
		Boolean checkValid = false;
		Boolean breakLoop = false;

		// initiate while loop
		while (true) {
			check = false;
			checkValid = false;

			// increment first digit by 1 in every iteration
			digits[0]++;

			/*
			 * This for loop check if digits[0] reaches 10, it is again reset to
			 * 1 and digits[1] is incremented by 1 and so on. It sets breakLoop
			 * check = true if digits[length -1] reaches 10.
			 */
			for (int i = 0; i < len; i++) {
				if (i == len - 1) {
					if (digits[i] == 10)
						breakLoop = true;
				} else {
					if (digits[i] == 10) {
						digits[i] = 0;
						digits[i + 1]++;
					}
				}
			}

			// go to next iteration of while loop
			if (breakLoop)
				break;

			// empty the hm2 hashmap
			hm2.clear();

			// put 0 value in hm2 for all digits[i] as keys
			for (int i = 0; i < len; i++) {
				hm2.put(digits[i], 0);
			}

			// check occurrences of particular digits[i] in number
			for (int i = 0; i < len; i++) {
				int p = hm2.get(digits[i]);
				p++;
				hm2.put(digits[i], p);
			}

			// check if the number generated is the valid number same as input
			for (int i = 0; i < len; i++) {
				if (!al.contains(digits[i]))
					checkValid = true;
			}

			for (int i = 0; i < len; i++) {
				// check if the occurrence of particular digit is > 1 and it is
				// not in rl for each digits
				if (hm2.get(digits[i]) > 1 && !rl.contains(digits[i])) {
					check = true;
					break;
				}

				// if it is not valid then check if value of particular digit in
				// hm2 is greater than hm1
				if (!checkValid)
					if (hm2.get(digits[i]) > hm.get(digits[i])) {
						check = true;
						break;
					}
			}

			// if check is true, go to next iteration of while loop
			if (check)
				continue;

			// if checkValid is true, go to next iteration of while loop
			if (checkValid)
				continue;

			// increment counter to keep track of permutation number
			count++;

			// output the permutation
			System.out.print("No" + count + " : ");
			for (int i = 0; i < len; i++) {
				System.out.print(digits[i]);
			}
			System.out.println();
			
			
		}

		System.out.println("Total number of Permutations: "+count);
	}

}
