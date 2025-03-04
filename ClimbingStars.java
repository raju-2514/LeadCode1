package March;

public class ClimbingStars {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }

    public static void main(String[] args) {
        ClimbingStars cs = new ClimbingStars();
        int n = 3;
        System.out.println("Ways to climb " + n + " steps: " + cs.climbStairs(n));
    }
}
