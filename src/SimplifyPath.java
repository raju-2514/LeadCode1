package March;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.equals(".") && !component.isEmpty()) {
                stack.push(component);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/")); // Output: "/home"
        System.out.println(simplifyPath("/home//foo/")); // Output: "/home/foo"
        System.out.println(simplifyPath("/home/user/Documents/../Pictures")); // Output: "/home/user/Pictures"
        System.out.println(simplifyPath("/../")); // Output: "/"
        System.out.println(simplifyPath("/.../a/../b/c/../d/./")); // Output: "/.../b/d"
    }
}
