package study.ps;

import java.util.Stack;

public class PS42883_ANSWER {

    public static void main(String[] args) {
//        String number = "1924";
//        int k = 2;
//        String number = "1231234";
//        int k = 3;
        String number = "4177252841";
        int k = 4;

        String result = Solution(number, k);
        System.out.println(result);
   }

    private static String Solution(String number, int k) {

        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
