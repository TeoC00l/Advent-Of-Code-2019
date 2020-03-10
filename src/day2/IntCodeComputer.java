//Author: Teodor Tysklind
//https://adventofcode.com/2019/day/2#part2

package day2;

import java.util.Scanner;
import java.io.*;

public class IntCodeComputer {
	
	public static void run(int[] list) {
		boolean stop = false;
		int index = 0;
		
		list[1] = 12;
		list[2] = 2;
		
		while(!stop) {			
			
			if(list[index] == 1) {
				list[list[index+3]] = list[list[index+2]] + list[list[index+1]];
			}
			
			else if(list[index] == 2) {
				list[list[index+3]] = list[list[index+2]] * list[list[index+1]];
			}
			
			else if(list[index] == 99) {
				System.out.println("Program finished at index " + index + ", index 0 is " + list[0]);
				stop = true;				
			}else {
				System.out.println("Error");
				stop = true;
			}			
			index += 4;
		}
	}	

	public static void main (String[] args) throws IOException{

		File temp = new File("inputDay2.txt");
		Scanner scan = new Scanner(temp);
		
		String str = scan.nextLine();
		String[] strValues = str.split(",");
		
		int[] intList = new int[strValues.length];
		
		for(int i = 0 ; i < intList.length ; i++) {
			intList[i] = Integer.parseInt(strValues[i]);						
		}
		
		run(intList);
		scan.close();
	}
}
