package com.company;

public class DataClass<K extends Comparable<K>, V> implements Comparable<DataClass<K,V>> {
    private final K key;
    private V value;

    public DataClass(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(DataClass<K, V> d) {
        return ((String)this.key).compareTo((String)d.getKey());
    }

    public int compareTo(K k) {
        return ((String)this.key).compareTo((String)k);
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