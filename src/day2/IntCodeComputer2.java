//Author: Teodor Tysklind
//https://adventofcode.com/2019/day/2#part2
package day2;

import java.util.Scanner;
import java.io.*;

public class IntCodeComputer2 {
	private final int DESIRED_OUTPUT = 19690720;

	private int index = 0;
	private int noun = 0;
	private int verb = 0;
	private int[] cachedProgram;
	private int[] program;
	
	public IntCodeComputer2(int[] list) {
			cachedProgram =list;	
	}
	
	private void resetMemory() {
		int[]  program = new int[cachedProgram.length];
		
		for(int i = 0; i < program.length ; i++) {
			program[i] = cachedProgram[i];
		}		
		this.program = program;
	}
	
	
	private void updateInputPair() {			
		if(verb == 99) {
			noun++;
			verb = 0;
		}
		else {				
			verb++;
		}
		index = 0;
		program[index+1] = noun;
		program[index+2] = verb;
	}
	
	public void run() {
		boolean stop = false;
		
		resetMemory();		
		
		while(!stop) {
					
			switch (program[index]) {			
			case 1:
				program[program[index+3]] = program[program[index+2]] + program[program[index+1]];
				break;			
			case 2:
				program[program[index+3]] = program[program[index+2]] * program[program[index+1]];
				break;			
			case 99:
				if(program[0] == DESIRED_OUTPUT) {
					System.out.println("Program finished at index " + index + ", index 0 is " + program[0]);
					System.out.println("the noun is: " + noun + ". The verb is: " + verb + ". 100 * noun + verb is: " + (100 * noun + verb));					
					stop = true;
				}else {
					resetMemory();
					updateInputPair();
				}
				break;			
			default:
				System.out.println("Error - Unknown Opcode");
				stop = true;
				break;
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
		
		IntCodeComputer2 intCodeComputer = new IntCodeComputer2(intList);
		
		intCodeComputer.run();
		scan.close();
	}
}
