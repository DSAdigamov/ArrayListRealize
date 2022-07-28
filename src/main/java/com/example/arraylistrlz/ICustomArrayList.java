package com.example.arraylistrlz;

import java.util.Collection;

public interface ICustomArrayList<T> {

    void add(T item);

    void addByIndex(T item, int index);

    void addAll(Collection<? extends T> c);

    void clear();

    T get(int index);

    int indexOf(T item);

    boolean isEmpty();

    void remove(T item);

    void remove(int index);

    void replace(T item);

    Object set(T item, int index);

}
