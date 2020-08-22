package me.hdgenius.dynamiccollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ExclusionSet<T> implements Set<T> {

    private Collection<T> valuesToExclude;

    ExclusionSet(final Collection<T> valuesToExclude) {
        this.valuesToExclude = valuesToExclude;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Cannot determine the size of a dynamic collection without a domain");
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(final Object value) {
        return !valuesToExclude.contains(value);
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Cannot create an Iterator for a dynamic collection without a domain");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Cannot create an array from a dynamic collection without a domain");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Cannot create an array from a dynamic collection without a domain");
    }

    public boolean add(final T t) {
        return valuesToExclude.remove(t);
    }

    public boolean remove(final Object o) {
        return valuesToExclude.add((T) o);
    }

    public boolean containsAll(final Collection<?> values) {
        return values.stream().noneMatch(valuesToExclude::contains);
    }

    public boolean addAll(final Collection<? extends T> c) {
        c.forEach(valuesToExclude::remove);
        return true;
    }

    public boolean removeAll(final Collection<?> values) {
        return valuesToExclude.addAll((Collection<T>) values);
    }

    public boolean retainAll(final Collection<?> valuesToRetain) {
        valuesToExclude = new ExclusionSet<>((Collection<T>) valuesToRetain);
        return true;
    }

    public void clear() {
        final Collection<T> noValues = new ArrayList<>();
        valuesToExclude = new ExclusionSet<>(noValues);
    }
}