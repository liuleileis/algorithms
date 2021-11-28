package com.algorithms.heap;

public class MaxHeap {

    int[] heap;
    int len;

    public MaxHeap(int capacity){
        heap = new int[capacity];
        len = 0;
    }

    public void insert(int num){
        if(len < heap.length){
            heap[len++] = num;
            int now = len - 1;
            int root = (now - 1) / 2;
            while(root >= 0 && heap[root] < heap[now]){
                swap(heap, root, now);
                now = root;
                root = (now - 1) / 2;
            }
        }
    }

    public int maximum(){
        if(len > 0){
            return heap[0];
        }
        return -1;
    }

    public int extractMax(){
        if(len > 0){
            int max = heap[0];
            heap[0] = heap[--len];
            heapify(0);
            return max;
        }
        return -1;
    }

    public void heapify(int root){
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int maxIndex = root;
        if(left < len && heap[maxIndex] < heap[left]){
            maxIndex = left;
        }
        if(right < len && heap[maxIndex] < heap[right]){
            maxIndex = right;
        }
        if(maxIndex != root){
            swap(heap, root, maxIndex);
            heapify(maxIndex);
        }
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}