package com.cjboyle.queryable;

import java.util.*;
import java.util.function.Function;

public class Queryable<T> implements IQueryable<T> {

    private List<T> list;

    public Queryable() {
        this.list = new ArrayList<>();
    }

    public Queryable(T[] array) {
        this.list = Arrays.asList(array);
    }

    public Queryable(List<T> list) {
        Collections.copy(this.list, list);
    }

    @Override
    public boolean any() {
        return this.count() > 0;
    }

    @Override
    public boolean any(Function<T, Boolean> predicate) {
        for (T t : list) {
            if (predicate.apply(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return this.list.size();
    }

    @Override
    public int count(Function<T, Boolean> predicate) {
        return this.where(predicate).count();
    }

    @Override
    public IQueryable<T> distinct() {
        Queryable<T> result = new Queryable<>();
        for (T t : list) {
            if (!result.contains(t)) {
                result.list.add(t);
            }
        }
        return result;
    }

    @Override
    public IQueryable<T> distinct(Function<T, Boolean> predicate) {
        Queryable<T> result = new Queryable<>();
        for (T t : list) {
            if (!result.any(predicate)) {
                result.list.add(t);
            }
        }
        return result;
    }

    @Override
    public IQueryable<T> except(IQueryable<T> second) {
        Queryable<T> result = new Queryable<>(list);
        for (T t : result.list) {
            if (second.contains(t)) {
                result.list.remove(t);
            }
        }
        return result;
    }

    @Override
    public T first() {
        T result = this.firstOrDefault();
        if (result == null) {
            throw new RuntimeException("Sequence contains no elements");
        }
        return result;
    }

    @Override
    public T first(Function<T, Boolean> predicate) {
        T result = this.firstOrDefault(predicate);
        if (result == null) {
            throw new RuntimeException("Sequence contains no matches");
        }
        return result;
    }

    @Override
    public T firstOrDefault() {
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public T firstOrDefault(Function<T, Boolean> predicate) {
        Queryable<T> result = (Queryable<T>) this.where(predicate);
        return result.count() == 0 ? null : result.list.get(0);
    }

    @Override
    public IQueryable<T> intersect(IQueryable<T> second) {
        Queryable<T> result = new Queryable<>();
        for (T t : this.list) {
            if (second.contains(t)) {
                result.list.add(t);
            }
        }
        return result;
    }

    @Override
    public T last() {
        T result = this.lastOrDefault();
        if (result == null) {
            throw new RuntimeException("Sequence contains no elements");
        }
        return result;
    }

    @Override
    public T last(Function<T, Boolean> predicate) {
        T result = this.lastOrDefault(predicate);
        if (result == null) {
            throw new RuntimeException("Sequence contains no matches");
        }
        return result;
    }

    @Override
    public T lastOrDefault() {
        return count() == 0 ? null : list.get(count() - 1);
    }

    @Override
    public T lastOrDefault(Function<T, Boolean> predicate) {
        Queryable<T> result = (Queryable<T>) this.where(predicate);
        return result.count() == 0 ? null : result.list.get(0);
    }

    @Override
    public <R extends Comparable<R>> IQueryable<T> orderBy(Function<T, R> selector) {
        Queryable<T> result = new Queryable<>();
        Collections.copy(result.list, list);
        result.list.sort(Comparator.comparing(selector));
        return result;
    }

    @Override
    public IQueryable<T> reverse() {
        Queryable<T> result = new Queryable<>();
        Collections.copy(result.list, list);
        Collections.reverse(result.list);
        return result;
    }

    @Override
    public <R> IQueryable<R> select(Function<T, R> selector) {
        Queryable<R> result = new Queryable<>();
        for (T t : list) {
            result.list.add(selector.apply(t));
        }
        return result;
    }

    @Override
    public <R> IQueryable<R> selectMany(Function<T, Collection<? extends R>> selector) {
        Queryable<R> result = new Queryable<>();
        for (T t : list) {
            result.list.addAll(selector.apply(t));
        }
        return result;
    }

    @Override
    public T single() {
        T result = this.singleOrDefault();
        if (result == null) {
            throw new RuntimeException("No matches");
        }
        return result;
    }

    @Override
    public T single(Function<T, Boolean> predicate) {
        T result = this.singleOrDefault(predicate);
        if (result == null) {
            throw new RuntimeException("No matches");
        }
        return result;
    }

    @Override
    public T singleOrDefault() {
        if (count() > 1) {
            throw new RuntimeException("More than one element");
        }
        return firstOrDefault();
    }

    @Override
    public T singleOrDefault(Function<T, Boolean> predicate) {
        Queryable<T> result = (Queryable<T>) this.where(predicate);
        if (result.count() > 1) {
            throw new RuntimeException("More than one match");
        }
        return result.firstOrDefault();
    }

    @Override
    public IQueryable<T> take(int amount) {
        return new Queryable<>(list.subList(0, amount));
    }

    @Override
    public IQueryable<T> union(IQueryable<T> second) {
        Queryable<T> result = new Queryable<>(list);
        result.list.addAll(second.toList());
        return result;
    }

    @Override
    public IQueryable<T> where(Function<T, Boolean> predicate) {
        Queryable<T> result = new Queryable<>();
        for (T t : list) {
            if (predicate.apply(t)) {
                result.list.add(t);
            }
        }
        return result;
    }

    public boolean contains(T t) {
        return list.contains(t);
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public T[] toArray(T[] array) {
        return new Queryable<>(array).toArray(array);
    }

    @Override
    public List<T> toList() {
        return list;
    }
}
