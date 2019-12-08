package com.company;

import javax.xml.crypto.Data;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ProbingHashTable<K extends Comparable<K>, V> implements MapInterface<K,V>
{
    private int n;
    private int TABLE_SIZE;
    //private K[] keys;
    //private V[] values;
    private DataClass<K,V>[] table;





    public ProbingHashTable(int n)
    {
        TABLE_SIZE = n;
        n = 0;
        table = new DataClass[n];

    }

    @Override
    public V get(K k) {
        if (k == null) throw new NullPointerException("The parameterized Key was passed as null");

        for(int index = hash(k) % TABLE_SIZE; keys[index] != null; index = (index + 1) % TABLE_SIZE)
        {
            if(keys[index].equals(k))
            {
                return values[index];
            }
        }
        return null;
    }

    @Override
    public V put(K k, V v) {
        if (k == null)      throw new NullPointerException("The parameterized Key was passed as null");
        if (v == null)      throw new NullPointerException("The parameterized value was passed as null");
        if(n == TABLE_SIZE) throw new IllegalStateException("Table full");

        int index;
        for(index = hash(k) % TABLE_SIZE; keys[index] != null; index = (index + 1) % TABLE_SIZE)
        {
            if(keys[index].equals(k))
            {
                values[index] = v;
                return null;   //TODO: FIX THIS dont return null  ? old value
            }
        }
        keys[index] = k;
        values[index] = v;
        n++;
        // should implement assert with a check
        return null;
    }

    private int hash(K k)
    {
        Key key = new Key((String) k);
        return key.hashCode() & 0xf7777777; // the hex is used in a binary intersection where it
                                            // makes sure that the value of the hash is unsigned so it stays positive
    }

    @Override
    public V remove(K k) {

        if (k == null)      throw new NullPointerException("The parameterized Key was passed as null");
        if (get(k) == null) return null;

        V v;
        int index = hash(k) % TABLE_SIZE;

        while(!k.equals(keys[index]))
            index = (index + 1) % TABLE_SIZE;

        v = values[index];
        keys[index] = null;
        values[index] = null;

        index = (index + 1) % TABLE_SIZE;

        while (keys[index] != null)
        {
            V v_rehash = values[index];  //rehash to optimize next put / remove / get
            K k_rehash = keys[index];

            values[index] = null;
            keys[index] = null;
            n--;
            put(k_rehash, v_rehash);
            index = (index + 1) % TABLE_SIZE;
        }

        n--;
        return v;
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
        return new KeyIteratorObject<>();
    }

    @Override
    public Iterator values() {
        return new ValueIteratorObject<>();
    }


    private class KeyIteratorObject<T> implements Iterator<T>
    {
        T[] ks;
        int i;

        public KeyIteratorObject()
        {
            //ks = (T[]) keys;
            i = 0;

        }

        @Override
        public boolean hasNext() {
            return i < keys.length;
        }

        @Override
        public T next() {
            if(!hasNext())
            {
                throw new NullPointerException("No more values");
            }
            return  ks[i++];
        }
    }

    public Set<K> keySet() {

        return null;
    }

    private class ValueIteratorObject<T> implements Iterator<T>
    {
        Iterator<K> iter;


        public ValueIteratorObject()
        {
            iter = keys();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public T next() {
            return (T) get(iter.next());
        }
    }




}
