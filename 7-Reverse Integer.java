class Solution {
    public int reverse(int x) {
        int reversedNum = 0;
        
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            
            // Check for overflow before multiplying by 10
            // Integer.MAX_VALUE is 2147483647, Integer.MIN_VALUE is -2147483648
            if (reversedNum > Integer.MAX_VALUE / 10 || (reversedNum == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (reversedNum < Integer.MIN_VALUE / 10 || (reversedNum == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            
            reversedNum = reversedNum * 10 + pop;
        }
        
        return reversedNum;
    }
}
