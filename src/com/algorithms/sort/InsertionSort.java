package com.algorithms.sort;

public class InsertionSort {

    public void sort(int[] nums){
        for(int j = 1; j < nums.length; j++){
            int num = nums[j];
            int i = j - 1;
            while(i >= 0 && nums[i] > num){
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = num;
        }
    }

}
