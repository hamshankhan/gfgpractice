package gfgpractice.bitwise;

import java.util.Scanner;

public class CountSetBitsInAnInteger {
	public static void main(String []args){
		System.out.print("Enter an integer:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("Number of set bits using normal method:"+normalMethod(number));
		System.out.println("Number of set bits usingBitwiseOperatorsMethod:"+usingBitwiseOperatorsMethod(number));
		System.out.println("Number of set bits usingBrianKernighanMethod:"+usingBrianKernighanMethod(number));
	}
	static int normalMethod(int num){
		int setBitCounter = 0;
		while(num != 0){
			if (num % 2 == 1){
				setBitCounter ++;
			}
			num/=2;
		}
		return setBitCounter;
	}
	static int usingBitwiseOperatorsMethod(int num){
		int setBitCounter = 0;
		while(num != 0){
			setBitCounter += num & 1;
			num = num >> 1;
		}
		return setBitCounter;
	}
	static int usingBrianKernighanMethod(int num){
		int setBitCounter = 0;
		while(num != 0){
			num = num & (num - 1);
			setBitCounter++;
		}
		return setBitCounter;
	}
}
