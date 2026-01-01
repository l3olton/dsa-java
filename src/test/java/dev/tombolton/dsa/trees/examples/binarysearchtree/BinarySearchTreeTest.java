package dev.tombolton.dsa.trees.examples.binarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinarySearchTreeTest {
    @Test
    public void searchShouldReturnCorrectNode() {
        // Arrange
        TreeNode<Integer> node72 = new TreeNode<>(72);
        TreeNode<Integer> node48 = new TreeNode<>(48);
        TreeNode<Integer> node84 = new TreeNode<>(84);
        TreeNode<Integer> node53 = new TreeNode<>(53);
        TreeNode<Integer> node27 = new TreeNode<>(27);
        TreeNode<Integer> node6 = new TreeNode<>(6);

        node72.setRightChild(node84);
        node72.setLeftChild(node53);

        node27.setRightChild(node48);
        node27.setLeftChild(node6);

        TreeNode<Integer> root = new TreeNode<>(50, node27, node72);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         */

        // Act
        TreeNode<Integer> result = BinarySearchTree.search(48, root);

        // Assert
        assertEquals(node48, result);
    }

    @Test
    public void insertShouldInsertNodeCorrectlyInTree() {
        // Arrange
        TreeNode<Integer> node72 = new TreeNode<>(72);
        TreeNode<Integer> node48 = new TreeNode<>(48);
        TreeNode<Integer> node84 = new TreeNode<>(84);
        TreeNode<Integer> node53 = new TreeNode<>(53);
        TreeNode<Integer> node27 = new TreeNode<>(27);
        TreeNode<Integer> node6 = new TreeNode<>(6);

        node72.setRightChild(node84);
        node72.setLeftChild(node53);

        node27.setRightChild(node48);
        node27.setLeftChild(node6);

        TreeNode<Integer> root = new TreeNode<>(50, node27, node72);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         */

        // Act
        BinarySearchTree.insert(60, root);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         *                      \
         *                      60
         */

        // Assert
        assertEquals(60, node53.getRightChild().getValue());
    }

    @Test
    public void insertShouldDoNothingIfElementExistsInTree() {
        // Arrange
        TreeNode<Integer> node72 = new TreeNode<>(72);
        TreeNode<Integer> node48 = new TreeNode<>(48);
        TreeNode<Integer> node84 = new TreeNode<>(84);
        TreeNode<Integer> node53 = new TreeNode<>(53);
        TreeNode<Integer> node27 = new TreeNode<>(27);
        TreeNode<Integer> node6 = new TreeNode<>(6);

        node72.setRightChild(node84);
        node72.setLeftChild(node53);

        node27.setRightChild(node48);
        node27.setLeftChild(node6);

        TreeNode<Integer> root = new TreeNode<>(50, node27, node72);

        // Act
        BinarySearchTree.insert(84, root);

        // Assert
        assertNull(node6.getLeftChild());
        assertNull(node6.getRightChild());
        assertNull(node48.getLeftChild());
        assertNull(node48.getRightChild());
        assertNull(node53.getLeftChild());
        assertNull(node53.getRightChild());
        assertNull(node84.getLeftChild());
        assertNull(node84.getRightChild());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_noChildren() {
        // Arrange
        TreeNode<Integer> node72 = new TreeNode<>(72);
        TreeNode<Integer> node48 = new TreeNode<>(48);
        TreeNode<Integer> node84 = new TreeNode<>(84);
        TreeNode<Integer> node53 = new TreeNode<>(53);
        TreeNode<Integer> node27 = new TreeNode<>(27);
        TreeNode<Integer> node6 = new TreeNode<>(6);

        node72.setRightChild(node84);
        node72.setLeftChild(node53);

        node27.setRightChild(node48);
        node27.setLeftChild(node6);

        TreeNode<Integer> root = new TreeNode<>(50, node27, node72);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         */

        // Act
        BinarySearchTree.delete(6, root);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                  \   / \
         *                  48 53 84
         */

        // Assert
        assertNull(node27.getLeftChild());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_leftChild() {
        // Arrange
        TreeNode<Integer> node72 = new TreeNode<>(72);
        TreeNode<Integer> node48 = new TreeNode<>(48);
        TreeNode<Integer> node84 = new TreeNode<>(84);
        TreeNode<Integer> node53 = new TreeNode<>(53);
        TreeNode<Integer> node27 = new TreeNode<>(27);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node4 = new TreeNode<>(4);

        node72.setRightChild(node84);
        node72.setLeftChild(node53);

        node27.setRightChild(node48);
        node27.setLeftChild(node6);

        node6.setLeftChild(node4);

        TreeNode<Integer> root = new TreeNode<>(50, node27, node72);

        // Act
        BinarySearchTree.delete(6, root);

        // Assert
        assertEquals(4, node27.getLeftChild().getValue());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_rightChild() {
        // Arrange
        TreeNode<Integer> node72 = new TreeNode<>(72);
        TreeNode<Integer> node48 = new TreeNode<>(48);
        TreeNode<Integer> node84 = new TreeNode<>(84);
        TreeNode<Integer> node53 = new TreeNode<>(53);
        TreeNode<Integer> node27 = new TreeNode<>(27);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node8 = new TreeNode<>(8);

        node72.setRightChild(node84);
        node72.setLeftChild(node53);

        node27.setRightChild(node48);
        node27.setLeftChild(node6);

        node6.setRightChild(node8);

        TreeNode<Integer> root = new TreeNode<>(50, node27, node72);

        // Act
        BinarySearchTree.delete(6, root);

        // Assert
        assertEquals(8, node27.getLeftChild().getValue());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_twoChildren_leftSide() {
        // Arrange
        TreeNode<Integer> node72 = new TreeNode<>(72);
        TreeNode<Integer> node48 = new TreeNode<>(48);
        TreeNode<Integer> node84 = new TreeNode<>(84);
        TreeNode<Integer> node53 = new TreeNode<>(53);
        TreeNode<Integer> node27 = new TreeNode<>(27);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node8 = new TreeNode<>(8);

        node72.setRightChild(node84);
        node72.setLeftChild(node53);

        node27.setRightChild(node48);
        node27.setLeftChild(node6);

        node6.setLeftChild(node4);
        node6.setRightChild(node8);

        TreeNode<Integer> root = new TreeNode<>(50, node27, node72);

        // Act
        BinarySearchTree.delete(6, root);

        // Assert
        assertEquals(8, node27.getLeftChild().getValue());
        assertNull(node8.getLeftChild());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_twoChildren_rightSide() {
        // Arrange
        TreeNode<Integer> node72 = new TreeNode<>(72);
        TreeNode<Integer> node48 = new TreeNode<>(48);
        TreeNode<Integer> node84 = new TreeNode<>(84);
        TreeNode<Integer> node53 = new TreeNode<>(53);
        TreeNode<Integer> node27 = new TreeNode<>(27);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node8 = new TreeNode<>(8);

        node72.setRightChild(node84);
        node72.setLeftChild(node53);

        node27.setRightChild(node48);
        node27.setLeftChild(node6);

        node6.setLeftChild(node4);
        node6.setRightChild(node8);

        TreeNode<Integer> root = new TreeNode<>(50, node27, node72);

        // Act
        BinarySearchTree.delete(72, root);

        // Assert
        assertEquals(84, root.getRightChild().getValue());
        assertEquals(53, root.getRightChild().getLeftChild().getValue());
        assertNull(root.getRightChild().getRightChild());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_rootNode() {
        // Arrange
        TreeNode<Integer> node72 = new TreeNode<>(72);
        TreeNode<Integer> node48 = new TreeNode<>(48);
        TreeNode<Integer> node84 = new TreeNode<>(84);
        TreeNode<Integer> node53 = new TreeNode<>(53);
        TreeNode<Integer> node27 = new TreeNode<>(27);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node8 = new TreeNode<>(8);

        node72.setRightChild(node84);
        node72.setLeftChild(node53);

        node27.setRightChild(node48);
        node27.setLeftChild(node6);

        node6.setLeftChild(node4);
        node6.setRightChild(node8);

        TreeNode<Integer> root = new TreeNode<>(50, node27, node72);

        // Act
        BinarySearchTree.delete(50, root);

        // Assert
        assertEquals(53, root.getValue());
        assertNull(node72.getLeftChild());
    }
}
