package opgave01.models;

public interface ListEaaa<E> extends Iterable<E> {

    /**
     * Adds an element to the end of the list
     * @param e the element to add
     */
    void add(E e);

    /**
     * Remove the element from this list.
     * Return true, if this list is modified.
     */
    boolean remove(E e);

    /**
     * Adds an element to the start of the list
     */
    void addFirst(E e);

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
     * Return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    E get(int index);

    /**
     * Add the element to this list at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index > size().
     * Note: The element can be added at an index equal to size().
     */
    void add(int index, E e);

    /**
     * Remove and return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */
    E remove(int index);

    /**
     * Return the index of the element in this list.
     * Return -1, if this list does not contain the element.
     */
    int indexOf(E e);

}