package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public int calculate(int position) {
        if (position == 1 || position == 2)
            return position;

        int first = 1, second = 1;
        int result = 0;
        for (int x = 3; x <= position; x++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
