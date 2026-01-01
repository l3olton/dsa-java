## Chapter 15 Exercise 2 (pg. 276)

If a well-balanced binary search tree contains 1,000 values, what is the maximum number of steps it would take to searh for a value within it?

Answer:

Search in a balanced binary search tree is `O(logN)` so search would take around 10 steps:

```
1 1000/2 = 500
2 500/2 = 250
3 250/2 = 125
4 125/2 = 62.5
5 62/2 = 31
6 31/2 = 15.5
7 15/2 = 7.5
8 7/2 = 3.5
9 3/2 = 1.5
10 1/2 = 0.5
```
