/*
Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same 
relative order.

Only following standard operations are allowed on queue.

    enqueue(x) : Add an item x to rear of queue
    dequeue() : Remove an item from front of queue
    size() : Returns number of elements in queue.
    front() : Finds front item.

Input:
First line consists of T test cases. First line of every test case consists of 2 integers, N and K, denoting number of elements and number of elements to 
be reversed respectively. Second line of every test case consists of elements of array.

Output:
For each testcase, in a new line, print the modified queue.

Your Task:
Since this is a function problem, you don't need to take inputs. Just complete the provided function modifyQueue that takes queue and k as parameters and 
returns a modified queue. The printing is done automatically by the driver code.

Expected TIme Complexity : O(n)
Expected Auxilliary Space : O(n)

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= K <= N

Example:
Input:
2
5 3
1 2 3 4 5
4 4
4 3 2 1
Output:
3 2 1 4 5
1 2 3 4

Explanation:
Testcase 1: After reversing the given input from the 3rd position the resultant output will be 3 2 1 4 5.
Testcase 2: After reversing the given input from the 4th position the resultant output will be 1 2 3 4.

********************************************************************Solution*******************************************************************************/

import java.util.*;

class ModifyQueue{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            Queue<Integer> q=new LinkedList<>();
            while(n-->0){
                q.add((int)sc.nextInt());
            }
            GfG g=new GfG();
            Queue<Integer> ans=g.modifyQueue(q,k);
            while(!ans.isEmpty()){
                int a=ans.peek();
                ans.poll();
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}


class GfG
{
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
        Stack<Integer> s = new Stack<Integer>();
        int m = k;
        
        if(m == 0) //no need to reverse if k == 0
            return q;
        
        //1st, pushing 'k' number of items from queue to a stack to get those values in reverse order
        while(m-- > 0)
            s.push(q.poll());
        
        //now, adding those 'k' values from stack to the end of queue as we get them in reverse order now
        while(!s.isEmpty())
            q.add(s.pop());
        
        //At last, removing (q.size() - k) items from queue and adding those items to the end of queue to get the queue in required order where 1st 'k' number values are reversed
        int j = q.size() - k;
        
        for(int i = 0; i < j; i++) 
            q.add(q.poll());
        
        return q;    
    }
}









