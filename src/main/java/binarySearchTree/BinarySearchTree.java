package binarySearchTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Entry class represents an entry with a name and count.
 */
class Entry {
    String name;
    int count;

    /**
     * Constructor to initialize the name and count of an entry.
     * 
     * @param name  The name of the entry.
     * @param count The count associated with the entry.
     */
    Entry(String name, int count) {
        this.name = name;
        this.count = count;
    }
}

/**
 * Node class represents a node in the binary search tree.
 */
class Node {
    Entry entry;
    Node left;
    Node right;

    /**
     * Constructor to create a node with an entry.
     * 
     * @param entry The entry associated with the node.
     */
    Node(Entry entry) {
        this.entry = entry;
        left = null;
        right = null;
    }
}


/**
 * BinarySearchTree class represents a binary search tree data structure.
 * It stores Entry objects, where each Entry consists of a name and count.
 * The tree is not balanced and supports basic operations like adding, searching, and deleting entries.
 */
public class BinarySearchTree {
    private Node root;

    /**
     * Constructor to create an empty BinarySearchTree.
     */
    public BinarySearchTree() {
        root = null;
    }


    /**
     * Adds an entry to the binary search tree.
     * If an entry with the same name already exists, it updates the count.
     *
     * @param entry The entry to be added or updated.
     */
    public void add(Entry entry) {
        if (root == null) {
            // If the tree is empty, create a new node as the root.
            root = new Node(entry);
            return;
        }

        Node current = root;
        Node parent;

        while (true) {
            parent = current;
            int cmp = entry.name.compareTo(current.entry.name);

            if (cmp < 0) {
                // If the entry's name is less than the current node's name, move to the left child.
                current = current.left;
                if (current == null) {
                    // If the left child is null, create a new node and attach it as the left child of the parent.
                    parent.left = new Node(entry);
                    return;
                }
            } else if (cmp > 0) {
                // If the entry's name is greater than the current node's name, move to the right child.
                current = current.right;
                if (current == null) {
                    // If the right child is null, create a new node and attach it as the right child of the parent.
                    parent.right = new Node(entry);
                    return;
                }
            } else {
                // If the entry's name is the same as the current node's name, update the count.
                current.entry.count = entry.count;
                return;
            }
        }
    }


/**
 * Searches for an entry in the binary search tree by name.
 * 
 * @param name The name of the entry to search for.
 * @return The found entry if it exists, or null if not found.
 */
public Entry search(String name) {
    Node current = root;
    while (current != null) {
        int cmp = name.compareTo(current.entry.name);
        if (cmp < 0) {
            // If the name is less than the current node's name, move to the left child.
            current = current.left;
        } else if (cmp > 0) {
            // If the name is greater than the current node's name, move to the right child.
            current = current.right;
        } else {
            // If the name is the same as the current node's name, return the entry.
            return current.entry;
        }
    }
    // If the name is not found, return null.
    return null;
}
/**
 * Deletes an entry from the binary search tree by name.
 * 
 * @param name The name of the entry to delete.
 * @return true if the entry is successfully deleted, false if it is not found.
 */
public boolean delete(String name) {
    Node parent = null;
    Node current = root;
    boolean isLeftChild = false;

    while (current != null) {
        int cmp = name.compareTo(current.entry.name);
        if (cmp < 0) {
            // If the name is less than the current node's name, move to the left child.
            parent = current;
            current = current.left;
            isLeftChild = true;
        } else if (cmp > 0) {
            // If the name is greater than the current node's name, move to the right child.
            parent = current;
            current = current.right;
            isLeftChild = false;
        } else {
            // If the name is found, perform deletion based on different cases.
            if (current.left == null && current.right == null) {
                // Case 1: Node to be deleted is a leaf node
                if (parent == null) {
                    // If the node is the root, set the root to null.
                    root = null;
                } else if (isLeftChild) {
                    // If the node is a left child, set the parent's left child to null.
                    parent.left = null;
                } else {
                    // If the node is a right child, set the parent's right child to null.
                    parent.right = null;
                }
            } else if (current.left == null) {
                // Case 2: Node to be deleted has only a right child
                if (parent == null) {
                    // If the node is the root, set the root to the right child.
                    root = current.right;
                } else if (isLeftChild) {
                    // If the node is a left child, set the parent's left child to the right child.
                    parent.left = current.right;
                } else {
                    // If the node is a right child, set the parent's right child to the right child.
                    parent.right = current.right;
                }
            } else if (current.right == null) {
                // Case 2: Node to be deleted has only a left child
                if (parent == null) {
                    // If the node is the root, set the root to the left child.
                    root = current.left;
                } else if (isLeftChild) {
                    // If the node is a left child, set the parent's left child to the left child.
                    parent.left = current.left;
                } else {
                    // If the node is a right child, set the parent's right child to the left child.
                    parent.right = current.left;
                }
            } else {
                // Case 3: Node to be deleted has both left and right children
                Node successorParent = current;
                Node successor = current.right;
                while (successor.left != null) {
                    // Find the leftmost node in the right subtree as the successor.
                    successorParent = successor;
                    successor = successor.left;
                }

                if (successorParent != current) {
                    // If the successor is not the right child of the node to be deleted,
                    // update the successor's parent's left child.
                    successorParent.left = successor.right;
                } else {
                    // If the successor is the right child of the node to be deleted,
                    // update the successor's parent's right child.
                    successorParent.right = successor.right;
                }

               
                // Replace the entry of the node to be deleted with the successor's entry.
                current.entry = successor.entry;
            }

            return true; // Entry successfully deleted.
        }
    }

    return false; // Entry not found.
}

    
    /**
     * Retrieves the depth of a node with the given name in the binary search tree.
     * The depth represents the number of edges from the root to the node.
     *
     * @param name The name to search for.
     * @return The depth of the node with the given name, or -1 if the node is not found.
     */
    public int getDepth(String name) {
        Node current = root;
        int depth = 1;

        while (current != null) {
            int cmp = name.compareTo(current.entry.name);
            if (cmp == 0) {
                // If the name matches the current node's name, return the current depth.
                return depth;
            } else if (cmp < 0) {
                // If the name is less than the current node's name, move to the left child.
                current = current.left;
            } else {
                // If the name is greater than the current node's name, move to the right child.
                current = current.right;
            }
            depth++; // Increment the depth for each level traversed.
        }

        return -1; // Node not found, return -1 to indicate the absence of the node.
    }
    /**
     * The main method of the BinarySearchTree program.
     * It reads commands from an input file, performs operations on the binary search tree,
     * and writes the results to an output file.
     *
     * @param args The command-line arguments specifying the input file name and output file name.
     */
    public static void main(String[] args) {
        // Check if the input arguments are provided correctly
        if (args.length < 2) {
            System.out.println("Usage: java BinarySearchTree <input file name> <output file name>");
            return;
        }

        // Retrieve the input file name and output file name from the command-line arguments
        String inputFile = args[0];
        String outputFile = args[1];

        // Create a new instance of the BinarySearchTree
        BinarySearchTree bst = new BinarySearchTree();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into tokens based on space delimiter
                String[] tokens = line.split(" ");
                String command = tokens[0];

                if (command.equals("ADD")) {
                    // Parse the entry details from the tokens
                    String[] entryTokens = tokens[1].split(",");
                    String name = entryTokens[0];
                    int count = Integer.parseInt(entryTokens[1]);
                    Entry entry = new Entry(name, count);

                    // Add the entry to the binary search tree
                    bst.add(entry);

                    // Get the depth of the added entry
                    int depth = bst.getDepth(name);

                    // Write the result to the output file
                    writer.write("Added (" + name + "," + count + ") at depth " + depth + ".\n");
                } else if (command.equals("SEARCH")) {
                    // Retrieve the name to search from the tokens
                    String name = tokens[1];

                    // Search for the entry in the binary search tree
                    Entry entry = bst.search(name);

                    if (entry != null) {
                        // If the entry is found, get its depth
                        int depth = bst.getDepth(name);

                        // Write the result to the output file
                        writer.write("Found (" + name + "," + entry.count + ") at depth " + depth + ".\n");
                    } else {
                        // If the entry is not found, write the result to the output file
                        writer.write("Not found: " + name + ".\n");
                    }
                } else if (command.equals("DELETE")) {
                    // Retrieve the name to delete from the tokens
                    String name = tokens[1];

                    // Search for the entry in the binary search tree
                    Entry entry = bst.search(name);

                    // Delete the entry from the binary search tree
                    boolean deleted = bst.delete(name);

                    if (deleted) {
                        // If the entry is deleted successfully, write the result to the output file
                        writer.write("Deleted (" + name + "," + entry.count + ").\n");
                    } else {
                        // If the entry cannot be deleted, write the result to the output file
                        writer.write("Cannot delete: " + name + ".\n");
                    }
                }
            }
        } catch (IOException e) {
            // Handle any IOException that occurs during file operations
            System.out.println("Error: " + e.getMessage());
        }
    }

}
