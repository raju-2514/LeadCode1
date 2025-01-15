package January;

import java.util.Stack;

public class Valid_Parentheses {

    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for(char c:s.toCharArray()){
          if(c=='(' || c=='{' || c=='['){
              stack.push(c);
          }
          else{
              if(stack.isEmpty()){
                  return false;
              }

              char top=stack.pop();
              if(c==')' && top!='('
                      ||
                      c=='}' && top!='{'
                      ||
                      c=='}' && top!='{'
                      ||
                      c==']' && top!='[' ) {
                  return false;
              }

          }


      }
      return stack.isEmpty();

    }


    public static void main(String[] args) {

        var s = new Valid_Parentheses();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
    }
}
