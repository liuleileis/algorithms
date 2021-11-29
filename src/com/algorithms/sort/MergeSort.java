package com.algorithms.sort;

public class MergeSort {

    public void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = left + ((right - left) >> 1);
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            // merge
            int[] temp = new int[nums.length];
            int index = left;
            int i = left, j = mid + 1;
            while(i <= mid && j <= right){
                if(nums[i] <= nums[j]){
                    temp[index++] = nums[i++];
                }else{
                    temp[index++] = nums[j++];
                }
            }
            while(i <= mid){
                temp[index++] = nums[i++];
            }
            while(j <= right){
                temp[index++] = nums[j++];
            }
            for(int k = left; k <= right; k++){
                nums[k] = temp[k];
            }
        }
    }

}
