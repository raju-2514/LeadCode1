package February;

public class PowFunction {

    public double myPow(double x,int n){
        double result=Math.pow(x,n);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new PowFunction().myPow(2,-3) );
    }
}
