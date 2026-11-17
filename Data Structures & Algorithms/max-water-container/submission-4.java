class Solution {
    // algo steps.
    // make two pointers left and right
    // in a loop while (left < right)
    // save in int 
    // currMax = (rigth - left) * (Math.min(heights[left], heights[right]));
    // then update result : result = Math.max(result, currMax);
    // return result
    public int maxArea(int[] heights) {
        int result =0;
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;

        while (left < right) {
            // Find the shorter bar and calculate width
            int currentHeight = Math.min(heights[left], heights[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;

            // Update the maximum area found so far
            maxWater = Math.max(maxWater, currentArea);

            // Move the pointer pointing to the shorter bar inward
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

}
