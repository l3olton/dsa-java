package dev.tombolton.dsa.trees.exercises.maxvalue;

import dev.tombolton.dsa.trees.examples.binarysearchtree.TreeNode;

public class FindBSTMax {

    public static <T> TreeNode<T> findMax(TreeNode<T> node) {
        if (node.getRightChild() == null) return node;
        return findMax(node.getRightChild());
    }
}
