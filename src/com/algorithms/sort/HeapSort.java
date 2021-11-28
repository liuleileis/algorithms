package com.algorithms.sort;

public class HeapSort {

    public void sort(int[] nums){
        buildMaxHeap(nums);
        for(int i = nums.length - 1; i > 0; i--){
            swap(nums, i, 0);
            heapify(nums, 0, i);
        }
    }

    public void buildMaxHeap(int[] nums){
        for(int i = nums.length / 2; i >= 0; i--){
            heapify(nums, i, nums.length);
        }
    }

    public void heapify(int[] nums, int root, int len){
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int maxIndex = root;
        if(left < len && nums[maxIndex] < nums[left]){
            maxIndex = left;
        }
        if(right < len && nums[maxIndex] < nums[right]){
            maxIndex = right;
        }
        if(maxIndex != root){
            swap(nums, root, maxIndex);
            heapify(nums, maxIndex, len);
        }
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}
