public class Stack_As_Array<E> implements Stack<E> {
    private E[] stack;
    private int top = 0;
    
    public Stack_As_Array(int cap) {
        stack = (E[]) new Object[cap];
    }
    
    public void push(E element) {
        stack[top] = element;
        top++;
    }
    
    public E pop() {
        top--;
        return stack[top];
    }
    
    public boolean isEmpty() {
        return top == 0;        
    }
    
    public void print() {
        int i;
        for (i = 0; i < top; i++)
            System.out.print(stack[i] + " ");
    }
}