class Solution {
    // algo steps.
    // make two pointers left and right
    // in a loop while (left < right)
    // save in int 
    // currMax = (rigth - left) * (Math.min(heights[left], heights[right]));
    // then update result : result = Math.max(result, currMax);
    // return result
    public int maxArea(int[] heights) {
        int result = 0;
        int left =0;
        int right = heights.length-1;
        while (left<right) {
            int currMax = (right - left) * (Math.min(heights[left], heights[right]));
            result = Math.max(result, currMax);
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return result;
    }
}
