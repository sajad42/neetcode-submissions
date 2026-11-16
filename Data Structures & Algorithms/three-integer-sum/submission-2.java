class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 1. Sort to group duplicates together
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate starting numbers
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 2. Fresh HashSet for each 'i' (prevents reusing elements)
            HashSet<Integer> seen = new HashSet<>();

            // 3. Start j at i + 1
            for (int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);

                if (seen.contains(target)) {
                    result.add(Arrays.asList(nums[i], target, nums[j]));
                    
                    // Skip duplicate 'j' values so we don't add the same triplet twice
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
                seen.add(nums[j]);
            }
        }
        return result;
    }
}
