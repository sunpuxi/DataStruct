package src.Array;

/**
 * 给定宽度为1的柱子，能接多少雨水
 *
 */
public class 接雨水 {
    public int trap1(int[] height) {
        // 1、解法一：初始化前缀最大值和后缀最大值
        // 每一个水桶的能接到的雨水的数量就是,前缀和后缀中较小的一个值减去当前水桶的高度
        int[] pre = new int[height.length];
        int preMax = height[0];
        int[] suff = new int[height.length];
        int suffMax = height[height.length-1];
        for(int i=0;i<height.length;i++){
            pre[i] = Math.max(height[i],preMax);
            preMax = pre[i];
        }
        for(int i=height.length-1;i>=0;i--){
            suff[i] = Math.max(suffMax,height[i]);
            suffMax = suff[i];
        }
        int res = 0;
        for(int i=0;i<height.length;i++){
            res += Math.min(pre[i],suff[i]) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        //2、解法二
        // 相向双指针分别从两边开始计算
        int res = 0;
        int preMax = 0;
        int suffMax = 0;
        int left = 0;
        int right = height.length-1;
        // 需要取等号
        while(left <= right){
            preMax = Math.max(preMax,height[left]);
            suffMax = Math.max(suffMax,height[right]);
            if(preMax < suffMax){
                res += preMax - height[left];
                left++;
            }else{
                res += suffMax - height[right];
                right--;
            }
        }
        return res;
    }
}
