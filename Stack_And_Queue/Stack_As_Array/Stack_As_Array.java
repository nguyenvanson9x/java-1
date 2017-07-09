public class Stack_As_Array<E> implements Stack<E> {
    private E[] stack;
    private int top = 0;
    
    public Stack_As_Array() {
        stack = (E[]) new Object[2];
    }
    
    public void push(E element) {
        if (stack.length == top)
            resize(stack.length * 2);
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
        for (i = top - 1; i >= 0; i--)
            System.out.print(stack[i] + " ");
    }
    
    private void resize(int cap) {
        E[] tmp = (E[]) new Object[cap];
        System.arraycopy(stack, 0, tmp, 0, top);
        stack = tmp;
    }
}