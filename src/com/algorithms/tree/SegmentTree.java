package com.algorithms.tree;

/**
 * 线段树涉及 4 个操作
 * 建树 build
 * 点更新 update
 * 区间查询 query
 * 区间更新 updateRange
 */
public class SegmentTree {

    private Node[] node;
    private int[] nums;
    private int size;

    static final class Node{
        int val;
        int lazy;
        Node(){}
        Node(int val){
            this.val = val;
        }
    }

    public SegmentTree(int[] nums){
        this.size = nums.length;
        this.nums = nums.clone();
        this.node = new Node[size() << 2];
        build(0, 0, size() - 1);
    }

    public void build(int root, int left, int right){
        if(left == right){
            node[root] = new Node(nums[left]);
            return;
        }
        int mid = left + ((right - left) >> 1);
        build(root * 2 + 1, left, mid);
        build(root * 2 + 2, mid + 1, right);
        pushUp(root);
    }

    public void update(int index, int value, int root, int left, int right){
        if(left == right){
            node[root].val = value;
            nums[index] = value;
            return;
        }
        int mid = left + ((right - left) >> 1);
        if(index <= mid){
            update(index, value, root * 2 + 1, left, mid);
        }else{
            update(index, value, root * 2 + 2, mid + 1, right);
        }
        pushUp(root);
    }

    public int query(int queryLeft, int queryRight, int root, int left, int right){
        if(left == queryLeft && right == queryRight){
            return node[root].val;
        }
        int mid = left + ((right - left) >> 1);
        if(queryRight <= mid){
            return query(queryLeft, queryRight, root * 2 + 1, left, mid);
        }else if(queryLeft > mid){
            return query(queryLeft, queryRight, root * 2 + 2, mid + 1, right);
        }else{
            return query(queryLeft, mid, root * 2 + 1, left, mid) + query(mid + 1, queryRight, root * 2 + 2, mid + 1, right);
        }
    }

    // TODO 区间更新
    public void updateRange(){

    }

    public int size(){
        return this.size;
    }

    private void pushUp(int root){
        if(node[root] == null){
            node[root] = new Node();
        }
        node[root].val = node[root * 2 + 1].val + node[root * 2 + 2].val;
    }

    // TODO pushDown
    private void pushDown(int root){

    }

}
