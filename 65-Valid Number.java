class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        int i = 0;

        // 1. Optional leading sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        boolean digitsSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        while (i < n) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digitsSeen = true;
                i++;
            } else if (c == '.') {
                // Only one dot allowed, and not after 'e'/'E'
                if (dotSeen || eSeen) return false;
                dotSeen = true;
                i++;
            } else if (c == 'e' || c == 'E') {
                // Must have seen digits before 'e', and only one 'e'
                if (eSeen || !digitsSeen) return false;
                eSeen = true;
                digitsSeen = false; // require digits after 'e' too
                i++;
                // Optional sign right after 'e'
                if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                    i++;
                }
            } else {
                return false; // invalid character
            }
        }

        return digitsSeen;
    }
}
