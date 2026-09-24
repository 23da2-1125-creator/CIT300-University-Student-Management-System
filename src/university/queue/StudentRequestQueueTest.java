package university.queue;

public class StudentRequestQueueTest {

	public static void main(String[] args) {

		StudentRequestQueue requestQueue = new StudentRequestQueue(3);

		System.out.println("===== ADD REQUEST TEST =====");

		requestQueue.addRequest("Student 1001 - Certificate Request");

		requestQueue.addRequest("Student 1002 - Course Registration");

		requestQueue.addRequest("Student 1003 - ID Card Request");

		System.out.println("\n===== FULL QUEUE TEST =====");

		requestQueue.addRequest("Student 1004 - Transcript Request");

		requestQueue.displayRequests();

		System.out.println("\n===== PEEK TEST =====");

		String nextRequest = requestQueue.peekRequest();
		System.out.println("Next request: " + nextRequest);

		System.out.println("\n===== PROCESS REQUEST TEST =====");

		String processedRequest = requestQueue.processRequest();
		System.out.println("Processed request: " + processedRequest);

		requestQueue.displayRequests();

		System.out.println("\n===== EMPTY QUEUE TEST =====");

		System.out.println("Processed request: " + requestQueue.processRequest());

		System.out.println("Processed request: " + requestQueue.processRequest());

		requestQueue.processRequest();
	}
}