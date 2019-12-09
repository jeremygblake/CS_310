package com.company;

import java.io.*;
import java.util.*;


@SuppressWarnings("All")
public class ChainingHashTable<K extends Comparable<K>, V> implements MapInterface<K, V>, Iterable<K>
{
    private LinkedList<DataClass<K,V>>[] table;
    private int TABLE_SIZE;
    private int size;




    public ChainingHashTable(int n) {
        this.TABLE_SIZE = n;
        table = (LinkedList<DataClass<K,V>>[]) new LinkedList[TABLE_SIZE];
        for(int i = 0; i < TABLE_SIZE; i++)
        {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    public V get(K k) {
        if(k == null) throw new NullPointerException("The key is null");

        int index = hash(k) % TABLE_SIZE;

        DataClass<K,V> tempData = new DataClass<>(k, null);

        for(DataClass<K,V> d: table[index])
        {
            if(d.compareTo(tempData) == 0)
            {
                return d.getValue();
            }
        }
        return null;
    }

    private int hash(K k) {
        Key key = new Key((String) k);
        return key.hashCode() & 0xf7777777;
    }

    public V put(K k, V v) {
        if (k == null)          throw new NullPointerException(  "The parameterized Key was passed as null");
        if (v == null)          throw new NullPointerException("The parameterized value was passed as null");

        int index = hash(k) % TABLE_SIZE;

        DataClass<K,V> tempData = new DataClass<K,V>(k,v);
        V temp = null;

        for(DataClass<K,V> d : table[index])
        {
            if(d.compareTo(tempData) == 0)
            {
                temp = d.setValue(v);
                return temp;
            }
        }
        table[index].add(tempData);
        size++;
        return null;
    }

    public V remove(K k) {
        if (k == null)
            throw new NullPointerException("Key is null");

        int index = hash(k) % TABLE_SIZE;

        for (DataClass<K, V> d : table[index])
            if (d.compareTo(k) == 0) {
                if (table[index].remove(d))
                    size--;
                return d.getValue();
            }
        return null;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public Iterator<K> keys() { return new KeyIteratorObject<>(); }

    public Iterator<V> values() { return new ValueIteratorObject<>(); }

    public Iterator<K> iterator() { return keys(); }

    public Set<K> keySet() {
        Set<K> set = new LinkedHashSet<>();
        for( LinkedList<DataClass<K,V>> list: table)
        {
            for(DataClass<K,V> d : list)
            {
                set.add(d.getKey());
            }
        }
        return set;
    }



    private class KeyIteratorObject<T> implements Iterator<T> {
        T[] keys;
        int i;

        public KeyIteratorObject()
        {
            keys = (T[]) keySet().toArray();
            Arrays.sort(keys);
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
            return keys[i++];
        }
    }

    private class ValueIteratorObject<T> implements Iterator<T> {
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





    public static void main(String[] args) throws IOException {

        int table_size = 50;

        ChainingHashTable cht = new ChainingHashTable(table_size);

        BufferedReader br = new BufferedReader(new FileReader("src/Records.txt"));


        br.readLine(); //Remove the DATA Labels
        String dataPair;

        while((dataPair = br.readLine()) != null)
        {
            String[] str = dataPair.split("\\s+");  //regex for one or mare spaces
            cht.put(str[0], str[1]);
        }


        for (Iterator itr = cht.keys(); itr.hasNext(); ) {
            Object i = itr.next();
            System.out.println(i.toString());
        }

    }
}

