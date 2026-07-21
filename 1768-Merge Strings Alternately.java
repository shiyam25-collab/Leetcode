class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int n1 = word1.length(), n2 = word2.length();
        int i = 0, j = 0;
        
        while (i < n1 || j < n2) {
            if (i < n1) {
                result.append(word1.charAt(i));
                i++;
            }
            if (j < n2) {
                result.append(word2.charAt(j));
                j++;
            }
        }
        
        return result.toString();
    }
}
