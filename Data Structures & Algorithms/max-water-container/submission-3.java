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
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            result = Math.max(result, (right - left) * minHeight);

            // Skip any bars that aren't taller than the current bottleneck
            while (left < right && heights[left] <= minHeight) left++;
            while (left < right && heights[right] <= minHeight) right--;
        }
        return result;
    }

}
