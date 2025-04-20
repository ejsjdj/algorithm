import java.util.regex.Pattern;

class Solution {
    public long solution(String expression) {
        String[][] priorities = {
            {"+", "-", "*"}, {"+", "*", "-"},
            {"-", "+", "*"}, {"-", "*", "+"},
            {"*", "+", "-"}, {"*", "-", "+"}
        };

        long max = 0;
        for (String[] ops : priorities) {
            long result = parseExpression(expression, ops, 0);
            max = Math.max(max, Math.abs(result));
        }
        return max;
    }

    private long parseExpression(String expr, String[] ops, int depth) {
        if (depth == 3) return Long.parseLong(expr);

        String[] tokens = expr.split(regexFor(ops[depth]));
        long result = parseExpression(tokens[0], ops, depth+1);

        for (int i = 1; i < tokens.length; i++) {
            long next = parseExpression(tokens[i], ops, depth+1);
            switch(ops[depth]) {
                case "+": result += next; break;
                case "-": result -= next; break;
                case "*": result *= next; break;
            }
        }
        return result;
    }

    private String regexFor(String op) {
        return Pattern.quote(op); 
    }
}