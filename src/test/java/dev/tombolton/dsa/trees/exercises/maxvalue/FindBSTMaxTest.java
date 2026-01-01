package dev.tombolton.dsa.trees.exercises.maxvalue;

import dev.tombolton.dsa.trees.examples.binarysearchtree.BinarySearchTree;
import dev.tombolton.dsa.trees.examples.binarysearchtree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindBSTMaxTest {

    @Test
    public void findMaxValueInBST() {
        // Arrange
        TreeNode<Integer> rootNode = new TreeNode<>(101);

        BinarySearchTree.insert(123, rootNode);
        BinarySearchTree.insert(64, rootNode);
        BinarySearchTree.insert(60, rootNode);
        BinarySearchTree.insert(77, rootNode);
        BinarySearchTree.insert(110, rootNode);
        BinarySearchTree.insert(146, rootNode);

        /*
         *                   101
         *                  /   \
         *                 64   123
         *                / \   /  \
         *               60  77 110 146
         */

        // Act
        TreeNode<Integer> maxValueNode = FindBSTMax.findMax(rootNode);

        // Assert
        assertEquals(146, maxValueNode.getValue());
    }

    @Test
    public void findMaxValueInSubTree() {
        // Arrange
        TreeNode<Integer> rootNode = new TreeNode<>(101);

        BinarySearchTree.insert(123, rootNode);
        BinarySearchTree.insert(64, rootNode);
        BinarySearchTree.insert(60, rootNode);
        BinarySearchTree.insert(77, rootNode);
        BinarySearchTree.insert(110, rootNode);
        BinarySearchTree.insert(146, rootNode);

        TreeNode<Integer> node64 = rootNode.getLeftChild();

        // Act
        TreeNode<Integer> maxValueNode = FindBSTMax.findMax(node64);

        // Assert
        assertEquals(77, maxValueNode.getValue());
    }
}
