
/**
 * Your implementation of a circular singly linked list.
 *
 * @author Gregory Varghese
 * @userid gvarghese31
 * @GTID 903213948
 * @version 3.2
 */
public class SinglyLinkedList<T> {
    // Do not add new instance variables or modify existing ones.
    private LinkedListNode<T> head;
    private int size;

    /**
     * Adds the element to the index specified.
     *
     * Adding to indices 0 and {@code size} should be O(1), all other cases are
     * O(n).
     *
     * @param index the requested index for the new element
     * @param data the data for the new element
     * @throws java.lang.IndexOutOfBoundsException if index is negative or
     * index > size
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addAtIndex(int index, T data) {
        if ((index < 0) || (index > size)) {
            throw new IndexOutOfBoundsException("The index is either a"
                    + " negative number or out of bounds.");
        }
        if (data == null) {
            throw new IllegalArgumentException("There is no "
                    + "data to be processed (null)");
        }
        //Beggining of making new Node
        // Setting a pointer to the head (start of the Node)



        if (index == size) {
            addToBack(data);
        } else if (index == 0) {
            addToFront(data);
        } else {
            LinkedListNode<T> newNode = new LinkedListNode<>(data);
            LinkedListNode<T> curr = head;
            for (int n = 0; n < index - 1; n++) {
                curr = curr.getNext();
            }
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
            size++;
        }

    }

    /**
     * Adds the element to the front of the list.
     *
     * Must be O(1) for all cases.
     *
     * @param data the data for the new element
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("There "
                    + "is no data to be processed (null)");
        }
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        //LinkedListNode<T> curr = head;


        if (size != 0) {
            //newData = newNode.getData();
            //LinkedListNode<T>.setData(curr);
            newNode.setNext(head.getNext());
            head.setNext(newNode);
            newNode.setData(head.getData());
            head.setData(data);
        }

        if (size == 0) {
            head = newNode;
            head.setNext(head);
        }
        size++;

    }

    /**
     * Adds the element to the back of the list.
     *
     * Must be O(1) for all cases.
     *
     * @param data the data for the new element
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("There is no data "
                    + "to be processed (null)");
        }
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        if (size != 0) {
            //newData = newNode.getData();
            //LinkedListNode<T>.setData(curr);
            newNode.setNext(head.getNext());
            head.setNext(newNode);
            newNode.setData(head.getData());
            head.setData(data);
            head = head.getNext();
        }

        if (size == 0) {
            head = newNode;
            head.setNext(head);
        }
        size++;

    }

    /**
     * Removes and returns the element from the index specified.
     *
     * Removing from index 0 should be O(1), all other cases are O(n).
     *
     * @param index the requested index to be removed
     * @return the data formerly located at index
     * @throws java.lang.IndexOutOfBoundsException if index is negative or
     * index >= size
     */
    public T removeAtIndex(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException("The "
                    + "index is either a negative "
                    + "number, zero, or out of bounds.");
        }

        LinkedListNode<T> curr = head;
        T newData = null;
        if (size == 0) {
            return removeFromFront();

        }

        for (int n = 0; n < index - 1; n++) {
            curr = curr.getNext();
        }
        if (size != 0 && size != 1) {
            newData = curr.getNext().getData();
            curr.setNext(curr.getNext().getNext());
            size--;
            //return newData;
        } else if (size == 1) {
            newData = curr.getData();
            head = null;
        }



        return newData;
    }

    /**
     * Removes and returns the element at the front of the list. If the list is
     * empty, return {@code null}.
     *
     * Must be O(1) for all cases.
     *
     * @return the data formerly located at the front, null if empty list
     */
    public T removeFromFront() {
        //LinkedListNode<T> curr = head;
        T newData = null;
        newData = head.getData();
        head.setData(head.getNext().getData());
        head.setNext(head.getNext().getNext());
        size--;
        return newData;

    }

    /**
     * Removes and returns the element at the back of the list. If the list is
     * empty, return {@code null}.
     *
     * Must be O(n) for all cases.
     *
     * @return the data formerly located at the back, null if empty list
     */
    public T removeFromBack() {

        return removeAtIndex(size - 1);

    }

    /**
     * Removes the last copy of the given data from the list.
     *
     * Must be O(n) for all cases.
     *
     * @param data the data to be removed from the list
     * @return the removed data occurrence from the list itself (not the data
     * passed in), null if no occurrence
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public T removeLastOccurrence(T data) {
        if (data == null) {
            throw new IllegalArgumentException("There is no data "
                    + "to be processed (null)");
        }
        LinkedListNode<T> curr = head;
        LinkedListNode<T> previous = null;


        if (size == 0) {
            return null;
        }
        if (size == 1) {
            T newData = curr.getData();
            head = null;
            return newData;
        }
        for (int n = 0; n < size - 1; n++) {

            if (data.equals(curr.getNext().getData())) {
                previous = curr;
            }
            curr = curr.getNext();
        }
        if (previous == null) {
            return null;
        } else {
            T newData = previous.getNext().getData();
            previous.setNext(previous.getNext().getNext());
            size--;
            return newData;
        }


    }

    /**
     * Returns the element at the specified index.
     *
     * Getting index 0 should be O(1), all other cases are O(n).
     *
     * @param index the index of the requested element
     * @return the object stored at index
     * @throws java.lang.IndexOutOfBoundsException if index < 0 or
     * index >= size
     */
    public T get(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException("The "
                    + "index is either a negative number,"
                    + " zero, or out of bounds.");
        }

        T newData = null;
        LinkedListNode<T> curr = head;

        if (size == 0) {
            newData = curr.getData();
        }
        if (size != 0) {
            for (int n = 0; n < index; n++) {
                curr = curr.getNext();
            }
            newData = curr.getData();
        }

        return newData;
    }

    /**
     * Returns an array representation of the linked list.
     *
     * Must be O(n) for all cases.
     *
     * @return an array of length {@code size} holding all of the objects in
     * this list in the same order
     */
    public Object[] toArray() {
        T[] myArr = (T[]) new Object[size];
        LinkedListNode<T> curr = head;
        T dataHolder = null;
        if (size > 1) {
            myArr[0] = curr.getData();
            for (int n = 1; n < size; n++) {
                curr = curr.getNext();
                dataHolder = curr.getData();
                myArr[n] = dataHolder;
            }
        } else if (size == 1) {
            myArr[0] = curr.getData();
        } else if (size == 0) {
            return myArr;
        }
        return myArr;

        //return null;

    }

    /**
     * Returns a boolean value indicating if the list is empty.
     *
     * Must be O(1) for all cases.
     *
     * @return true if empty; false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the list of all data.
     *
     * Must be O(1) for all cases.
     */
    public void clear() {
        head = null;
        size = 0;

    }

    /**
     * Returns the number of elements in the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY!
        return size;
    }

    /**
     * Returns the head node of the linked list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return node at the head of the linked list
     */
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }
}