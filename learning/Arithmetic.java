package learning;

public class Arithmetic {
    public static void main(String[] args) {
        int x = 21, y = 28;
        // System.out.println(add(x, y));
        // System.out.println(findBit(5, 1));
        // System.out.println(negative(5));
        // System.out.println(subtract(8, 5));
        System.out.println(numberOfDigitsByLog(1234));
        
        // TODO: find TC
        // TODO: write all important points of bit wise operator.
        // TODO: multiplication and division.
    }

    public static int add(int x, int y) { // O(n), O(1) where n is number of bit digits in max of x,y. // O(log(max(x,y))), O(1)
        int carry = 0; // O(1), O(1)
        while(y != 0) { // O(n), O(1)
            carry = (x & y) << 1; // O(1), O(1)
            x = x ^ y; // O(1), O(1)
            y = carry; // O(1), O(1)
        }
        return x; // O(1), O(1)
    }

    public static int findBit(int x, int pos) { // O(1), O(1)
        int onePos = 1 << pos; // O(1) , O(1)
        return (onePos & x) == 0 ? 0 : 1; // O(1), O(1)
    }

    public static int negative(int x) {
        return add(~x, 1); // O(log x), O(1)
    }

    public static int subtract(int x, int y) { // O(log(max(x,y))), O(1)
        return add(x, negative(y)); 
    }

    public static int multiply(int x, int y) { 
        // TODO: handle integer max case.
        int product = 0; // O(1), O(1)
        while(y-- != 0) { // O(log(y)), O(1)
           product = product + x; // O(log y), O(1)
        }
        return product; // O(1), O(1)
    }

    public static int numberOfDigits(int x) { // O(log x), O(1) where x is the number itself.
        int length = 0; // O(1), O(1)
        while(x != 0) { // O(x), O(1)
            x = x / 10; // O(1), O(1)
            length++; // O)(1), O(1)
        }
        return length; // O(1), O(1)
    }

    public static int numberOfDigitsByLog(int x) {
        return (int) (Math.log10(x) + 1);
    }
    
}
