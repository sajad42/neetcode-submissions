class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int result = 1;
        HashSet<Integer> hash = new HashSet<>();
        for (int num : nums)
            hash.add(num);
        
        for (int num : nums) {
            if (hash.contains(num-1)) continue;
            int count = 1;
            int temp = num;
            while(hash.contains(temp+1)){
                count++;
                temp++;

            }
            result = Math.max(count, result);
        }
        return result;
    }
}
