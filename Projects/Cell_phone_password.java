package combinatoricsProjects;

public class Cell_phone_password {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		calculate_4pin_Iphone_passwords();
		calculate_6pin_Iphone_passwords();
		calculate_Android_phone_passwords();
		
		long end = System.currentTimeMillis();
		long total = end - start;
		System.out.println("\nTotal time spent = "+total+" milliseconds");
	}
	
	public static void calculate_4pin_Iphone_passwords(){
		//declare the number of digits we want to check
				Integer digits[] = new Integer[4];
				int count = 0;

				//initialize digits with 0
				for (int i = 0; i < 4; i++) {
					digits[i] = 0;
				}
				
				//increase counter as 0000 is also a possible password 
				count++;

				//boolean check to make sure loop terminates at certain point
				boolean breakLoop = false;

				while (true) {
					//at every iteration, increase first digit by 1
					digits[0]++;
					
					/* This for loop check if digits[0] reaches 10, it is again reset to 0 and digits[1] is incremented
					by 1 and so on. It sets breakLoop check = true if digits[3] reaches 10.
					*/
					for (int i = 0; i < 4; i++) {
						if (i == 3) {
							if (digits[i] == 10)
								breakLoop = true;
						} else {
							if (digits[i] == 10) {
								digits[i] = 0;
								digits[i + 1]++;
							}
						}
					}
					//jump out of the while loop if true
					if (breakLoop)
						break;

					//increment the counter by 1
					count++;
				}

				//output the result
				System.out.println("Total number of feasible passwords in 4 pin Iphone Lock: "+ count);
	}
	
	public static void calculate_6pin_Iphone_passwords(){
		//declare the number of digits we want to check
				Integer digits[] = new Integer[6];
				int count = 0;

				//initialize digits with 0
				for (int i = 0; i < 6; i++) {
					digits[i] = 0;
				}
				
				//increase counter as 000000 is also a possible password 
				count++;

				//boolean check to make sure loop terminates at certain point
				boolean breakLoop = false;

				while (true) {
					//at every iteration, increase first digit by 1
					digits[0]++;
					
					/* This for loop check if digits[0] reaches 10, it is again reset to 0 and digits[1] is incremented
					by 1 and so on. It sets breakLoop check = true if digits[5] reaches 10.
					*/
					for (int i = 0; i < 6; i++) {
						if (i == 5) {
							if (digits[i] == 10)
								breakLoop = true;
						} else {
							if (digits[i] == 10) {
								digits[i] = 0;
								digits[i + 1]++;
							}
						}
					}
					//jump out of the while loop if true
					if (breakLoop)
						break;

					//increment the counter by 1
					count++;
				}

				//output the result
				System.out.println("Total number of feasible passwords in 6 pin Iphone Lock: "+ count);
	}
	
	public static void calculate_Android_phone_passwords(){
		//a 2D array for checking the non allowed paths
				Integer validate[][] = new Integer[10][10];

				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						validate[i][j] = 0;
					}
				}

				// put all paths which have intermediate nodes
				validate[1][3] = 2;
				validate[1][7] = 4;
				validate[1][9] = 5;
				validate[2][8] = 5;
				validate[3][1] = 2;
				validate[3][7] = 5;
				validate[3][9] = 6;
				validate[4][6] = 5;
				validate[6][4] = 5;
				validate[7][1] = 4;
				validate[7][3] = 5;
				validate[7][9] = 8;
				validate[8][2] = 5;
				validate[9][1] = 5;
				validate[9][3] = 6;
				validate[9][7] = 8;
				
				//Set all the boolean flag for checking different thing
				Boolean check = false;
				Boolean checkValid = false;
				Boolean breakLoop = false;
				Boolean checkPossible = false;

				//Boolean array for keeping the track of used dots/points
				Boolean booleanArray[] = new Boolean[10];

				//initialize 0 as true;
				booleanArray[0] = true;

				//initialize rest of the array as false;
				for (int i = 1; i < 10; i++)
					booleanArray[i] = false;

				//for saving the count of all feasible passwords
				int count[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

				/* 
				run for loop so that it runs for all the allowed numbers of dots connected
				e.g. first it will run for all the possible passwords when 4 dots/points are connected
				then it will run for 5 then 6,7,8 dots until 9 dots.
				*/
				for (int length = 4; length < 10; length++) {

					//declare an integer for the corresponding length
					Integer digits[] = new Integer[length];

					//initialize the digits array as 0
					for (int i = 0; i < length; i++) {
						digits[i] = 1;
					}

					//make sure all variables are false again for next iteration of For loop
					check = false;
					checkValid = false;
					breakLoop = false;
					checkPossible = false;

					//start while loop
					while (true) {
						check = false;
						checkValid = false;
						checkPossible = false;
						
						//at every iteration, increase first digit by 1
						digits[0]++;

						/* This for loop check if digits[0] reaches 10, it is again reset to 1 and digits[1] is incremented
						by 1 and so on. It sets breakLoop check = true if digits[length -1] reaches 10.
						*/
						for (int i = 0; i < length; i++) {
							if (i == length - 1) {
								if (digits[i] == 10)
									breakLoop = true;
							} else {
								if (digits[i] == 10) {
									digits[i] = 1;
									digits[i + 1]++;
								}
							}
						}
						//jump out of the while loop if true
						if (breakLoop)
							break;
						
						//check if there is any repetition in the digits array. If there is, go to next iteration
						for (int a = 0; a < length; a++) {
							for (int b = a + 1; b < length; b++) {
								if (digits[a] == digits[b]) {
									check = true;
									break;
								}
							}
							if (check)
								break;
						}

						//if there is repeated element, go to next iteration of while loop
						if (check)
							continue;

						//here it checks if there is any path which passes through the non-allowed paths
						for (int k = 0; k < length - 1; k++) {

							if (validate[digits[k]][digits[k + 1]] != 0) {
								checkValid = true;
								break;
							}

						}

						/*if there is path which passes through the non-allowed paths, check if it is allowed?
						 *i.e. if that dot/point is already used!
						*/
						if (checkValid) {
							for (int i = 0; i < length - 1; i++) {
								//keep track of all used dots
								booleanArray[digits[i]] = true;

								if (booleanArray[validate[digits[i]][digits[i + 1]]])
									checkPossible = true;
								else {
									checkPossible = false;
									break;
								}
							}
						}

						//if path is allowed, increment the counter
						if (checkPossible)
							count[length]++;

						//reset the boolean Track array to false
						for (int i = 0; i < length - 1; i++) {
							booleanArray[digits[i]] = false;
						}

						//if true, move to the next iteration 
						if (checkValid)
							continue;
						
						//Increment the counter of respective path length
						count[length]++;
					}
					//output the value of certain length
					System.out.println("Total number of feasible passwords in Android by connecting "
							+ length + " dots: " + count[length]);

				}

				int finalPossibilities = 0;

				//calculate the total sum
				for (int i = 4; i < 10; i++) {
					finalPossibilities += count[i];
				}
				
				//output the total sum
				System.out
						.println("Total number of feasible passwords in Android Phone lock: "
								+ finalPossibilities);
	}

}
