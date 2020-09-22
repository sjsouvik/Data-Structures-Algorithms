/*
A binary heap is a Binary Tree with the following properties:
1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This 
property of Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at the root must be minimum among all keys present in Binary Heap. The same 
property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.

You are given an empty Binary Min Heap and some queries and your task is to implement the three methods insertKey,  deleteKey,  and extractMin on the 
Binary Min Heap and call them as per the query given below:
1) 1  x  (a query of this type means to insert an element in the min-heap with value x )
2) 2  x  (a query of this type means to remove an element at position x from the min-heap)
3) 3  (a query like this removes the min element from the min-heap and prints it ).

Example 1:

Input:
Q = 7
Queries:
insertKey(4)
insertKey(2)
extractMin()
insertKey(6)
deleteKey(0)
extractMin()
extractMin()
Output: 2 6 - 1
Explanation: In the first test case for
query 
insertKey(4) the heap will have  {4}  
insertKey(2) the heap will be {2 4}
extractMin() removes min element from 
             heap ie 2 and prints it
             now heap is {4} 
insertKey(6) inserts 6 to heap now heap
             is {4 6}
deleteKey(0) delete element at position 0
             of the heap,now heap is {6}
extractMin() remove min element from heap
             ie 6 and prints it  now the
             heap is empty
extractMin() since the heap is empty thus
             no min element exist so -1
             is printed.

Example 2:

Input:
Q = 5
Queries:
insertKey(8)
insertKey(9)
deleteKey(1)
extractMin()
extractMin()
Output: 8 -1

Your Task:
You are required to complete the 3 methods insertKey() which take one argument the value to be inserted, deleteKey() which takes one argument the position 
from where the element is to be deleted and extractMin() which returns the minimum element in the heap(-1 if the heap is empty)

Expected Time Complexity: O(Q*Log(size of Heap) ).
Expected Auxiliary Space: O(1).

Constraints:
1 <= Q <= 104
1 <= x <= 104

*********************************************************************Solution****************************************************************************/

import java.util.*;
import java.io.*;

class GfG 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
	{
            int a = sc.nextInt();
            MinHeap h = new MinHeap(a);
            for (int i = 0; i < a; i++) 
	    {
                int c = sc.nextInt();
                int n;
                if (c == 1) 
		{
                    n = sc.nextInt();
                    h.insertKey(n);
                }
                if (c == 2) 
		{
                    n = sc.nextInt();
                    h.deleteKey(n);
                }
                if (c == 3) 
		{
                    System.out.print(h.extractMin() + " ");
                }
            }
            System.out.println();
        }
    }
}


class MinHeap 
{
    int[] harr;
    int capacity, heap_size;
    
    MinHeap(int cap) 
    {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    //Time complexity: O(log(Size of the heap)) since we're doing heapify after extracting min
    //the idea is to swap peek element with the last element in the heap, reduce the size of the heap and heapify the heap for root.
    int extractMin() 
    {
        if(heap_size == 0)
            return -1;
        
        else if(heap_size == 1)
        {
            heap_size--;
            return harr[heap_size];
        }
        
        int temp = harr[0];
        harr[0] = harr[heap_size - 1];
        harr[heap_size - 1] = temp;
        
        heap_size--;
        MinHeapify(0);
        return harr[heap_size];
    }

    //time complexity : O(height of heap) = O(log(size of heap)) since it might require to swap newly inserted element and parent element which will happen from leaf to root in worst case
    void insertKey(int k) 
    {
        if(heap_size == capacity)
            return;
            
        heap_size++;
        harr[heap_size - 1] = k;
        
        //this part of the code checks whether the inserted element is less than its parent or not. If it's less than its parent than we need to swap the nodes till the child node is greater than its parent or we reach at root of the heap
        int i = heap_size - 1;
        while(i != 0 && harr[parent(i)] > harr[i])
        {
            int temp = harr[parent(i)];
            harr[parent(i)] = harr[i];
            harr[i] = temp;
            
            i = parent(i);
        }
    }

    //Time complexity : O(log(Size of heap)) since both decreaseKey() and extractMin() are O(log(Size of heap)) operation
    //the idea is to update the value at index 'i' with (-infinity) which will eventually reach at root of the heap to maintain the min heap property. Then, we can extract min from the heap to delete (-infinity) - that's how we delete any element at index 'i' from heap
    void deleteKey(int i) 
    {
        if(i >= heap_size || i < 0)
            return;
            
        decreaseKey(i, Integer.MIN_VALUE);  //O(log(Size of heap)) operation
        extractMin(); //O(log(Size of heap)) operation
    }

    // Decrease key operation, helps in deleting the element
    //this operation updates the value in the given index with the given new value
    void decreaseKey(int i, int new_val) 
    {
        harr[i] = new_val;
        
        //this part of the code does the same operation that we perform after inserting a new element into the heap
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    //Time complexity is proportional to O(height of heap) since we'll be calling the same function for its child in worst case, so time complexity: O(height of heap) = O(log(size of heap)), space complexity : O(height of heap). However, we can write iteraive function to do the same to reduce the space complexity to O(1)
    //the idea is to find the smallest element among parent and its left and right child and if the smallest element is not equal to the parent then swap the parent node with smallest element and recursively follow the same steps for the smallest node.
    void MinHeapify(int i) 
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        
        if (smallest != i) 
        {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            
            MinHeapify(smallest);
        }
    }
}






