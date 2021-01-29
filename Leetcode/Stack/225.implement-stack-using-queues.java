/*
Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).

Implement the MyStack class:

    void push(int x) Pushes element x to the top of the stack.
    int pop() Removes the element on the top of the stack and returns it.
    int top() Returns the element on the top of the stack.
    boolean empty() Returns true if the stack is empty, false otherwise.

Notes:

    You must use only standard operations of a queue, which means only push to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue), as long as you use only a queue's standard operations.

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 
Constraints:

    1 <= x <= 9
    At most 100 calls will be made to push, pop, top, and empty.
    All the calls to pop and top are valid.

Follow-up: Can you implement the stack such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer. You can use more than two queues.

********************************************************************************************Solution**********************************************************************************************************************************************************/

class MyStack 
{
    //Pop efficient approach
    Queue<Integer> mainQueue;
    Queue<Integer> auxQueue;
    
    /** Initialize your data structure here. */
    public MyStack() 
    {
        mainQueue = new LinkedList<>();
        auxQueue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) 
    {
        while(!empty())
            auxQueue.add(mainQueue.remove());
        
        mainQueue.add(x);
        
        while(auxQueue.size() > 0)
            mainQueue.add(auxQueue.remove());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() 
    {
        if(empty())
            return -1;
        
        return mainQueue.remove();
    }
    
    /** Get the top element. */
    public int top() 
    {
        if(empty())
            return -1;
        
        return mainQueue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() 
    {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */