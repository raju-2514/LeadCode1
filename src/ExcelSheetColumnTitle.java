package August;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber){

        StringBuilder result=new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
           int reminder=columnNumber%26;
           char currentColumn=(char)('A'+reminder);
           result.insert(0,currentColumn);
            columnNumber /= 26;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));   // Output: A
        System.out.println(convertToTitle(28));  // Output: AB
        System.out.println(convertToTitle(701)); // Output: ZY
    }

}
