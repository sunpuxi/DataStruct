package src.Array;

/**
 * 求出盛水最多面积
 * sum = Math.max(nums[i],nums[j]) * (j-i)
 * 题目的数组元素顺序不能改变，因此不能排序
 */
public class 盛水最多的容器 {
    public int solution(int[] height){
        int res = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
            int area = (right - left) * Math.min(height[left],height[right]);
            res = Math.max(area,res);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }
}
