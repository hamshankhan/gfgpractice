package gfgpractice.maths;

public class CountPairsWhoseSumOfCubesIsN {
	public static void main(String []args){
		for(int i=1; i<=30; i++){
			System.out.println("For N="+ i+" Number of pairs ="+countPairs(i));
		}
	}
	static int countPairs(int n){
		int count = 0;
		for(int i=1; i<=Math.cbrt(n); i++){
			int diff = n - (i*i*i);
			int cbrtDiff = (int) Math.cbrt(diff);
			if (cbrtDiff*cbrtDiff*cbrtDiff == diff){
				count++;
			}
		}
		return count;
	}
}
