public class InfixToPostfix {
    public int priority(char c) {
        if (c == '+' || c == '-')
            return 1;
        else if (c == '*' || c == '/')
            return 2;
        else
            return 0;
    }
    
    public boolean isOperator(char c) {
        char operator[] = {'+', '-', '*', '/', '(', ')'};
        int i, n = operator.length;
        for (i = 0; i < n; i++)
            if (operator[i] == c)
                return true;
        return false;
    }
    
    public String[] processString(String sMath) {
        int i;
        String s1 = "", elementMath[] = null;
        InfixToPostfix IFP = new InfixToPostfix();
        sMath = sMath.trim(); // xóa space đầu, cuối
        sMath = sMath.replaceAll("\\s+", " "); // thay hai space bằng 1 space
        
        for (i = 0; i < sMath.length(); i++) { //các từ cách nhau 1 space
            char c = sMath.charAt(i);
            if (!IFP.isOperator(c))
                s1 = s1 + c;
            else
                s1 = s1 + " " + c + " ";
        }
        s1 = s1.trim();
        s1 = s1.replaceAll("\\s+", " ");
        elementMath = s1.split(" ");
        return elementMath;
    }
    
    public String[] postfix(String[] elementMath) {
        int i, n = elementMath.length;
        String s1 = "";
        LinkedListStack<String> S = new LinkedListStack<>();

        for (i = 0; i < n; i++) {
            char c = elementMath[i].charAt(0);
            if (!isOperator(c))
                s1 = s1 + " " + elementMath[i];
            else {
                if (c == '(')
                    S.push(elementMath[i]);
                else {
                    if (c == ')') {
                        char c1;
                        do {
                            c1 = S.peek().charAt(0);
                            if (c1 != '(')
                                s1 = s1 + " " + S.peek();
                            S.pop();
                        }
                        while (c1 != '(');
                    }
                    else {
                        while (!S.isEmpty() && priority(S.peek().charAt(0)) >= priority(c)) {
                            s1 = s1 + " " + S.peek();
                            S.pop();
                        }
                        S.push(elementMath[i]);
                    }
                }
            }
        }
        while (!S.isEmpty()) {
            s1 = s1 + " " + S.peek();
            S.pop();
        }
        return s1.split(" ");
    }
}