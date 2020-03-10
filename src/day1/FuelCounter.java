//Author: Teodor Tysklind

package day1;
import java.io.*;
import java.util.Scanner;

public class FuelCounter {
	
	public static void main(String[] args) throws IOException {		
		File temp = new File("input.txt");
		Scanner scan = new Scanner(temp);
		
		int subtotalFuel = 0;
		
		while(scan.hasNext()) {
			subtotalFuel += scan.nextInt()/3-2;
		}
		
		System.out.println(subtotalFuel);
		scan.close();

	}
}
