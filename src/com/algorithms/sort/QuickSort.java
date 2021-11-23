package com.algorithms.sort;

import java.util.Random;

public class QuickSort {

    public void randomizedQuicksort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = randomizedPartition(nums, left, right);
            randomizedQuicksort(nums, left, pivot - 1);
            randomizedQuicksort(nums, pivot + 1, right);
        }
    }

    public void sort(int[] nums, int left, int right){
        if(left < right){
            int pivot = partition(nums, left, right);
            sort(nums, left, pivot - 1);
            sort(nums, pivot + 1, right);
        }
    }

    public int topK(int[] nums, int left, int right, int k){
        if(left <= right){
            int pivot = randomizedPartition(nums, left, right);
            if(pivot + 1 == k){
                return nums[pivot];
            }else if(pivot + 1 < k){
                return topK(nums, pivot + 1, right, k);
            }else{
                return topK(nums, left, pivot - 1, k);
            }
        }
        return -1;
    }

    public int randomizedPartition(int[] nums, int left, int right){
        int i = new Random().nextInt(right - left + 1) + left;
        swap(nums, right, i);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int j = left - 1;
        for(int i = left; i <= right; i++){
            if(nums[i] <= pivot){
                j++;
                swap(nums, i, j);
            }
        }
        return j;
    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}
