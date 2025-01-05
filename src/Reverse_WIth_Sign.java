package December;

public class Reverse_WIth_Sign {
    public static int reverse(int x) {
        long finalNumber=0;

        while(x!=0){
            int lastDig=x%10;
            finalNumber +=lastDig;
            finalNumber=finalNumber*10;
            x=x/10;
        }
        finalNumber =finalNumber/10;
        if(finalNumber>Integer.MAX_VALUE || finalNumber<Integer.MIN_VALUE){
            return 0;
        }

        if(x<0){
            return (int)(-1*finalNumber);
        }
        return (int)finalNumber;

    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
