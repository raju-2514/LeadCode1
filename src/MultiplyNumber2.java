package February;

public class MultiplyNumber2 {
    public static String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) return "0";

    int m = num1.length(), n = num2.length();
    int[] result = new int[m + n];

    // Perform multiplication digit by digit
        for (int i = m - 1; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            int sum = mul + result[i + j + 1];

            result[i + j + 1] = sum % 10;
            result[i + j] += sum / 10;
        }
    }

    // Convert result array to string
    StringBuilder sb = new StringBuilder();
        for (int num : result) {
        if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
            sb.append(num);
        }
    }

        return sb.toString();
}

public static void main(String[] args) {
    String num1 = "498828660196";
    String num2 = "840477629533";
    System.out.println(multiply(num1, num2)); // Expected: "419254329864656431168468"
}

}
