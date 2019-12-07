package com.company;

import java.util.Iterator;

public class ProbingHashTable<K, V> implements MapInterface<K,V>
{
    private int n;
    private int TABLE_SIZE;
    private K[] keys;
    private V[] values;

    public ProbingHashTable(int initialSize)
    {
        TABLE_SIZE = initialSize;
        n = 0;
        keys = (K[]) new Object[TABLE_SIZE];
        values = (V[]) new Object[TABLE_SIZE];

    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public V put(K k, V v) {
        if (k == null)      throw new NullPointerException("The parameterized Key was passed as null");
        if (v == null)      throw new NullPointerException("The parameterized value was passed as null");
        if(n == TABLE_SIZE) throw new IllegalStateException("Table full");

        int index;
        for(index = hash(k) % TABLE_SIZE ; keys[index] != null; index++)
        {
            if(keys[index].equals(k))
            {
                values[index] = v;
                return null;   //TODO: FIX THIS dont return null  ? old value
            }
        }
        return null;
    }

    private int hash(K k)
    {
        Key key = new Key((String) k);
        return key.hashCode() & 0xf7777777; // the hex is used in a binary intersection where it
                                            // makes sure that the value of the hash is unsigned so it stays positive
    }

    public void resize(int newM)
    {

    }
    @Override
    public Object remove(Object o) {
        return null;
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public boolean isEmpty() {
        return this.n == 0;
    }

    @Override
    public Iterator keys() {
        return null;
    }

    @Override
    public Iterator values() {
        return null;
    }
}
