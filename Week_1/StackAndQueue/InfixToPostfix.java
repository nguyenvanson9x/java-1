public class InfixToPostfix {
    
    // độ ưu tiên của các toán tử
    public int priority(char c) {
        if (c == '+' || c == '-')
            return 1;
        else if (c == '*' || c == '/')
            return 2;
        else
            return 0;
    }
    // kiểm tra toán tử
    public boolean isOperator(char c) {
        char operator[] = {'+', '-', '*', '/', '(', ')'};
        int i, n = operator.length;
        for (i = 0; i < n; i++)
            if (operator[i] == c)
                return true;
        return false;
    }
    
    //xử lý chuỗi
    public String[] processString(String sMath) {
        int i;
        String s1 = "", elementMath[] = null;
        InfixToPostfix IFP = new InfixToPostfix();
        sMath = sMath.trim(); // xóa space đầu, cuối
        sMath = sMath.replaceAll("\\s+", " "); // thay nhiều space bằng 1 space
        
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
    
    //chuyển từ trung tố sang hậu tố
    public String[] postfix(String[] elementMath) {
        int i , n = elementMath.length;
        String out = "";
        LinkedListStack<String> S = new LinkedListStack<>();
        
        for (i = 0; i < n; i++) {
            String element = elementMath[i];
            char c = element.charAt(0);
            
            if (!isOperator(c))
                out = out + " " + element;
            else {
                if (c == '(')
                    S.push(element);
                else if (c == ')') {
                    char c1;
                    do {
                        c1 = S.peek().charAt(0);
                        if (c1 != '(')
                            out = out + " " + S.peek();
                        S.pop();
                    } while (c1 != '(');
                }
                else {
                    while (!S.isEmpty() && priority(S.peek().charAt(0)) >= priority(c)) {
                        out = out + " " + S.peek();
                        S.pop();
                    }
                    S.push(element);
                }
            }
        }
        while (!S.isEmpty()) {
            out = out + " " + S.peek();
            S.pop();
        }
        return out.split(" ");
    }
    
    //tính giá trị biểu thức
    public String cal(String[] elementMath) {
        int i, n = elementMath.length;
        LinkedListStack<String> S = new LinkedListStack<>();
        
        for (i = 1; i < n; i++) {
            String element = elementMath[i];
            char c = element.charAt(0);
            
            if (!isOperator(c))
                S.push(element);
            else {
                double num1, num2, result = 0;
                num1 = Double.parseDouble(S.pop());
                num2 = Double.parseDouble(S.pop());
                switch (c) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        break;
                }
                S.push(Double.toString(result));
            }
        }
        return S.pop();
    }
}