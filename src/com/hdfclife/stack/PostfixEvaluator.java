package com.hdfclife.stack;

public class PostfixEvaluator {

    public static int evaluate(
            String expression) {

        LinkedClaimStack stack =
                new LinkedClaimStack();

        String[] values =
                expression.split(" ");

        for (String value : values) {

            if (value.equals("+") ||
                    value.equals("-") ||
                    value.equals("*") ||
                    value.equals("/")) {

                int second = stack.pop();

                int first = stack.pop();

                if (value.equals("+")) {

                    stack.push(
                            first + second
                    );
                }

                if (value.equals("-")) {

                    stack.push(
                            first - second
                    );
                }

                if (value.equals("*")) {

                    stack.push(
                            first * second
                    );
                }

                if (value.equals("/")) {

                    stack.push(
                            first / second
                    );
                }

            } else {

                stack.push(
                        Integer.parseInt(value)
                );
            }
        }

        return stack.pop();
    }
}