/*
Problem:
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
*/
class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k<=0) return new int[0];
        int[] result=new int[nums.length-k+1];
        Deque<Integer> deque=new LinkedList();
        for(int i=0;i<nums.length;i++){
            if(!deque.isEmpty() && deque.peek()==i-k) deque.poll();
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]) deque.pollLast();
            deque.offer(i);
            if(i-k+1>=0)
            result[i-k+1]=nums[deque.peek()];
        }
        return result;
    }
}

class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k<=0) return new int[0];
        int l=nums.length;
        int[] leftSlidingMax=new int[l];
        leftSlidingMax[0]=nums[0];
        int[] rightSlidingMax=new int[l];
        rightSlidingMax[l-1]=nums[l-1];
        int[] result=new int[l-k+1];
        for(int i=1;i<l;i++){
            leftSlidingMax[i]=(i%k==0)?nums[i]:Math.max(nums[i],leftSlidingMax[i-1]);
            int j=l-i-1;
            rightSlidingMax[j]=(j%k==0)?nums[j]:Math.max(nums[j],rightSlidingMax[j+1]);
        }
        for(int i=0;i<=l-k;i++){
            result[i]=Math.max(rightSlidingMax[i],leftSlidingMax[i+k-1]);
        }
        return result;
    }
}
