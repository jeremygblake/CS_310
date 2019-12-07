package com.company;

import javax.xml.crypto.Data;
import java.util.*;

public class ChainingHashTable<K extends Comparable<K>, V> implements MapInterface<K, V>, Iterable<K>
{

    private LinkedList<DataClass<K,V>>[] table;
    private int TABLE_SIZE;
    private int size;

    public ChainingHashTable(int n)
    {
        this.TABLE_SIZE = n;
        table = (LinkedList<DataClass<K,V>>[]) new LinkedList[TABLE_SIZE];
        for(int i = 0; i < TABLE_SIZE; i++)
        {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    public V get(K k)
    {
        if(k == null) throw new NullPointerException("The key is null");

        int index = hash(k) % TABLE_SIZE;

        DataClass<K,V> tempData = new DataClass<>(k, null);

        for(DataClass<K,V> d: table[index])
        {
            if(d.compareTo(tempData) == 0)
            {
                return d.value;
            }
        }
        return null;
    }

    private int hash(K k)
    {
        Key key = new Key((String) k);
        return key.hashCode() & 0xf7777777;
    }

    public V put(K k, V v)
    {
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
            if (d.key.compareTo(k) == 0) {
                if (table[index].remove(d))
                    size--;
                return d.value;
            }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<K> keys()
    {
        return new KeyIteratorUsable<>();
    }


    public Iterator<V> values()
    {
        return new ValueIteratorUsable<>();
    }


    public Set<K> keySet()
    {
        Set<K> set = new LinkedHashSet<>();
        for( LinkedList<DataClass<K,V>> list: table)
        {
            for(DataClass<K,V> d : list)
            {
                set.add(d.key);
            }
        }
        return set;
    }

    @Override
    public Iterator<K> iterator()
    {
        return keys();
    }

    private class DataClass<K extends Comparable<K>, V> implements Comparable<DataClass<K,V>>
    {
        final K key;
        V value;

        public DataClass(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(DataClass<K, V> d) {
            return this.key.compareTo(d.key);
        }

        @Override
        public String toString()
        {
            return "key=" + key + ", value=" + value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V value) {
            V temp = this.value;
            this.value = value;
            return temp;
        }


    }



    private class KeyIteratorUsable<T> implements Iterator<T>
    {
        T[] keys;
        int i;

        public KeyIteratorUsable()
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



    private class ValueIteratorUsable<T> implements Iterator<T>
    {
        Iterator<K> iter;


        public ValueIteratorUsable()
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

        ChainingHashTable cht = new ChainingHashTable(table_size);
        Object x = new Object(){
            int num = 0;
        };
        Object y = new Object(){
            int num = 0;
        };
        Object z = new Object(){
            int num = 0;
        };

        cht.put("abc", new String("Jeremy"));
        cht.put("def", new String("Andy"));
        cht.put("ghi", new String("Hannah"));


        Iterator itr = cht.values();

        for (Iterator it = itr; it.hasNext(); ) {
            Object i = it.next();
            System.out.println(i.toString());
        }

        cht.remove("abc");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(cht.get("abc").toString());

    }

}

