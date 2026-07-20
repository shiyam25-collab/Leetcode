class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to absolute values using long to avoid overflow
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Perform exponential subtraction using bit shifts
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;

            // Keep shifting left (doubling) until tempDivisor exceeds absDividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Deduct the largest chunk found from the dividend
            absDividend -= tempDivisor;
            // Add the corresponding multiple to the quotient
            quotient += multiple;
        }

        // Apply the sign to the final quotient
        return isNegative ? -quotient : quotient;
    }
}
