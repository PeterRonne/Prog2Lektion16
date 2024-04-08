package opgave01.models;

import java.util.Currency;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EaaaLinkedList<E> implements ListEaaa<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param e the element to add
     */

    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Remove the element from this list.
     * Return true, if this list is modified.
     */

    @Override
    public boolean remove(E e) {
        if (isEmpty()) return false;

        if (head.getElement().equals(e)) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.getNext();
            }
            size--;
            return true;
        }

        Node previous = head;
        Node current = previous.getNext();

        while (current != null) {
            if (current.getElement().equals(e)) {
                if (current == tail) {
                    tail = previous;
                    previous.setNext(null);
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    /**
     * Adds an element to the start of the list
     */

    @Override
    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        if (head == null) {
            head = tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    /**
     * @return the first element in this list
     * @throws java.util.NoSuchElementException if this list is empty
     */

    @Override
    public E getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        } else {
            return head.element;
        }
    }

    /**
     * remove the first element in this list
     *
     * @throws java.util.NoSuchElementException if this list is empty
     */

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        } else {
            head = head.getNext();
            size--;
        }
    }

    /**
     * Return true, if this list contains the element.
     */

    @Override
    public boolean contains(E e) {
        Node<E> current = head;

        while (current != null) {
            if (current.getElement().equals(e)) return true;

            current = current.getNext();
        }
        return false;
    }

    /**
     * Remove all elements from this list.
     */

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    /**
     * Return the size of this list.
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Return true, if this list is empty.
     */

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return getRecursive(head, index, 0);
    }

    private E getRecursive(Node<E> current, int targetIndex, int currentIndex) {
        if (currentIndex == targetIndex) {
            return current.getElement();
        }
        return getRecursive(current.getNext(), targetIndex, currentIndex + 1);
    }

    /**
     * Add the element to this list at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index > size().
     * Note: The element can be added at an index equal to size().
     */

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<E> node = new Node<>(e);
        Node<E> current = head;
        int currentIndex = 0;

        if (index == size()) {
            add(e);
            return;
        }

        while (currentIndex < index - 1) {
            current = current.getNext();
            currentIndex++;
        }

        node.setNext(current.getNext());
        current.setNext(node);
        size++;
    }

    /**
     * Remove and return the element at the index.
     * Throw IndexOutOfBoundsException, if index < 0 or index >= size().
     */

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<E> current = head;
        Node<E> previous = null;
        int currentIndex = 0;

        while (currentIndex < index) {
            previous = current;
            current = current.getNext();
            currentIndex++;
        }

        if (current == head) {
            head = head.getNext();
        } else if (current == tail) {
            previous.setNext(null);
            tail = previous;
        } else {
            previous.setNext(current.getNext());
        }

        if (head == null) {
            tail = null;
        }

        size--;
        return current.getElement();
    }

    /**
     * Return the index of the element in this list.
     * Return -1, if this list does not contain the element.
     */

    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.getElement().equals(e)) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }


    class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current;

        public LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("List is empty");
            }
            E element = current.element;
            current = current.next;
            return element;
        }
    }
}
