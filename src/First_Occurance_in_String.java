package January;

public class First_Occurance_in_String {

    public int firstOccuranceInString(String haystack, String needle) {

        if(needle==null || needle.isEmpty() ){
            return 0;
        }
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
            return i;
            }
        }


return -1;
    }
    public static void main(String[] args) {
        First_Occurance_in_String f = new First_Occurance_in_String();
        System.out.println(f.firstOccuranceInString("a", "a"));

    }
}
