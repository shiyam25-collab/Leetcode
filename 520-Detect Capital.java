class Solution {
    public boolean detectCapitalUse(String word) {
        int numUpper = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                numUpper++;
            }
        }
        
        // All lowercase, all uppercase, or only first letter uppercase
        return numUpper == 0 
            || numUpper == word.length() 
            || (numUpper == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
