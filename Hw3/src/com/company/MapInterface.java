package com.company;

public interface MapInterface< K , V >
{
    public V get(K k);
    public V put(K k, V v);
    public V remove(K k);
    public int sie();
    public boolean isEmpty();
    public K[] keys();  //research how to return iterable lists
    public V[] values();
}
