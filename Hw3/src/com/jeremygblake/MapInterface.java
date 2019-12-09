package com.jeremygblake;

import java.util.Iterator;

public interface MapInterface< K, V>
{
    public V get(K k);
    public V put(K k, V v);
    public V remove(K k);
    public int size();
    public boolean isEmpty();
    public Iterator<K> keys();  //research how to return iterable lists
    public Iterator<V> values();
}
