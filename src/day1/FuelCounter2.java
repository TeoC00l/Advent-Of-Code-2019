//Author: Teodor Tysklind

package day1;
import java.io.*;
import java.util.Scanner;

public class FuelCounter2 {
	
	public static int calculateFuel (int mass) {
		int fuel = mass/3-2;
		
		if(fuel <= 0) {
			return 0;
		}else {
			fuel += calculateFuel(fuel);
			return fuel;
		}		
	}
	
	public static void main(String[] args) throws IOException {		
		File temp = new File("input.txt");
		Scanner scan = new Scanner(temp);
		
		int subtotalFuel = 0;
		
		while(scan.hasNext()) {
			subtotalFuel += calculateFuel(scan.nextInt());
		}
						
		System.out.println(subtotalFuel);
		scan.close();

	}
}