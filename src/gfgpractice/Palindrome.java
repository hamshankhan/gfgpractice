package gfgpractice;

import java.util.Scanner;

public class Palindrome {
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an integer:");
		int num = sc.nextInt();
		System.out.println("Given number is palindrome:"+isPalindrome(num));
		System.out.println("Given number is palindrome:"+isPalindromeWithoutUsingExtraSpace(num));
	}
	static boolean isPalindrome(int num){
		int tempNum = num;
		int newNum=0;
		while(num!=0){
			newNum = newNum*10 + (num % 10);
			num /= 10;
		}
		if(newNum == tempNum){
			return true;
		} else {
			return false;
		}
	}
	
	static boolean isPalindromeWithoutUsingExtraSpace(int num){
		int divisor = 1;
		while(num / divisor >= 10)
			divisor *= 10;
		while(num!=0){
			int leading = num / divisor;
			int trailing = num % 10;
			if (leading != trailing){
				return false;
			}
			num = (num % divisor) / 10;
			divisor /= 100;
		}
		return true;
	}
}
