package com.cjboyle.test;

import com.cjboyle.queryable.IQueryable;
import com.cjboyle.queryable.Queryable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QueryableTest {
    private ArrayList<Integer> list;
    private Integer[] array;
    private IQueryable<Integer> coll;

    @BeforeEach
    void setUpBeforeEach() {
        list = new ArrayList<>();
        list.add(4);
        list.add(32);
        list.add(44);
        list.add(7);
        list.add(15);
        list.add(9);
        list.add(50);
        list.add(21);
        list.add(38);
        list.add(15);

        //array = (Integer[]) list.toArray();
        coll = new Queryable<>(list);
    }

    @Test
    void any() {
        assertTrue(coll.any());
        coll = new Queryable<>();
        assertFalse(coll.any());
    }

    @Test
    void anyPredicate() {
        assertTrue(coll.any(i -> i < 10));
        assertFalse(coll.any(i -> i > 50));
        assertThrows(NullPointerException.class, () -> coll.any(null));
        coll = new Queryable<>();
        assertFalse(coll.any(i -> i >= 0));
        assertThrows(NullPointerException.class, () -> coll.any(null));
    }

    @Test
    void count() {
        assertEquals(list.size(), coll.count());
        coll = new Queryable<>();
        assertEquals(0, coll.count());
    }

    @Test
    void countPredicate() {
        assertEquals(3, coll.count(i -> i < 10));
        assertEquals(0, coll.count(i -> i > 50));
        assertThrows(NullPointerException.class, () -> coll.count(null));
        coll = new Queryable<>();
        assertEquals(0, coll.count(i -> i >= 0));
        assertThrows(NullPointerException.class, () -> coll.count(null));
    }

    @Test
    void distinct() {
        assertEquals(9, coll.distinct().count());
        assertEquals(9, coll.distinct().distinct().count());
        coll = new Queryable<>();
        assertEquals(0, coll.distinct().count());
    }

    @Test
    void distinctPredicate() {
    }

    @Test
    void except() {
        assertEquals(7, coll.except(new Queryable<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
        assertEquals(0, coll.except(new Queryable<>(list)));
        assertEquals(10, coll.except(null));
    }

    @Test
    void first() {
    }

    @Test
    void firstPredicate() {
    }

    @Test
    void firstOrDefault() {
    }

    @Test
    void firstOrDefaultPredicate() {
    }

    @Test
    void intersect() {
    }

    @Test
    void last() {
    }

    @Test
    void lastPredicate() {
    }

    @Test
    void lastOrDefault() {
    }

    @Test
    void lastOrDefaultPredicate() {
    }

    @Test
    void orderBy() {
    }

    @Test
    void reverse() {
    }

    @Test
    void select() {
    }

    @Test
    void selectMany() {
    }

    @Test
    void single() {
    }

    @Test
    void singlePredicate() {
    }

    @Test
    void singleOrDefault() {
    }

    @Test
    void singleOrDefaultPredicate() {
    }

    @Test
    void take() {
    }

    @Test
    void union() {
    }

    @Test
    void where() {
    }

    @Test
    void contains() {
    }

    @Test
    void iterator() {
    }

    @Test
    void toArray() {
    }

    @Test
    void toArrayPredicate() {
    }

    @Test
    void toList() {
    }
}