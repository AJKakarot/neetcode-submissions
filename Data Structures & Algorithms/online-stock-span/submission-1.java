

class StockSpanner {

    // Stack stores [price, span]
    Stack<int[]> stack;

    // Constructor
    public StockSpanner() {

        System.out.println("Constructor Called");

        stack = new Stack<>();
    }

    // Returns span of current stock price
    public int next(int price) {

        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {

            span += stack.pop()[1];

        }

        stack.push(new int[] { price, span });

        return span;
    }
}

// public class Main {

//     public static void main(String[] args) {

//         // Object Creation
//         StockSpanner sp = new StockSpanner();

//         System.out.println(sp.next(100));
//         System.out.println(sp.next(80));
//         System.out.println(sp.next(60));
//         System.out.println(sp.next(70));
//         System.out.println(sp.next(60));
//         System.out.println(sp.next(75));
//         System.out.println(sp.next(85));
//     }
// }