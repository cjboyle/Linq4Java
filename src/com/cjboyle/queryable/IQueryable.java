package com.cjboyle.queryable;

import java.util.*;
import java.util.function.Function;

public interface IQueryable<T> {
    public boolean any();

    public boolean any(Function<T, Boolean> predicate);

    public boolean contains(T item);

    public int count();

    public int count(Function<T, Boolean> predicate);

    public IQueryable<T> distinct();

    public IQueryable<T> distinct(Function<T, Boolean> predicate);

    public IQueryable<T> except(IQueryable<T> second);

    public T first();

    public T first(Function<T, Boolean> predicate);

    public T firstOrDefault();

    public T firstOrDefault(Function<T, Boolean> predicate);

    public T get(int index);

    public IQueryable<T> intersect(IQueryable<T> second);

    public T last();

    public T last(Function<T, Boolean> predicate);

    public T lastOrDefault();

    public T lastOrDefault(Function<T, Boolean> predicate);

    public <R extends Comparable<R>> IQueryable<T> orderBy(Function<T, R> selector);

    public IQueryable<T> reverse();

    public <R> IQueryable<R> select(Function<T, R> selector);

    public <R> IQueryable<R> selectMany(Function<T, Collection<? extends R>> selector);

    public T single();

    public T single(Function<T, Boolean> predicate);

    public T singleOrDefault();

    public T singleOrDefault(Function<T, Boolean> predicate);

    public IQueryable<T> take(int count);

    public IQueryable<T> union(IQueryable<T> second);

    public IQueryable<T> where(Function<T, Boolean> predicate);

    public Iterator<T> iterator();

    public Object[] toArray();

    public T[] toArray(T[] array);

    public List<T> toList();
}
