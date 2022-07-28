package com.example.arraylistrlz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    @Test()
    public void getOutOfBoundsExcTest(){
        //given
        CustomArrayList<Integer> cstArrayList = new CustomArrayList<>();
        //when
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> cstArrayList.get(22));

        //then
        Assertions.assertEquals(IndexOutOfBoundsException.class, e.getClass());
    }

    @Test
    public void addAndGetTest() {
        //given
        CustomArrayList<Integer> cstArrayList = new CustomArrayList<>();

        //when
        cstArrayList.add(2);
        cstArrayList.add(5);
        cstArrayList.add(7);

        int secondEl = cstArrayList.get(1);

        //then
        assertAll(
                () -> {
                    assertEquals(5, secondEl);
                    assertEquals(3, cstArrayList.size());
        }
        );
    }

    @Test
    public void addByIndexOutOfBoundsTest(){
        //given
        CustomArrayList<Integer> cstArrayList = new CustomArrayList<>();
        cstArrayList.add(2);
        cstArrayList.add(5);
        cstArrayList.add(7);

        //when
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> cstArrayList.addByIndex(12, 4));

        //then
        Assertions.assertEquals(IndexOutOfBoundsException.class, e.getClass());
    }

    @Test
    public void addByIndexTest(){
        //given
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);

        //when
        customArrayList.addByIndex(7, 2);

        //then
        Assertions.assertAll(
                () -> {
                    assertEquals(5, customArrayList.size());
                    assertEquals(7 ,customArrayList.get(2));
                    assertEquals("[1,2,7,3,4]", customArrayList.toString());
                }
        );
    }

    @Test
    public void setOutOfBoundsExcTest(){
        //given
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);

        //when
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.set(7 , 9));

        //then
        Assertions.assertEquals(IndexOutOfBoundsException.class, e.getClass());
    }

    @Test
    public void setTest(){
        //given
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);

        //when
        int oldValue = customArrayList.set(7, 1);

        //then
        Assertions.assertAll(
                () -> {
                    assertEquals(4 ,customArrayList.size());
                    assertEquals(7 ,customArrayList.get(1));
                    assertEquals(2, oldValue);
                }
        );
    }

    @Test
    public void isEmptyTest(){
        //given
        CustomArrayList<Integer> emptyCustomArrayList = new CustomArrayList<>();
        CustomArrayList<Integer> notEmptyCustomArrayList = new CustomArrayList<>();
        notEmptyCustomArrayList.add(2);

        //when
        boolean isEmpty = emptyCustomArrayList.isEmpty();
        boolean notEmpty = notEmptyCustomArrayList.isEmpty();

        //then
        Assertions.assertTrue(isEmpty);
        Assertions.assertFalse(notEmpty);
    }

    @Test
    public void clearTest(){
        //given
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);

        //when
        customArrayList.clear();

        //then
        Assertions.assertTrue(customArrayList.isEmpty());
    }

    @Test
    public void indexOfTest(){
        //given
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);

        //when
        int index = customArrayList.indexOf(3);

        //then
        Assertions.assertEquals(2, index);
    }


    @Test
    public void removeByIndexExcTest(){
        //given
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);

        //when
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.remove(7));

        //then
        Assertions.assertEquals(IndexOutOfBoundsException.class, e.getClass());
    }

    @Test
    public void removeByIndexTest(){
        //given
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.add(5);

        //when
        customArrayList.remove(1);

        Assertions.assertAll(
                () -> {
                    assertEquals(4, customArrayList.size());
                    assertEquals("[1,3,4,5]", customArrayList.toString());
                    assertEquals(3, customArrayList.get(1));
                }
        );
    }

    @Test
    public void replaceTest(){
        //given
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);

        List<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);


        //when
        customArrayList.addAll(linkedList);

        //then
        Assertions.assertAll(
                () -> {
                    assertEquals("[1,2,3,3,2,1]", customArrayList.toString());
                    assertEquals(6, customArrayList.size());
                }
        );

    }



}
