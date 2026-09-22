package university.stack;

public class ActionStackTest {

	public static void main(String[] args) {

		ActionStack actionStack = new ActionStack(5);

		System.out.println("===== PUSH TEST =====");

		actionStack.push("Student 1001 registered");
		actionStack.push("Student 1002 updated");
		actionStack.push("Student 1003 deleted");

		actionStack.displayActions();

		System.out.println("\n===== PEEK TEST =====");

		String latestAction = actionStack.peek();
		System.out.println("Latest action: " + latestAction);

		System.out.println("\n===== POP TEST =====");

		String removedAction = actionStack.pop();
		System.out.println("Removed action: " + removedAction);

		actionStack.displayActions();

		System.out.println("\n===== EMPTY STACK TEST =====");

		actionStack.pop();
		actionStack.pop();
		actionStack.pop();
	}
}