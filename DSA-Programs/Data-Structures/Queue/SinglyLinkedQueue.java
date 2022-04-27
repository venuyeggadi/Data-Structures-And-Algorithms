public class SinglyLinkedQueue<T>  implements Queue<T>{
	private SinglyLinkedList<T> list = new SinglyLinkedList<>();

	public SinglyLinkedQueue() {}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}


	@Override
	public boolean offer(T element) {
		list.addLast(element);
		return true;
	}

	@Override
	public T poll() {
		return list.removeFirst();
	}

	@Override
	public T peek() {
		return list.peekFirst();
	}
}

class SinglyLinkedQueueTest {
	public static void main(String[] args) {
		Queue<Integer> q = new SinglyLinkedQueue<>();
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