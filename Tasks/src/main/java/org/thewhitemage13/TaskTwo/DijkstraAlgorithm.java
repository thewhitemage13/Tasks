package org.thewhitemage13.TaskTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DijkstraAlgorithm {
    static class Edge {
        int to, cost;

        // Represents an edge in the graph with a destination (to) and a cost
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public void dijkstraProcessor() throws IOException {
        // Read the graph data from a resources
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("graph.txt")))) {

            int s = Integer.parseInt(br.readLine()); // Number of test cases

            for (int t = 0; t < s; t++) {
                int n = Integer.parseInt(br.readLine()); // Number of cities

                // Maps to associate city names with indices and vice versa
                Map<String, Integer> cityToIndex = new HashMap<>();
                Map<Integer, String> indexToCity = new HashMap<>();
                Map<Integer, List<Edge>> graph = new HashMap<>(); // Adjacency list for the graph

                // Read each city and its connections
                for (int i = 1; i <= n; i++) {
                    String cityName = br.readLine().trim();
                    cityToIndex.put(cityName, i);
                    indexToCity.put(i, cityName);

                    // Number of neighbors
                    int p = Integer.parseInt(br.readLine());
                    List<Edge> edges = new ArrayList<>();

                    for (int j = 0; j < p; j++) {
                        String[] parts = br.readLine().split(" ");
                        int neighbor = Integer.parseInt(parts[0]); // Neighbor's index
                        int cost = Integer.parseInt(parts[1]); // Cost to reach the neighbor
                        edges.add(new Edge(neighbor, cost));
                    }

                    // Add edges for this city to the graph
                    graph.put(i, edges);
                }

                // Number of routes to calculate
                int r = Integer.parseInt(br.readLine());
                for (int i = 0; i < r; i++) {
                    String[] parts = br.readLine().split(" ");
                    String startCity = parts[0];
                    String endCity = parts[1];

                    // Convert city name to index
                    int start = cityToIndex.get(startCity);
                    int end = cityToIndex.get(endCity);

                    // Calculate the shortest path between start and end using Dijkstra's algorithm
                    int cost = dijkstra(graph, start, end, n);
                    System.out.println(cost); // Output the result
                }

                // Skip an extra line between test cases if present
                if (br.ready()) br.readLine();
            }
        }
    }

    // Implementation of Dijkstra's algorithm to find the shortest path
    private static int dijkstra(Map<Integer, List<Edge>> graph, int start, int end, int n) {
        // Priority queue to store the nodes with their current cost
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] distances = new int[n + 1]; // Distance array to store the shortest path to each node
        Arrays.fill(distances, Integer.MAX_VALUE); // Initialize distances to infinity
        distances[start] = 0;

        // Add the starting node with distance 0
        pq.add(new int[]{0, start});

        while (!pq.isEmpty()) {
            // Get the node with the smallest distance
            int[] current = pq.poll();
            int currentCost = current[0];
            int currentNode = current[1];

            // If we've reached the destination, return the cost
            if (currentNode == end) return currentCost;

            // Skip processing if this is an outdated entry
            if (currentCost > distances[currentNode]) continue;

            // Process all neighbors of the current node
            for (Edge edge : graph.getOrDefault(currentNode, new ArrayList<>())) {
                int newCost = currentCost + edge.cost;

                // Calculate the cost to the neighbor
                if (newCost < distances[edge.to]) { // If the new cost is better, update it
                    distances[edge.to] = newCost;
                    pq.add(new int[]{newCost, edge.to}); // Add the neighbor to the queue
                }
            }
        }
        return -1; // Return -1 if there's no path from start to end
    }
}
