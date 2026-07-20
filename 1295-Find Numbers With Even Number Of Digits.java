class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            // Capitalized 'String' and used camelCase 'valueOf'
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
