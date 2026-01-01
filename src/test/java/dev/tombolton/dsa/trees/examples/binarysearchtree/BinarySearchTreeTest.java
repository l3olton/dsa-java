package dev.tombolton.dsa.trees.examples.binarysearchtree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void searchShouldReturnCorrectNode() {
        // Arrange
        TreeNode<Integer> rootNode = new TreeNode<>(50);
        BinarySearchTree.insert(27, rootNode);
        BinarySearchTree.insert(72, rootNode);
        BinarySearchTree.insert(48, rootNode);
        BinarySearchTree.insert(6, rootNode);
        BinarySearchTree.insert(84, rootNode);
        BinarySearchTree.insert(53, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         */

        var node48 = rootNode.getLeftChild().getRightChild();

        // Act
        TreeNode<Integer> result = BinarySearchTree.search(48, rootNode);

        // Assert
        assertEquals(node48, result);
    }

    @Test
    public void insertShouldInsertNodeCorrectlyInTree() {
        // Arrange
        TreeNode<Integer> rootNode = new TreeNode<>(50);
        BinarySearchTree.insert(27, rootNode);
        BinarySearchTree.insert(72, rootNode);
        BinarySearchTree.insert(48, rootNode);
        BinarySearchTree.insert(6, rootNode);
        BinarySearchTree.insert(84, rootNode);
        BinarySearchTree.insert(53, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         */

        var node53 = rootNode.getRightChild().getLeftChild();

        // Act
        BinarySearchTree.insert(60, rootNode);
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
        TreeNode<Integer> rootNode = new TreeNode<>(50);
        BinarySearchTree.insert(27, rootNode);
        BinarySearchTree.insert(72, rootNode);
        BinarySearchTree.insert(48, rootNode);
        BinarySearchTree.insert(6, rootNode);
        BinarySearchTree.insert(84, rootNode);
        BinarySearchTree.insert(53, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         */

        var node27 = rootNode.getLeftChild();

        // Act
        BinarySearchTree.delete(6, rootNode);
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
        TreeNode<Integer> rootNode = new TreeNode<>(50);
        BinarySearchTree.insert(27, rootNode);
        BinarySearchTree.insert(72, rootNode);
        BinarySearchTree.insert(48, rootNode);
        BinarySearchTree.insert(6, rootNode);
        BinarySearchTree.insert(84, rootNode);
        BinarySearchTree.insert(53, rootNode);
        BinarySearchTree.insert(4, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         *              /
         *             4
         */

        var node27 = rootNode.getLeftChild();

        // Act
        BinarySearchTree.delete(6, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               4  48 53 84
         */

        // Assert
        assertEquals(4, node27.getLeftChild().getValue());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_rightChild() {
        // Arrange
        TreeNode<Integer> rootNode = new TreeNode<>(50);
        BinarySearchTree.insert(27, rootNode);
        BinarySearchTree.insert(72, rootNode);
        BinarySearchTree.insert(48, rootNode);
        BinarySearchTree.insert(6, rootNode);
        BinarySearchTree.insert(84, rootNode);
        BinarySearchTree.insert(53, rootNode);
        BinarySearchTree.insert(8, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         *                \
         *                 8
         */

        var node27 = rootNode.getLeftChild();

        // Act
        BinarySearchTree.delete(6, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               8  48 53 84
         */

        // Assert
        assertEquals(8, node27.getLeftChild().getValue());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_twoChildren_leftSide() {
        // Arrange
        TreeNode<Integer> rootNode = new TreeNode<>(50);
        BinarySearchTree.insert(27, rootNode);
        BinarySearchTree.insert(72, rootNode);
        BinarySearchTree.insert(48, rootNode);
        BinarySearchTree.insert(6, rootNode);
        BinarySearchTree.insert(84, rootNode);
        BinarySearchTree.insert(53, rootNode);
        BinarySearchTree.insert(4, rootNode);
        BinarySearchTree.insert(8, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         *              / \
         *             4   8
         */

        var node27 = rootNode.getLeftChild();

        // Act
        BinarySearchTree.delete(6, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               8  48 53 84
         *              /
         *             4
         */

        // Assert
        assertEquals(8, rootNode.getLeftChild().getLeftChild().getValue());
        assertEquals(4, rootNode.getLeftChild().getLeftChild().getLeftChild().getValue());
        assertNull(rootNode.getLeftChild().getLeftChild().getRightChild());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_twoChildren_rightSide() {
        // Arrange
        TreeNode<Integer> rootNode = new TreeNode<>(50);
        BinarySearchTree.insert(27, rootNode);
        BinarySearchTree.insert(72, rootNode);
        BinarySearchTree.insert(48, rootNode);
        BinarySearchTree.insert(6, rootNode);
        BinarySearchTree.insert(84, rootNode);
        BinarySearchTree.insert(53, rootNode);
        BinarySearchTree.insert(4, rootNode);
        BinarySearchTree.insert(8, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         *              / \
         *             4   8
         */

        // Act
        BinarySearchTree.delete(72, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   84
         *                / \   /
         *               6  48 53
         *              / \
         *             4   8
         */

        // Assert
        assertEquals(84, rootNode.getRightChild().getValue());
        assertEquals(53, rootNode.getRightChild().getLeftChild().getValue());
        assertNull(rootNode.getRightChild().getRightChild());
    }

    @Test
    public void deleteShouldDeleteNodeFromTree_rootNode() {
        // Arrange
        TreeNode<Integer> rootNode = new TreeNode<>(50);
        BinarySearchTree.insert(27, rootNode);
        BinarySearchTree.insert(72, rootNode);
        BinarySearchTree.insert(48, rootNode);
        BinarySearchTree.insert(6, rootNode);
        BinarySearchTree.insert(84, rootNode);
        BinarySearchTree.insert(53, rootNode);
        BinarySearchTree.insert(4, rootNode);
        BinarySearchTree.insert(8, rootNode);
        /*
         *                   50
         *                  /  \
         *                 27   72
         *                / \   / \
         *               6  48 53 84
         *              / \
         *             4   8
         */

        // Act
        BinarySearchTree.delete(50, rootNode);
        /*
         *                   53
         *                  /  \
         *                 27   72
         *                / \     \
         *               6  48    84
         *              / \
         *             4   8
         */

        // Assert
        assertEquals(53, rootNode.getValue());
        assertNull(rootNode.getRightChild().getLeftChild());
    }
}
