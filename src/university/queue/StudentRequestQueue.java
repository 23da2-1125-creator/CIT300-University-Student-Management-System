package university.queue;

public class StudentRequestQueue {

	private String[] requests;
	private int front;
	private int rear;
	private int count;
	private int maxSize;

	public StudentRequestQueue(int size) {
		maxSize = size;
		requests = new String[maxSize];
		front = 0;
		rear = -1;
		count = 0;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == maxSize;
	}

	public void addRequest(String request) {
		if (isFull()) {
			System.out.println("Queue is full. Cannot add: " + request);
			return;
		}

		rear = (rear + 1) % maxSize;
		requests[rear] = request;
		count++;

		System.out.println("Request added: " + request);
	}

	public String processRequest() {
		if (isEmpty()) {
			System.out.println("Queue is empty. No request to process.");
			return null;
		}

		String request = requests[front];
		requests[front] = null;
		front = (front + 1) % maxSize;
		count--;

		return request;
	}

	public String peekRequest() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return null;
		}

		return requests[front];
	}

	public void displayRequests() {
		if (isEmpty()) {
			System.out.println("No pending requests in the queue.");
			return;
		}

		System.out.println("\n===== STUDENT REQUEST QUEUE =====");

		for (int i = 0; i < count; i++) {
			int index = (front + i) % maxSize;
			System.out.println((i + 1) + ". " + requests[index]);
		}
	}
}