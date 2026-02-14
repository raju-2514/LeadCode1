package January;

import java.util.Scanner;

public class poweroftwo {
    public static boolean CalculatePowerOfTwo(int n){
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;

    }

    public static void main(String[] args) {

        System.out.println("Enter the value of n: ");
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();

        System.out.println(CalculatePowerOfTwo(a));

    }
}
