package February;

public class LengthofLastWord {

    public int lastWordLength(String s){
        s = s.trim(); // Remove trailing spaces
        int lastSpaceIndex = s.lastIndexOf(' ');
        return s.length() - lastSpaceIndex - 1;
    }
    public static void main(String[] args) {
        System.out.println(new LengthofLastWord().lastWordLength("i am raju biswas"));
    }
}
