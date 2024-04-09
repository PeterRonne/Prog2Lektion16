package opgave02.models;

import opgave01.models.EaaaLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EaaaSortedLinkedList<E extends Comparable<E>> implements SortedListEaaa<E> {

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
     * Adds an element to the list, sorted by the natural order.
     *
     * @param e the element to add
     */
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);

        if (head == null) {
            head = tail = newNode;
        } else if (head.element.compareTo(e) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null && current.next.element.compareTo(e) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if (current == tail) {
                tail = newNode;
            }
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
                head = head.next;
            }
            size--;
            return true;
        }

        Node previous = head;
        Node current = previous.next;

        while (current != null) {
            if (current.getElement().equals(e)) {
                if (current == tail) {
                    tail = previous;
                    previous.setNext(null);
                } else {
                    previous.setNext(current.next);
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    /**
     * Return true, if this list contains the element.
     */
    @Override
    public boolean contains(E e) {
        Node<E> current = head;

        while (current != null) {
            if (current.element.equals(e)) return true;

            current = current.next;
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
        } else if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    /**
     * @return the last element in this list
     * @throws java.util.NoSuchElementException if this list is empty
     */

    @Override
    public E getLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        } else {
            return tail.element;
        }
    }

    /**
     * remove the last element in this list
     *
     * @throws java.util.NoSuchElementException if this list is empty
     */
    @Override
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        } else if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    /**
     * Returns an iterator over the elements in this list in descending order.
     *
     * @return an iterator over the elements in this list in descending order
     */
    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

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

    class LinkedListIterator implements Iterator<E> {
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
