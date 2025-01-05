package January;

public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        int temp=0;
        int rev=x;
        if(x<0){
            return false;
        }

        while(x!=0){
            int lastDigit=x%10;
            temp =temp*10+lastDigit;
            x=x/10;

        }

        return rev==temp;
    }

    public static void main(String[] args) {
        int x=121;
        Palindrome_Number p=new Palindrome_Number();
        System.out.println(p.isPalindrome(x));

    }
}
