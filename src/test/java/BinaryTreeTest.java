import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {
    BinaryTree<Integer> binaryTree;
    @BeforeEach
    void setUp(){
        binaryTree = new BinaryTree<>();
        initializeTree();
    }

    void initializeTree(){
        binaryTree.add(50);
        binaryTree.add(40);
        binaryTree.add(70);
        binaryTree.add(60);
        binaryTree.add(80);
    }
    @Test
    void addAndTransverseTree(){
        System.out.println("Printing Pre Order Before");
        binaryTree.traverseTree("preorder");
    }
    @Test
    void containsInTree(){
        assertTrue(binaryTree.contains(80));
    }

    @Test
    void removeAndTransverseTree(){
        binaryTree.remove(50);
        System.out.println("Printing Pre Order After");
        binaryTree.traverseTree("preorder");
    }
}
