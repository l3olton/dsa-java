package dev.tombolton.dsa.heaps;

import java.util.ArrayList;
import java.util.List;

// not making generic, just handling Integer
public class MaxHeap {

    private final List<Integer> data = new ArrayList<>();

    public Integer rootNode() {
        return data.getFirst();
    }

    public Integer lastNode() {
        return data.getLast();
    }

    public Integer getLeftChildIndex(int index) {
        return data.get((index * 2) + 1);
    }

    public Integer getRightChildIndex(int index) {
        return data.get((index * 2) + 2);
    }

    public Integer parentIndex(int index) {
        return data.get((index - 1) / 2);
    }

    public void insert(Integer value) {
        data.addLast(value);

        int currentIndex = data.size() - 1;

        while (
            currentIndex > 0 &&
            data.get(currentIndex) > data.get(parentIndex(currentIndex))
        ) {
            int parentIndex = parentIndex(currentIndex);
            Integer parentVal = data.get(parentIndex);

            data.set(parentIndex, data.get(currentIndex));
            data.set(currentIndex, parentVal);

            currentIndex = parentIndex;
        }
    }
}
