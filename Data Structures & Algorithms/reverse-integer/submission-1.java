class Solution {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            // Last digit nikal rahe hain
            int digit = x % 10;

            /*
             * Integer ki maximum limit:
             * 2147483647
             *
             * MAX_VALUE / 10 = 214748364
             *
             * Agar rev > 214748364 hai,
             * to rev * 10 karte hi overflow ho jayega.
             */
            if (rev > Integer.MAX_VALUE / 10) {
                return 0;
            }

            /*
             * Agar rev exactly 214748364 hai,
             * to ab last digit check karni padegi.
             *
             * Maximum allowed number = 2147483647
             * Isliye digit maximum 7 ho sakta hai.
             *
             * digit = 7  -> 2147483647 ✅
             * digit = 8  -> 2147483648 ❌ overflow
             */
            if (rev == Integer.MAX_VALUE / 10 && digit > 7) {
                return 0;
            }

            /*
             * Integer ki minimum limit:
             * -2147483648
             *
             * Agar rev < -214748364 hai,
             * to rev * 10 karte hi minimum limit cross ho jayegi.
             */
            if (rev < Integer.MIN_VALUE / 10) {
                return 0;
            }

            /*
             * Agar rev exactly -214748364 hai,
             * to last digit minimum -8 ho sakti hai.
             *
             * digit = -8 -> -2147483648 ✅
             * digit = -9 -> -2147483649 ❌ overflow
             */
            if (rev == Integer.MIN_VALUE / 10 && digit < -8) {
                return 0;
            }

            // Number ko reverse kar rahe hain
            rev = rev * 10 + digit;

            // Last digit remove kar rahe hain
            x = x / 10;
        }

        return rev;
    }
}