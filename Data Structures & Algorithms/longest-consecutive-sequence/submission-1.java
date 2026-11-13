class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Pre-size to prevent costly internal resizing/rehashing
        HashSet<Integer> hash = new HashSet<>(nums.length * 4 / 3 + 1);
        for (int num : nums) {
            hash.add(num);
        }

        int result = 1;
        int halfSize = hash.size() / 2;

        // Iterate over 'hash' (unique elements) instead of 'nums'
        for (int num : hash) {
            if (hash.contains(num - 1)) continue;

            int temp = num + 1;
            while (hash.contains(temp)) {
                temp++;
            }

            // Calculate length directly without incrementing a separate 'count' variable
            result = Math.max(result, temp - num);

            // No other sequence can beat a streak longer than half the unique elements
            if (result > halfSize) break;
        }

        return result;
    }

}
