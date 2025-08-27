package August;

public class CountPrimeNumber {
    public static int countPrimes(int n) {
        if (n <= 2) return 0; // No primes less than 2

        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10)); // Output: 4 (2, 3, 5, 7)
        System.out.println(countPrimes(0));  // Output: 0
        System.out.println(countPrimes(1));  // Output: 0
    }
}
