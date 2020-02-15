package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public long calculate(int position) {
        if (position == 1 || position == 2)
            return position;

        long first = 1, second = 1;
        long result = 0;
        for (int x = 3; x <= position; x++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
