public class MaximizeSum {

	public int maximizeSum(int [] arr,int sum) {
		int start = 0, current_sum = arr[0];
		int max_sum = Integer.MIN_VALUE;
		for(int i = 1;i<arr.length;i++) {
			if( current_sum >  max_sum) {
				max_sum = current_sum;
			}
			while(current_sum+arr[i] > sum  && start<i) {
				current_sum-=arr[start];
				start++;
			}
			current_sum+=arr[i];
		}
		if( current_sum >  max_sum) {
			max_sum = current_sum;
		}
		return max_sum;
		
	}
	
	public static void main(String[] args) {
		MaximizeSum maximizeSum = new MaximizeSum();
		System.out.println(maximizeSum.maximizeSum(new int[] {9,8,10,4},25));
	}
}
