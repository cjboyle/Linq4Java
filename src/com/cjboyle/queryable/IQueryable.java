package com.cjboyle.queryable;

import java.util.*;
import java.util.function.Function;

public interface IQueryable<T> {

    /**
     * Determines whether there are any elements in the sequence
     *
     * @return
     */
    boolean any();

    /**
     * Determines whether there are any elements in the sequence matching the given condition
     *
     * @param predicate
     * @return
     */
    boolean any(Function<T, Boolean> predicate);

    /**
     * Determines whether all elements in the sequence match the given condition
     *
     * @param predicate
     * @return
     */
    boolean all(Function<T, Boolean> predicate);

    T average();

    <R extends Comparable<R>> R average(Function<T, R> selector);

    /**
     * Concatenates the elements of two sequences in the order they are processed
     *
     * @param second
     * @return
     */
    IQueryable<T> concat(IQueryable<T> second);

    /**
     * Determines whether the sequence contains the given element
     *
     * @param item
     * @return
     */
    boolean contains(T item);

    /**
     * Gets the number of elements in the sequence
     *
     * @return
     */
    int count();

    /**
     * Gets the number of elements in the sequence matching the given condition
     *
     * @param predicate
     * @return
     */
    int count(Function<T, Boolean> predicate);

    /**
     * Gets a sequence containing only unique elements
     *
     * @return
     */
    IQueryable<T> distinct();

    /**
     * TODO: Current implementation returns a sequence with one element. Remove?
     *
     * @param predicate
     * @return
     */
    IQueryable<T> distinct(Function<T, Boolean> predicate);

    /**
     * Gets a sequence of all current elements not also contained in the second sequence
     *
     * @param second
     * @return
     */
    IQueryable<T> except(IQueryable<T> second);

    /**
     * Gets the first element in the sequence
     *
     * @return
     */
    T first();

    /**
     * Gets the first element in the sequence matching the given condition
     *
     * @param predicate
     * @return
     */
    T first(Function<T, Boolean> predicate);

    /**
     * Gets the first element in the sequence, or null if the sequence contains no elements
     *
     * @return
     */
    T firstOrDefault();

    /**
     * Gets the first element in the sequence matching the given condition, or null if no matches are found
     *
     * @param predicate
     * @return
     */
    T firstOrDefault(Function<T, Boolean> predicate);

    /**
     * Gets the element contained at the given index location
     *
     * @param index
     * @return
     */
    T get(int index);

    /**
     * Gets a sequence of all current elements that are also contained in the second sequence
     *
     * @param second
     * @return
     */
    IQueryable<T> intersect(IQueryable<T> second);

    /**
     * Gets the last element in the sequence
     *
     * @return
     */
    T last();

    /**
     * Gets the first element in the sequence matching the given condition
     *
     * @param predicate
     * @return
     */
    T last(Function<T, Boolean> predicate);

    /**
     * Gets the first element in the sequence, or null if the sequence contains no elements
     *
     * @return
     */
    T lastOrDefault();

    /**
     * Gets the first element in the sequence matching the given condition, or null if the sequence contains no matches
     *
     * @param predicate
     * @return
     */
    T lastOrDefault(Function<T, Boolean> predicate);

    /**
     * Gets the maximum element in the sequence
     *
     * @return
     */
    T max();

    /**
     * Gets the maximum element of the selector results
     *
     * @param selector
     * @param <R>
     * @return
     */
    <R extends Comparable<R>> R max(Function<T, R> selector);

    /**
     * Gets the minimum element in the sequence
     *
     * @return
     */
    T min();

    /**
     * Gets the minimum element selector result
     *
     * @param selector
     * @param <R>
     * @return
     */
    <R extends Comparable<R>> R min(Function<T, R> selector);

    /**
     * Gets a sequence of elements sorted by the given selector
     *
     * @param selector
     * @param <R>
     * @return
     */
    <R extends Comparable<R>> IQueryable<T> orderBy(Function<T, R> selector);

    /**
     * Gets a sequence of elements sorted in descending order by the given selector
     *
     * @param selector
     * @param <R>
     * @return
     */
    <R extends Comparable<R>> IQueryable<T> orderByDesc(Function<T, R> selector);

    /**
     * Further sorts an ordered sequence by an additional selector
     *
     * @param selector
     * @param <R>
     * @return
     */
    <R extends Comparable<R>> IQueryable<T> thenBy(Function<T, R> selector);

    /**
     * Further sorts an ordered sequence by an additional selector in descending order
     *
     * @param selector
     * @param <R>
     * @return
     */
    <R extends Comparable<R>> IQueryable<T> thenByDesc(Function<T, R> selector);

    /**
     * Reverses the elements in the sequence
     *
     * @return
     */
    IQueryable<T> reverse();

    /**
     * Gets a sequence of projected elements
     *
     * @param selector
     * @param <R>
     * @return
     */
    <R> IQueryable<R> select(Function<T, R> selector);

    /**
     * Gets a flattened sequence of projected elements
     *
     * @param selector
     * @param <R>
     * @return
     */
    <R> IQueryable<R> selectMany(Function<T, Collection<? extends R>> selector);

    /**
     * Gets the only element in the sequence
     *
     * @return
     */
    T single();

    /**
     * Gets the only element in the sequence matching the given condition
     *
     * @param predicate
     * @return
     */
    T single(Function<T, Boolean> predicate);

    /**
     * Gets the only element in the sequence, or null if the sequence contains no elements
     *
     * @return
     */
    T singleOrDefault();

    /**
     * Gets the only element in the sequence matching the given condition, or null if the sequence contains no matches
     *
     * @param predicate
     * @return
     */
    T singleOrDefault(Function<T, Boolean> predicate);


    Number sum();


    Number sum(Function<T, Number> selector);

    /**
     * Gets the sequence of elements counting from the start
     *
     * @param count
     * @return
     */
    IQueryable<T> take(int count);

    /**
     * Gets the sequence of elements counting from the end
     *
     * @param count
     * @return
     */
    IQueryable<T> takeEnd(int count);

    /**
     * Gets a sequence of all elements in both sequences without duplicates
     *
     * @param second
     * @return
     */
    IQueryable<T> union(IQueryable<T> second);

    /**
     * Gets a sequence of all elements matching the given condition
     *
     * @param predicate
     * @return
     */
    IQueryable<T> where(Function<T, Boolean> predicate);

    /**
     * Gets an iterator for the sequence
     *
     * @return
     */
    Iterator<T> iterator();

    /**
     * Sends the sequence to an array of Objects
     *
     * @return
     */
    Object[] toArray();

    <R> HashMap<R, T> toHashMap();

    T[] toArray(T[] array);

    List<T> toList();
}
