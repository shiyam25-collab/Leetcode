import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26]; // one slot for each letter a-z
        
        // Step 1: count letters in the first word
        for (char ch : words[0].toCharArray()) {
            count[ch - 'a']++;
        }
        
        // Step 2: for every other word, lower the count if needed
        for (int i = 1; i < words.length; i++) {
            int[] newCount = new int[26];
            for (char ch : words[i].toCharArray()) {
                newCount[ch - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (newCount[j] < count[j]) {
                    count[j] = newCount[j];
                }
            }
        }
        
        // Step 3: build the answer from final counts
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < count[i]; k++) {
                result.add("" + (char)('a' + i));
            }
        }
        
        return result;
    }
}
