class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Check every pair of numbers
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // If this pair adds up to the target
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        // If no pair is found (won't happen based on constraints)
        return new int[] {};
    }
}
