public class SeqQueue<E> implements Queue<E> {
    protected E array[];
    protected int end, first, longActual;
    protected static final int CAPACITY = 200;

    public SeqQueue(){
        array = (E[]) new Object[CAPACITY];
        longActual = 0;
        first = 0;
        end = -1;
    }
    @Override
    public void add(E item) {
        if (longActual == array.length)
            duplicateArray();
        end = increment(end);
        array[end] = item;
        longActual++;
    }

    @Override
    public E poll() {
        E theFirst = array[first];
        first = increment(first);
        longActual--;
        return theFirst;
    }

    @Override
    public E peek() {
        return array[first];
    }

    @Override
    public boolean isEmpty() {
        return (longActual==0);
    }
    public int increment(int index){
        if(++index == array.length)
            index = 0;
        return index;
    }

    private void duplicateArray(){
        E newArray[] = (E[]) new Object[array.length*2];
        for (int i =0; i<longActual; i++, first=increment(first))
            newArray[i] = array[first];
        array = newArray;
        first = 0;
        end = longActual-1;
    }

    public String toString(){
        String res = "";
        int aux = first;
        for (int i = 0; i < longActual; i++, aux=increment(aux))
            res += array[aux] + " ";
        return res;
    }
}
