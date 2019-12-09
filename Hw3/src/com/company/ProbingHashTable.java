package com.company;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings("All")
public class ProbingHashTable<K extends Comparable<K>, V> implements MapInterface<K,V>
{
    private int n;
    private int TABLE_SIZE;
    private Object[] table;


    public ProbingHashTable(int size)
    {
        TABLE_SIZE = size;
        n = 0;
        table = new Object[size];

    }

    @Override
    public V get(K k) {
        if (k == null) throw new NullPointerException("The parameterized Key was passed as null");

        for(int index = hash(k) % TABLE_SIZE; table[index] != null; index = (index + 1) % TABLE_SIZE)
        {
            if(((DataClass<K, V>)table[index]).getKey().equals(k))
            {
                return ((DataClass<K, V>)table[index]).getValue();
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
        for(index = hash(k) % TABLE_SIZE; table[index] != null; index = (index + 1) % TABLE_SIZE)
        {
            if(((DataClass<K, V>)table[index]).getKey().equals(k))
            {
                ((DataClass<K, V>)table[index]).setValue(v);
                return null;   //TODO: FIX THIS dont return null  ? old value
            }
        }
        table[index] = new DataClass<>(k,v);
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

        while(!k.equals(((DataClass<K, V>)table[index]).getKey()))
            index = (index + 1) % TABLE_SIZE;

        v = ((DataClass<K, V>)table[index]).getValue();
        table[index] = null;


        index = (index + 1) % TABLE_SIZE;

        while (table[index] != null)
        {
            DataClass<K,V> data_rehash = ((DataClass<K, V>)table[index]);  //rehash to optimize next put / remove / get

            table[index] = null;
            n--;
            put(data_rehash.getKey(), data_rehash.getValue());
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

    private Set<K> keySet()
    {
        if(n == 0) return null;

        Set<K> set = new LinkedHashSet<>();

        for(int i = 0; i < table.length; i++)
        {
            if(table[i] != null)
            {
                set.add(((DataClass<K, V>)table[i]).getKey());
            }
        }
        return set;
    }

    private class KeyIteratorObject<T> implements Iterator<T>
    {
        T[] ks;
        int i;

        public KeyIteratorObject()
        {
            ks =  (T[]) keySet().toArray();
            Arrays.sort(ks);
            i = 0;

        }

        @Override
        public boolean hasNext() {
            return i < ks.length;
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

    public static void main(String[] args)
    {
        int table_size = 50;

        ProbingHashTable cht = new ProbingHashTable(table_size);

        cht.put("abc", new String("Jeremy"));
        cht.put("111", new String("SOME"));
        cht.put("123", new String("SUM"));

        cht.remove("abc");



        for (Iterator itr = cht.values(); itr.hasNext(); ) {
            Object i = itr.next();
            System.out.println(i.toString());
        }

        //cht.remove("abc");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(cht.get("111"));
        System.out.println(cht.get("123"));

    }




}
