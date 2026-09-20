package university.stack;

public class ActionStack {

	private String[] actions;
	private int top;
	private int maxSize;

	public ActionStack(int size) {
		maxSize = size;
		actions = new String[maxSize];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public void push(String action) {
		if (isFull()) {
			System.out.println("Stack is full. Cannot add: " + action);
			return;
		}

		actions[++top] = action;
		System.out.println("Action added: " + action);
	}

	public String pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty. No action to remove.");
			return null;
		}

		return actions[top--];
	}

	public String peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return null;
		}

		return actions[top];
	}

	public void displayActions() {
		if (isEmpty()) {
			System.out.println("No actions available in the stack.");
			return;
		}

		System.out.println("\n===== ACTION STACK =====");

		for (int i = top; i >= 0; i--) {
			System.out.println(actions[i]);
		}
	}
}