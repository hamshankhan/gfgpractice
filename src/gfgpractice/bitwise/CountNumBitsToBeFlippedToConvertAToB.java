package gfgpractice.bitwise;

import java.util.Scanner;

public class CountNumBitsToBeFlippedToConvertAToB {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of a and b:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("Number of bits to be flipped to convert A to B:"+countNumOfSetBits(a^b));
	}
	static int countNumOfSetBits(int num){
		int numSetBit = 0;
		while(num !=0){
			num = num & (num-1);
			numSetBit++;
		}
		return numSetBit;
	}
}
