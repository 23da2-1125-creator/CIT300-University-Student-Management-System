package university.graph;

public class GraphTest {

	public static void main(String[] args) {

		CampusGraph campusGraph = new CampusGraph(10);

		System.out.println("===== UNIVERSITY CAMPUS GRAPH TEST =====");

		System.out.println("\n===== EMPTY GRAPH TEST =====");
		System.out.println("Is graph empty? " + campusGraph.isEmpty());
		campusGraph.displayLocations();

		System.out.println("\n===== ADD LOCATIONS =====");

		campusGraph.addLocation("Administration Block");
		campusGraph.addLocation("Library");
		campusGraph.addLocation("Computer Laboratory");
		campusGraph.addLocation("Cafeteria");
		campusGraph.addLocation("Auditorium");
		campusGraph.addLocation("Sports Complex");

		System.out.println("\n===== DISPLAY LOCATIONS =====");
		campusGraph.displayLocations();

		System.out.println("\n===== ADD CONNECTIONS =====");

		campusGraph.addConnection("Administration Block", "Library");

		campusGraph.addConnection("Administration Block", "Computer Laboratory");

		campusGraph.addConnection("Library", "Cafeteria");

		campusGraph.addConnection("Computer Laboratory", "Auditorium");

		campusGraph.addConnection("Cafeteria", "Sports Complex");

		campusGraph.addConnection("Auditorium", "Sports Complex");

		System.out.println("\n===== DISPLAY CONNECTIONS =====");

		campusGraph.displayConnections();

		System.out.println("\n===== BFS TEST =====");

		campusGraph.breadthFirstSearch("Administration Block");

		System.out.println("\n===== DFS TEST =====");

		campusGraph.depthFirstSearch("Administration Block");

		System.out.println("\n===== CONNECTION CHECK =====");

		System.out.println("Library connected to Cafeteria: " + campusGraph.hasConnection("Library", "Cafeteria"));

		System.out.println("Library connected to Auditorium: " + campusGraph.hasConnection("Library", "Auditorium"));

		System.out.println("\n===== VALIDATION TESTS =====");

		campusGraph.addLocation("Library");
		campusGraph.addLocation("");
		campusGraph.addLocation(null);

		campusGraph.addConnection("Library", "Library");

		campusGraph.addConnection("Library", "Unknown Building");

		campusGraph.addConnection("Library", "Cafeteria");

		campusGraph.breadthFirstSearch("Unknown Building");

		campusGraph.depthFirstSearch("Unknown Building");

		System.out.println("\n===== REMOVE CONNECTION TEST =====");

		campusGraph.removeConnection("Library", "Cafeteria");

		campusGraph.displayConnections();

		System.out.println("\n===== REMOVE LOCATION TEST =====");

		campusGraph.removeLocation("Auditorium");
		campusGraph.displayLocations();
		campusGraph.displayConnections();

		System.out.println("\n===== TRAVERSAL AFTER REMOVAL =====");

		campusGraph.breadthFirstSearch("Administration Block");

		campusGraph.depthFirstSearch("Administration Block");

		System.out.println("\n===== INVALID REMOVAL TEST =====");

		campusGraph.removeLocation("Unknown Building");

		campusGraph.removeConnection("Library", "Cafeteria");

		System.out.println("\n===== GRAPH CAPACITY TEST =====");

		CampusGraph smallGraph = new CampusGraph(2);

		smallGraph.addLocation("Block A");
		smallGraph.addLocation("Block B");
		smallGraph.addLocation("Block C");

		System.out.println("\n===== TESTING COMPLETED =====");
	}
}