package opgave02.models;

import java.util.Iterator;

public interface SortedListEaaa<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Adds an element to the list, sorted by the natural order.
     * @param e the element to add
     */
    void add(E e);

    /**
     * Remove the element from this list.
     * Return true, if this list is modified.
     */
    boolean remove(E e);

    /**
     * Return true, if this list contains the element.
     */
    boolean contains(E e);

    /**
     * Remove all elements from this list.
     */
    void clear();

    /**
     * Return the size of this list.
     */
    int size();

    /**
     * Return true, if this list is empty.
     */
    boolean isEmpty();

    /**
     * @return the first element in this list
     * @throws java.util.NoSuchElementException if this list is empty
     */
    E getFirst();

    /**
     * remove the first element in this list
     * @throws java.util.NoSuchElementException if this list is empty
     */
    void removeFirst();

    /**
     * @return the last element in this list
     * @throws java.util.NoSuchElementException if this list is empty
     */
    E getLast();

    /**
     * remove the last element in this list
     * @throws java.util.NoSuchElementException if this list is empty
     */
    void removeLast();

    /**
     * Returns an iterator over the elements in this list in descending order.
     * @return an iterator over the elements in this list in descending order
     */
    Iterator<E> descendingIterator();
}
