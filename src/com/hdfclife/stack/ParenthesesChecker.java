package com.hdfclife.stack;

public class ParenthesesChecker {

    public static boolean isBalanced(
            String text) {

        ArrayClaimStack stack =
                new ArrayClaimStack();

        for (int i = 0;
             i < text.length();
             i++) {

            char ch = text.charAt(i);

            if (ch == '(' ||
                    ch == '[' ||
                    ch == '{') {

                stack.push(ch);

            } else if (ch == ')' ||
                    ch == ']' ||
                    ch == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                char open =
                        (char) stack.pop();

                if (ch == ')' &&
                        open != '(') {

                    return false;
                }

                if (ch == ']' &&
                        open != '[') {

                    return false;
                }

                if (ch == '}' &&
                        open != '{') {

                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}