package February;

public class Multiply_Two_String {
    public String multiplayString(String num1,String num2){

        Long a;
        if(num1==null || num1.isEmpty() || num2==null || num2.isEmpty()){
            return null;
        }
        else{
           a=  Long.parseLong(num1)*Long.parseLong(num2);
          return Long.toString(a);
        }

    }

    public static void main(String[] args) {

       Multiply_Two_String s=new Multiply_Two_String();
        System.out.println(s.multiplayString("12","0"));

    }
}
