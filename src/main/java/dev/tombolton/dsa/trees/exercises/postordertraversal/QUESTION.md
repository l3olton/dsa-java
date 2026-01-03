## Chapter 15 Exercise 5 (pg. 277)

There is yet another form of traversal called postorder traversal. Here is the code as applied to our book app.
```java
public class TraverseAndPrint {
    public static <T> void postorderTraversal(TreeNode<T> node) {
        if (node == null) return;
        
        preorderTraversal(node.getLeftChild());
        preorderTraversal(node.getRightChild());
        System.out.println(node.getValue());
    }
}
```
For the example tree in the text (which also appears in the previous exercise), write out the order in which the
book titles are printed with postorder traversal

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
Alice in Wonderland
Lord of the Flies
Great Expectations
Pride and Prejudice
The Odyssey
Robinson Crusoe
Moby Dick
```
