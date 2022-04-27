/**
 * In developing a robust queue implementation, we allow both the front and back
   of the queue to drift rightward, with the contents of the queue "wrapping around"
   the end of an array, as necessary. Assuming that the array has fixed length N, new
   elements are enqueued toward the "end" of the current queue, progressing from the
   front to index N −1 and continuing at index 0, then 1.
  */

public class ArrayQueue<T> implements Queue<T> {
	private T[] data;
	private int size = 0;
	private int front = 0; //no nee

	public ArrayQueue() {
		this(16);
	}

	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		data = (T[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean offer(T element) {
		if(size == data.length)
			return false;
		int avail = (front + size) % data.length; //wrapping around
		data[avail] = element;
		size++;

		return true;
	}

	@Override
	public T poll() {
		if(isEmpty())
			return null;
		T element = data[front];
		data[front] = null; //dereference to help garbage collection
		front = (front + 1) % data.length;
		size--;

		return element;
	}

	@Override
	public T peek() {
		if(isEmpty())
			return null;
		return data[front];
	}
}

class ArrayQueueTest {
	public static void main(String[] args) {
		Queue<Integer> q = new ArrayQueue<>(10);
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