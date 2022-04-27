/**
 * A doubly linked list implementation
 * 
 * @author Venu Yeggadi, yeggadivenu@gmail.com
 */
 /**
  * TO-DO
  * toString()
  */
import java.lang.Iterable;
import java.util.Iterator;

public class DoublyLinkedList1<E> implements Iterable<E>{

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        if(isEmpty())
            return null;
        return head.element;
    }

    public E getLast() {
        if(isEmpty())
            return null;
        return tail.element;
    }

    public E get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index "+index+" is out of bounds for lenght "+size());
        if(index == 0)
            return getFirst();
        if(index == size - 1)
            return getLast();

        Node<E> trav;
        int i;
        if(index < size/2) {
            for(i = 0, trav = head; i < index; i++)
                trav = trav.next;
        }
        else {
            for(i = size - 1, trav = tail; i > index; i--)
                trav = trav.prev;
        }

        return trav.element;
    }

    //O(n), O(1)
    public int indexOf(Object obj) {
        int index = 0;
        Node<E> trav = head;

        //support searching for a null value
        if(obj == null) {
            while(trav != null) {
                if(trav.element == null)
                    return index;
                trav = trav.next;
                index++;
            }
        }
        else {
            while(trav != null) {
                if(obj.equals(trav.element))
                    return index;
                trav = trav.next;
                index++;
            }
        }

        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    /** An implementation of Iterable is one that provides an Iterator of itself:
        public interface Iterable<T> {
            Iterator<T> iterator();
        }

      * An iterator is a simple way of allowing some to loop through a collection
        of data without assignment privileges (though with ability to remove).
        public interface Iterator<E> {
            boolean hasNext();
            E next();
            void remove();
        }
    */
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public E next() {
                E element = trav.element;
                trav = trav.next;

                return element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    //setter methods
    public void clear() {
        Node<E> trav = head;
        while(trav != null) {
            Node<E> next = trav.next;
            trav.prev = null;
            trav.next = null;
            trav.element = null;
            trav = next;
        }
        trav = null;
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E element) {
        if(isEmpty()) {
            head = tail = new Node<E>(element, null, null);
        }
        else {
            head.prev = new Node<E>(element, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addLast(E element) {
        if(isEmpty()) {
            head = tail = new Node<E>(element, null, null);
        }
        else {
            tail.next = new Node<E>(element, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void add(E element) {
        addLast(element);
    }

    public void addAt(int index, E element) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("index "+index+" out of bounds for lenght "+size());
        if(index == 0) {
            addFirst(element);
            return;
        }

        if(index == size) {
            addLast(element);
            return;
        }

        Node<E> trav = head;
        for (int i = 0; i < index - 1; i++) {
            trav = trav.next;
        }
        Node<E> newNode = new Node<>(element, trav, trav.next);
        trav.next.prev = newNode;
        trav.next = newNode;

        size++;
    }

    public E removeFirst() {
        if(isEmpty())
            return null;
        E element = head.element;
        head = head.next;
        size--;

        if(isEmpty())
            tail = null;
        else
            head.prev = null;

        return element;
    }

    public E removeLast() {
        if(isEmpty())
            return null;

        E element = tail.element;
        tail = tail.prev;
        size--;

        if(isEmpty())
            head = null;
        else
            tail.next = null;

        return element;
    }

    //removing a node whose reference id known. O(1), O(1)
    private E remove(Node<E> node) {
        if(node.prev == null) 
            return removeFirst();
        if(node.next == null)
            return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        E element = node.element;
        node.element = null;
        node = node.prev = node.next = null;

        size--;;

        return element;
    }

    public E removeAt(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index "+index+" is out of bounds for lenght "+size());
        if(index == 0)
            return removeFirst();
        if(index == size - 1)
            return removeLast();

        Node<E> trav;
        int i;
        if(index < size/2) {
            for(i = 0, trav = head; i < index; i++)
                trav = trav.next;
        }
        else {
            for(i = size - 1, trav = tail; i > index; i--)
                trav = trav.prev;
        }

        return remove(trav);
    }

    // Remove a particular value in the linked list, O(n)
    public boolean remove(Object obj) {
        Node<E> trav = head;

        //support searching for null value
        if(obj == null) {
            while(trav != null) {
                if(trav == null) {
                    remove(trav);
                    return true;
                }
                trav = trav.next;
            }
        }
        else {
            while(trav != null) {
                if(obj.equals(trav.element)) {
                    remove(trav);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> trav = head;
        while(trav != null) {
            sb.append(trav.element);
            if(trav.next != null)
                sb.append(", ");
            trav = trav.next;
        }
        sb.append("]");

        return sb.toString();
    }
}

class DoublyLinkedList1Test  {
    public static void main(String[] args) {
        DoublyLinkedList1<Integer> list = new DoublyLinkedList1<>();
        System.out.println(list.isEmpty());
        System.out.println(list);

        System.out.println(list.removeFirst());
        System.out.println(list);

        System.out.println((list.removeLast()));
        System.out.println(list);
        
        System.out.println(list.getFirst());
        System.out.println(list);
        
        System.out.println(list.getLast());
        System.out.println(list);
        
        list.addFirst(3);
        System.out.println(list);
        
        list.addFirst(5);
        System.out.println(list);
        
        list.addLast(3);
        System.out.println(list);
        
        list.addLast(5);
        System.out.println(list);
        
        list.addAt(0, 1);
        System.out.println(list);
        
        list.addAt(1, 2);
        System.out.println(list);
        
        list.addAt(1, 3);
        System.out.println(list);

        System.out.println(list.size());

        list.addAt(1, 8);
        System.out.println(list);
        
        list.addFirst(3);
        System.out.println(list);
        
        list.addLast(4);
        System.out.println(list);
        
        list.addFirst(4);
        System.out.println(list);
        
        list.addLast(4);
        System.out.println(list);
        
        list.addFirst(5);
        System.out.println(list);

        System.out.println(list.get(0));


        
        list.addAt(4, 100);
        System.out.println(list);

        System.out.println(list.size());

        list.addAt(6, 666);
        System.out.println(list);

        System.out.println(list.get(6));

        System.out.println(list.indexOf(5));
        System.out.println(list.indexOf(243));

        System.out.println("Printing all values : ");
        Iterator<Integer> it = list.iterator();
        while(it.hasNext())
            System.out.print(it.next()+ " ");

        System.out.println();
        for(Integer i : list)
            System.out.print(i+" ");
    }
}