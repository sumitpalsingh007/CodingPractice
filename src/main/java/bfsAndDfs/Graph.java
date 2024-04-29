package bfsAndDfs;

import java.io.*;
import java.util.*;


/**
 * The Graph class represents an undirected graph using an adjacency list representation.
 */
public class Graph {
    private int V; // number of vertices
    private List<Integer>[] adjList; // adjacency list representation

    /**
     * Constructs a graph with the specified number of vertices.
     *
     * @param V the number of vertices in the graph
     */
    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList[V + 1]; // +1 to handle 1-based indexing
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    /**
     * Adds an edge between vertices u and v in the graph.
     * It is an undirected graph, so the edge is added in both directions.
     *
     * @param u one vertex of the edge
     * @param v the other vertex of the edge
     */
    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u);
    }

    /**
     * Performs breadth-first search (BFS) traversal starting from the specified start node.
     * Writes the output to the specified PrintWriter.
     *
     * @param start  the starting node for BFS traversal
     * @param writer the PrintWriter to write the output
     */
    public void BFS(int start, PrintWriter writer) {
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        writer.println("BFS:");
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int node = queue.poll();
              
                // Process the current node
                // Here, we print the visited edges
                for (int neighbor : adjList[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                        writer.println(node + " " + neighbor); 
                    }
                }
            }
        }
    }
    /**
     * Performs depth-first search (DFS) traversal starting from the specified start node.
     * Writes the output to the specified PrintWriter.
     *
     * @param start  the starting node for DFS traversal
     * @param writer the PrintWriter to write the output
     */
    public void DFS(int start, PrintWriter writer) {
        boolean[] visited = new boolean[V + 1];
        writer.println("DFS:");
        DFSUtil(start, visited, writer);
        writer.println();
    }

    /**
     * Utility function for DFS traversal.
     *
     * @param node    the current node
     * @param visited array to track visited nodes
     * @param writer  the PrintWriter to write the output
     */
    private void DFSUtil(int node, boolean[] visited, PrintWriter writer) {
        visited[node] = true;
        
        // Process the current node
        // Here, we print the visited edges
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                writer.println(node + " " + neighbor);
                DFSUtil(neighbor, visited, writer);
            }
        }
    }
    /**
     * Main method to read the input file, construct the graph, and perform BFS and DFS.
     *
     * @param args command-line arguments
     *             Option 1: java Graph <input file name> <number of nodes> <starting node> <output file name>
     *             Option 2: java Graph --help
     * @throws FileNotFoundException if the input file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0 && args[0].equals("--help")) {
            System.out.println("Option 1: java Graph <input file name> <number of nodes> <starting node> <output file name>");
            System.out.println("Option 2: java Graph --help");
            return;
        }

        if (args.length < 4) {
            System.out.println("Insufficient arguments provided. Use 'java Graph --help' to see the correct usage.");
            return;
        }

        String inputFile = args[0];
        int numNodes = Integer.parseInt(args[1]);
        int startNode = Integer.parseInt(args[2]);
        String outputFile = args[3];

        Graph graph = new Graph(numNodes);
        try (Scanner scanner = new Scanner(new File(inputFile));
             PrintWriter writer = new PrintWriter(new File(outputFile))) {

            // Read the input file and construct the graph
            while (scanner.hasNextInt()) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph.addEdge(u, v);
            }

            // Perform BFS and DFS traversals
            graph.BFS(startNode, writer);
            graph.DFS(startNode, writer);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        }
    }

}