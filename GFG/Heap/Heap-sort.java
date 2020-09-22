/*
Given an array of size N. The task is to sort the array elements by completing functions heapify() and buildHeap() which are used to implement Heap Sort.

Example 1:

Input:
N = 5
arr[] = {4,1,3,9,7}
Output:1 3 4 7 9
Explanation:After sorting elements
using heap sort, elements will be
in order as 1,3,4,7,9.

Example 2:

Input:
N = 10
arr[] = {10,9,8,7,6,5,4,3,2,1}
Output:1 2 3 4 5 6 7 8 9 10
Explanation:After sorting elements
using heap sort, elements will be
in order as 1, 2,3,4,5,6,7,8,9,10.

Your Task :
Complete the functions heapify() and buildheap().

Expected Time Complexity: O(N * Log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 106
1 <= arr[i] <= 106

********************************************************************Solution*******************************************************************************/

import java.util.*;

class Heap_Sort
{
    void printArray(int arr[],int n)
    {        
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();

        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
            hs.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }

    public void heapSort(int arr[], int n)
    {
        GfG g = new GfG();
        g.buildHeap(arr, n);

        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            g.heapify(arr, i, 0);
        }
    }
}

class GfG
{
    //this is to build max heap from the array elements. Time complexity: O(n) --- a bit calculation is there, to understand how? watch GFG video
    //the idea is to heapify the array elements starting from the parent node or element of last item in the array. Index of parent of last item in the array = ((n - 1) - 1) / 2 = (n - 2) / 2 since, parent of item at index 'i', parent(i) = (i - 1) / 2
    void buildHeap(int arr[], int n)
    {
        for(int i = (n - 2) / 2; i >= 0; i--)
            heapify(arr, n, i);
    }
 
    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap. It'll maintain the max heap property
    void heapify(int arr[], int n, int i)
    {
        int l = (2 * i) + 1;
        int r = (2 * i) + 2;
        int greatest = i;
        
        if(l < n && arr[l] > arr[greatest])
            greatest = l;
        if(r < n && arr[r] > arr[greatest])
            greatest = r;
        
        if(greatest != i)
        {
            int temp = arr[greatest];
            arr[greatest] = arr[i];
            arr[i] = temp;
            
            heapify(arr, n, greatest);
        }
    }
 }
 
 





