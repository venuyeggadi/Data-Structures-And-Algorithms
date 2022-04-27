public class DoublyLinkedQueue<T> implements Iterable<T>, Queue<T> {
	private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

	public DoublyLinkedQueue() {}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
    	return size() == 0;
	}

	public T peek() {
		if(isEmpty())
			return null;

    	return list.peekFirst();
    }

	public T poll() {
		if(isEmpty())
			return null;
		return list.removeFirst();
	}

	public boolean offer(T elem) {
		list.addLast(elem);
		return true;
	}

	@Override
	public java.util.Iterator<T> iterator() {
		return list.iterator();
	}
}

class DoublyLinkedQueueTest {
	public static void main(String[] args) {
		Queue<Integer> q = new DoublyLinkedQueue<>();
		q.offer(5);
		q.offer(3);
		System.out.println(q.size());

		System.out.println(q.poll());
		System.out.println(q.isEmpty());

		System.out.println(q.poll());
		System.out.println(q.isEmpty());

		System.out.println(q.poll());
		q.offer(7);
		q.offer(9);
		System.out.println(q.peek());
		q.offer(4);
	}
}