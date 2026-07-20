package July;

import java.util.Scanner;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];

            currentTank += gas[i] - cost[i];

            // Cannot reach the next station
            if (currentTank < 0) {
                start = i + 1;
                currentTank = 0;
            }
        }

        return (totalGas >= totalCost) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of gas stations
        int n = sc.nextInt();

        int[] gas = new int[n];
        int[] cost = new int[n];

        // Input gas array
        for (int i = 0; i < n; i++) {
            gas[i] = sc.nextInt();
        }

        // Input cost array
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);

        sc.close();

    }
}