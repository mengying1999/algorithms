package com.algorithms.array;

import java.util.HashSet;
import java.util.Set;


public class DuplicateNumberArray {
    /**
     * 剑指offer第三题：
     * 数组中重复的数字
     * 题目：
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *  
     *
     * 限制：
     *
     * 2 <= n <= 100000
     *
     */
    /**
     *  方法一：（自己写的，效率低）
     *  双层循环遍历，当前数下的前面是否存在相同的数字
     */
    public int findRepeatNumber1(int[] nums) {
        for(int i =0; i< nums.length; i++){
            for(int j = 0; j< i;j++){
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * 方法二：官方题解，采用交换的思想 ***
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        //设索引初始值为 i = 0
        int i = 0;
        //遍历整个数组 nums
        while(i < nums.length) {
            //索引 i 的值为 i,无需执行交换操作，查看下一位
            if(nums[i] == i) {
                i++;
                continue;
            }
            //索引 nums[i] 处的值也为 nums[i]，即找到一组相同值，返回 nums[i] 即可
            if(nums[nums[i]] == nums[i]) return nums[i];
            //执行交换操作，目的是为了使索引与值一一对应，即索引 0 的值为 0，索引 1 的值为 1
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        //如果遍历整个数组都没有找到相同的值，返回 -1
        return -1;
    }

    /**
     * 方法三：利用set的不可重复性 ***
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 剑指offer第四题：
     * 二维数组的查找
     * 题目：
     *     在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 示例 1：
     *
     * 输入：
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * 给定 target = 20，返回 false
     * 限制：
     *0 <= n <= 1000
     * 0 <= m <= 1000
     *
     */
    /**
     *  方法一：暴力
     *  直接遍历整个二维数组的每一个元素，判断目标值是否在二维数组中存在
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二：线性查找
     *
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
