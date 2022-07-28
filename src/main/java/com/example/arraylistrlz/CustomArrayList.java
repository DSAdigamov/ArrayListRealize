package com.example.arraylistrlz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
class CustomArrayList<T> implements ICustomArrayList<T> {

    private static final int DEFAULT_SIZE = 10;

    private Object[] customArray;

    private int size;

    public CustomArrayList() {
        this.customArray = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public CustomArrayList(int customStartCapacity) {
        this.customArray = new Object[customStartCapacity];
        size = 0;
    }

    public int size(){
        return size;
    }

    @Override
    public void add(T item) {
        if (isArrayFull()){
            changeArrayCap();
        }
        customArray[size] = item;
        size++;
    }

    @Override
    public void addByIndex(T item, int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        else {
            resizeIfNeeded();
            if (index == size)
                customArray[index] = item;
            else {
                Object prevObj = item;
                for (int i = index; i < size + 1; i++) {
                    Object currObj = prevObj;
                    prevObj = customArray[i];
                    customArray[i] = currObj;
                }
            }
            size++;
        }
    }

    @Override
    public void addAll(Collection<? extends T> c) {
        if (c.size() > 0){
            c.forEach(elem -> {
                resizeIfNeeded();
                add(elem);
            });
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            customArray[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        } else
            return (T) customArray[index];
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (customArray[i]==item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(T item) {
        int index = indexOf(item);
        remove(index);
    }

    @Override
    public void remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size-1; i++) {
            customArray[i] = customArray[i+1];
        }
        size--;
    }

    @Override
    public void replace(T item) {
        //set?
    }

    @Override
    public T set(T item, int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object oldObject = customArray[index];
        customArray[index] = item;
        return (T) oldObject;
    }

    @Override
    public String toString(){
        String list = "[";
        for (int i = 0; i < size; i++) {
            list+= customArray[i];
            if (i != size -1)
                list+= ",";
        }
        list+= "]";
        return list;
    }

    private boolean isArrayFull(){
        return customArray.length == size;
    }

    private void resizeIfNeeded(){
        if (size >= customArray.length){
            changeArrayCap();
        }
        if (size >= DEFAULT_SIZE && size < customArray.length / 4){
            changeArrayCap();
        }
    }

    private void changeArrayCap(){
        Object[] newArray = new Object[getNewCap()];
        for (int i = 0; i < size; i++) {
            newArray[i] = customArray[i];
        }
        customArray = newArray;
    }

    private int getNewCap(){
        return (size + 1) + ((size + 1)>> 1);
    }




}