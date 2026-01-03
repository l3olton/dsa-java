## Chapter 15 Exercise 4 (pg. 276)

In the text I demonstrated how to use inorder traversal to print a list of all the book titles. Another way to traverse
a tree is known as preorder traversal. Here is the code for it as applied to our book app:
```java
public class TraverseAndPrint {
    public static <T> void preorderTraversal(TreeNode<T> node) {
        if (node == null) return;
        
        System.out.println(node.getValue());
        preorderTraversal(node.getLeftChild());
        preorderTraversal(node.getRightChild());
    }
}
```
For the example tree in the text (the one with Moby Dick and the other book titles), write out the order in which the
book titles are printed with preorder traversal. As a reminder, here is the example tree as shown in the diagram on
page 277.

```
              "Moby Dick"
            _______|_______
           |               |
        "Great         "Robinson 
     Expectations"       Crusoe"
       ____|____       ____|____
      |         |     |         |
    "Alice    "Lord  "Pride     "The Odyssey"
      in      of the  and
  Wonderland" Flies"  Prejudice"
        

```

Answer:
```
Moby Dick
Great Expectations
Alice in Wonderland
Lord of the Flies
Robinson Crusoe
Pride and Prejudice
The Odyssey
```
