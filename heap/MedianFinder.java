/*Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
*/

class MedianFinder {

    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxQueue=new PriorityQueue(Collections.reverseOrder()); //Stores lower half
        minQueue=new PriorityQueue(); //Stores upper half
    }
    
    public void addNum(int num) {
        if(maxQueue.size()==0 && minQueue.size()==0) minQueue.offer(num);
        else if(num<=minQueue.peek()){
            if(maxQueue.size()>minQueue.size()){
                int maxTop=maxQueue.poll();
                maxQueue.offer(Math.min(num,maxTop));
                minQueue.offer(Math.max(num,maxTop));
            }
            else
            maxQueue.offer(num);
        }
        else{
            if(maxQueue.size()<minQueue.size()){
                int maxTop=minQueue.poll();
                maxQueue.offer(Math.min(num,maxTop));
                minQueue.offer(Math.max(num,maxTop));
            }
            else
            minQueue.offer(num);
        }
    }
    
    public double findMedian() {
        if(minQueue.size()==maxQueue.size())
            return (maxQueue.peek()+minQueue.peek())/2.0;
        else if(minQueue.size()>maxQueue.size()) return minQueue.peek().doubleValue();
        else return maxQueue.peek().doubleValue();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
