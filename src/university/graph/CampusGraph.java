package university.graph;

public class CampusGraph {

	private String[] locations;
	private boolean[][] adjacencyMatrix;
	private int locationCount;
	private int maxLocations;

	public CampusGraph(int maxLocations) {
		if (maxLocations <= 0) {
			throw new IllegalArgumentException("Maximum locations must be greater than zero.");
		}

		this.maxLocations = maxLocations;
		this.locations = new String[maxLocations];
		this.adjacencyMatrix = new boolean[maxLocations][maxLocations];
		this.locationCount = 0;
	}

	private int findLocationIndex(String locationName) {
		if (locationName == null) {
			return -1;
		}

		for (int i = 0; i < locationCount; i++) {
			if (locations[i].equalsIgnoreCase(locationName.trim())) {
				return i;
			}
		}

		return -1;
	}

	public boolean addLocation(String locationName) {
		if (locationName == null || locationName.trim().isEmpty()) {
			System.out.println("Location name cannot be empty.");
			return false;
		}

		if (locationCount == maxLocations) {
			System.out.println("Graph is full. Cannot add more locations.");
			return false;
		}

		if (findLocationIndex(locationName) != -1) {
			System.out.println("Location already exists: " + locationName);
			return false;
		}

		locations[locationCount] = locationName.trim();
		locationCount++;

		System.out.println("Location added successfully: " + locationName);
		return true;
	}

	public void displayLocations() {
		if (locationCount == 0) {
			System.out.println("No locations available.");
			return;
		}

		System.out.println("Campus Locations:");

		for (int i = 0; i < locationCount; i++) {
			System.out.println((i + 1) + ". " + locations[i]);
		}
	}

	public boolean isEmpty() {
		return locationCount == 0;
	}

	public boolean addConnection(String firstLocation, String secondLocation) {

		int firstIndex = findLocationIndex(firstLocation);
		int secondIndex = findLocationIndex(secondLocation);

		if (firstIndex == -1 || secondIndex == -1) {
			System.out.println("Cannot create connection. Location not found.");
			return false;
		}

		if (firstIndex == secondIndex) {
			System.out.println("A location cannot connect to itself.");
			return false;
		}

		if (adjacencyMatrix[firstIndex][secondIndex]) {
			System.out.println("Connection already exists between " + firstLocation + " and " + secondLocation);
			return false;
		}

		adjacencyMatrix[firstIndex][secondIndex] = true;
		adjacencyMatrix[secondIndex][firstIndex] = true;

		System.out.println("Connection added: " + firstLocation + " <-> " + secondLocation);

		return true;
	}

	public boolean removeConnection(String firstLocation, String secondLocation) {

		int firstIndex = findLocationIndex(firstLocation);
		int secondIndex = findLocationIndex(secondLocation);

		if (firstIndex == -1 || secondIndex == -1) {
			System.out.println("Cannot remove connection. Location not found.");
			return false;
		}

		if (!adjacencyMatrix[firstIndex][secondIndex]) {
			System.out.println("No connection exists between " + firstLocation + " and " + secondLocation);
			return false;
		}

		adjacencyMatrix[firstIndex][secondIndex] = false;
		adjacencyMatrix[secondIndex][firstIndex] = false;

		System.out.println("Connection removed: " + firstLocation + " <-> " + secondLocation);

		return true;
	}

	public boolean hasConnection(String firstLocation, String secondLocation) {

		int firstIndex = findLocationIndex(firstLocation);
		int secondIndex = findLocationIndex(secondLocation);

		if (firstIndex == -1 || secondIndex == -1) {
			return false;
		}

		return adjacencyMatrix[firstIndex][secondIndex];
	}

	public void displayConnections() {
		if (locationCount == 0) {
			System.out.println("No locations available.");
			return;
		}

		System.out.println("Campus Graph Connections:");

		for (int i = 0; i < locationCount; i++) {
			System.out.print(locations[i] + " -> ");

			boolean connectionFound = false;

			for (int j = 0; j < locationCount; j++) {
				if (adjacencyMatrix[i][j]) {
					if (connectionFound) {
						System.out.print(", ");
					}

					System.out.print(locations[j]);
					connectionFound = true;
				}
			}

			if (!connectionFound) {
				System.out.print("No connections");
			}

			System.out.println();
		}
	}

	public void breadthFirstSearch(String startLocation) {
		int startIndex = findLocationIndex(startLocation);

		if (startIndex == -1) {
			System.out.println("BFS cannot start. Location not found: " + startLocation);
			return;
		}

		boolean[] visited = new boolean[locationCount];
		int[] queue = new int[maxLocations];

		int front = 0;
		int rear = 0;

		visited[startIndex] = true;
		queue[rear] = startIndex;
		rear++;

		System.out.println("BFS traversal starting from " + startLocation + ":");

		boolean firstOutput = true;

		while (front < rear) {
			int currentIndex = queue[front];
			front++;

			if (!firstOutput) {
				System.out.print(" -> ");
			}

			System.out.print(locations[currentIndex]);
			firstOutput = false;

			for (int i = 0; i < locationCount; i++) {
				if (adjacencyMatrix[currentIndex][i] && !visited[i]) {

					visited[i] = true;
					queue[rear] = i;
					rear++;
				}
			}
		}

		System.out.println();
	}

	public void depthFirstSearch(String startLocation) {
		int startIndex = findLocationIndex(startLocation);

		if (startIndex == -1) {
			System.out.println("DFS cannot start. Location not found: " + startLocation);
			return;
		}

		boolean[] visited = new boolean[locationCount];
		StringBuilder traversalResult = new StringBuilder();

		depthFirstSearchRecursive(startIndex, visited, traversalResult);

		System.out.println("DFS traversal starting from " + startLocation + ":");

		System.out.println(traversalResult);
	}

	private void depthFirstSearchRecursive(int currentIndex, boolean[] visited, StringBuilder traversalResult) {

		visited[currentIndex] = true;

		if (traversalResult.length() > 0) {
			traversalResult.append(" -> ");
		}

		traversalResult.append(locations[currentIndex]);

		for (int i = 0; i < locationCount; i++) {
			if (adjacencyMatrix[currentIndex][i] && !visited[i]) {

				depthFirstSearchRecursive(i, visited, traversalResult);
			}
		}
	}

	public boolean removeLocation(String locationName) {
		int removeIndex = findLocationIndex(locationName);

		if (removeIndex == -1) {
			System.out.println("Cannot remove location. Location not found: " + locationName);
			return false;
		}

		String[] updatedLocations = new String[maxLocations];

		boolean[][] updatedAdjacencyMatrix = new boolean[maxLocations][maxLocations];

		int newRow = 0;

		for (int oldRow = 0; oldRow < locationCount; oldRow++) {

			if (oldRow == removeIndex) {
				continue;
			}

			updatedLocations[newRow] = locations[oldRow];

			int newColumn = 0;

			for (int oldColumn = 0; oldColumn < locationCount; oldColumn++) {

				if (oldColumn == removeIndex) {
					continue;
				}

				updatedAdjacencyMatrix[newRow][newColumn] = adjacencyMatrix[oldRow][oldColumn];

				newColumn++;
			}

			newRow++;
		}

		locations = updatedLocations;
		adjacencyMatrix = updatedAdjacencyMatrix;
		locationCount--;

		System.out.println("Location and its connections removed: " + locationName);

		return true;
	}
}
