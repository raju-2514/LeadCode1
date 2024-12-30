package December;

public class Reverse_Integer {
    public static int reverse(int x) {
     if (x>0)
     {
         return Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
     }
     else if(x==0)
     {
         return 0;
     }
     else
     {
         return -Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
     }

    }

    public static void main(String[] args) {
        int x = 123;
       System.out.println(new Reverse_Integer().reverse(x));
    }
}
