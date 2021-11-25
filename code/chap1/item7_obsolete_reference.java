package code.chap1; 

import java.util.Arrays;
import java.util.EmptyStackException;

public class item7_obsolete_reference {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPABILITY = 16;

    public item7_obsolete_reference(){
        this.elements  = new Object[DEFAULT_INITIAL_CAPABILITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop(){
        if (size == 0){
            throw new EmptyStackException();
        }

        // here introduce the memory leak
        // because the underlying array still hold the obsolete object's reference
        //return elements[--size];
        Object retVal = elements[--size];
        elements[size] = null;
        return retVal;
    }

    private void ensureCapacity(){
        if (elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
};
