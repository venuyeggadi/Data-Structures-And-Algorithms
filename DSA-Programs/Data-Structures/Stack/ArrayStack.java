import java.util.Arrays;
import java.util.EmptyStackException;

class ArrayStack<E> implements Stack<E>{
	private int tos = -1;
	private int capacity;
	private E[] data;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		capacity = 16;
		data = (E[]) new Object[capacity];
	}

	//O(1)
	@Override
	public int size() {
		return tos + 1;
	}

	//O(1)
	@Override
	public boolean isEmpty() {
		return tos == -1;
	}

	//O(1) (amortized)
	@Override
	public void push(E element) {
		if(size() == capacity)
			increaseCapacity();
		data[++tos] = element;
	}

	//O(n)
	private void increaseCapacity() {
		capacity *= 2;
		data = Arrays.copyOf(data, capacity);
	}

	//O(1)
	public E pop() {
		if(isEmpty())
			return null; //throw new EmptyStackException();
		
		E element = data[tos];
		data[tos--] = null;//dereference to help garbage collection

		return element;
	}

	//O(1)
	public E peek() {
		if(isEmpty())
			return null; //throw new EmptyStackException();
		
		return data[tos];
	}
}

class ArrayStackTest {
	public static void main(String[] args) {
		Stack<Integer> s = new ArrayStack<>();// contents: ()
		s.push(5);// contents: (5)
		s.push(3);// contents: (5, 3)
		System.out.println(s.size()); // contents: (5, 3) outputs 2
		
		System.out.println(s.pop()); // contents: (5) outputs 3
		System.out.println(s.size());// outputs 1

		System.out.println(s.isEmpty()); // contents: (5) outputs false
		System.out.println(s.pop()); // contents: () outputs 5
		
		System.out.println(s.isEmpty()); // contents: () outputs true
		System.out.println(s.pop()); // contents: () outputs null
		
		s.push(7); // contents: (7)
		s.push(9); // contents: (7, 9)
		System.out.println(s.peek()); // contents: (7, 9) outputs 9
		
		s.push(4); // contents: (7, 9, 4)
		System.out.println(s.size()); // contents: (7, 9, 4) outputs 3
		System.out.println(s.pop()); // contents: (7, 9) outputs 4
		
		s.push(6); // contents: (7, 9, 6)
		s.push(8); // contents: (7, 9, 6, 8)
		System.out.println(s.pop()); //outputs 8
	}
}