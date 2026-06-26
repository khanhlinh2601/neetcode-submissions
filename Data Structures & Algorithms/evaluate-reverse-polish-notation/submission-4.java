class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            }
            if (token.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            }
            if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            if (token.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            }
            if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
        }
        if (stack.size() == 1) {
            return stack.pop();
        }
        return 0;
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
