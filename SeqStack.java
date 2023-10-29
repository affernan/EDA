public class SeqStack<E> implements Stack<E> {
    protected E array[];
    protected int top;
    protected static final int CAPACITY = 200;

    public SeqStack(){
        array = (E[]) new Object[CAPACITY];
        top = -1;
    }
    @Override
    public void push(E item) {
        if (top + 1 == array.length)
            duplicateArray();
        top++;
        array[top] = item;
    }

    @Override
    public E pop() {
        E theLast = array[top];
        top--;
        return theLast;
    }

    @Override
    public E top() {
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return (top==-1);
    }

    private void duplicateArray(){
        E newArray[] = (E[]) new Object[array.length*2];
        for (int i =0; i<=top; i++)
            newArray[i] = array[i];
        array=newArray;
    }

    public String toString(){
        String res = "";
        for (int i=top; i>=0; i--)
            res += array[i] + "\n";
        return res;
    }
}
