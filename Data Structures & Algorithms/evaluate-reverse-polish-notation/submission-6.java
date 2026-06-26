class Solution {
    public static int evalRPN(String[] tokens) {
    int[] stack = new int[tokens.length]; // Dùng mảng thay cho Stack object
    int top = 0;
    
    for (String token : tokens) {
        if (token.equals("+")) {
            stack[top - 2] = stack[top - 2] + stack[top - 1];
            top--;
        } else if (token.equals("-")) {
            stack[top - 2] = stack[top - 2] - stack[top - 1];
            top--;
        } else if (token.equals("*")) {
            stack[top - 2] = stack[top - 2] * stack[top - 1];
            top--;
        } else if (token.equals("/")) {
            stack[top - 2] = stack[top - 2] / stack[top - 1];
            top--;
        } else {
            stack[top] = Integer.parseInt(token);
            top++;
        }
    }
    return stack[0];
}
}
