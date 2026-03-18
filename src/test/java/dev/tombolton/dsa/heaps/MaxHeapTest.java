package dev.tombolton.dsa.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxHeapTest {

    @Test
    public void shouldInsertItemsOntoHeap() {
        // Arrange
        MaxHeap heap = new MaxHeap();

        // Act
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);

        // Assert
        assertEquals(3, heap.rootNode());
        assertEquals(1, heap.lastNode());
    }
}
