package gfgpractice;

import java.util.Scanner;

public class BinToDecConversion {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a binary sequence:");
		int binNum = sc.nextInt();
		System.out.println("Dec number for the given binarySequence:"+binToDecUsingNormalMethod(binNum));
		System.out.print("Enter a long binary sequence:");
		String longBinSequence = sc.next();
		System.out.println("Dec number for the given binary sequence:"+binToDecUsingNormalMethod(longBinSequence));
		sc.close();
	}
	static int binToDecUsingNormalMethod(int num){
		int decNum = 0;
		int multiplicationFactor = 1;
		while(num!=0){
			decNum = decNum + (num % 10) * multiplicationFactor; 
			multiplicationFactor *= 2;
			num/=10;
		}
		return decNum;
	}
	static int binToDecUsingNormalMethod(String num){
		int decNum = 0;
		int multiplicationFactor = 1;
		for(int i = num.length() - 1; i >= 0; i--){
			decNum = decNum + Character.getNumericValue(num.charAt(i)) * multiplicationFactor;
			multiplicationFactor *= 2;
		}
		return decNum;
	}
}