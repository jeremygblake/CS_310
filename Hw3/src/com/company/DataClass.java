package com.company;

public class DataClass<K, V>
{
    K key;
    V value;

    public DataClass(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode()
    {
        int hCode = -1;

        return hCode;

    }
}