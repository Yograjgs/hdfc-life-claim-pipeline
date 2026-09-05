## Time and Space Complexity

| Operation / Algorithm               |     Time | Extra Space |
| ----------------------------------- | -------: | ----------: |
| Linked-list `insertAt`              |     O(n) |        O(1) |
| Linked-list `deleteAt`              |     O(n) |        O(1) |
| Reverse — iterative                 |     O(n) |        O(1) |
| Reverse — recursive                 |     O(n) |        O(n) |
| Cycle detection                     |     O(n) |        O(1) |
| Middle element (slow/fast pointers) |     O(n) |        O(1) |
| Add two numbers                     |     O(n) |        O(n) |
| Stack `push`                        |     O(1) |        O(1) |
| Stack `pop`                         |     O(1) |        O(1) |
| Circular queue `enqueue`            |     O(1) |        O(1) |
| Circular queue `dequeue`            |     O(1) |        O(1) |
| BFS                                 | O(V + E) |        O(V) |

A linked-list queue is useful when the queue can grow to millions of entries and its size is unpredictable, because it can grow without requiring a contiguous memory block or resizing.
It also makes enqueue and dequeue operations efficient when implemented with head and tail pointers. 
An array is preferable when fast indexing, cache locality, and predictable memory usage are more important. 
For very large queues, an array-based circular buffer can be especially efficient when a reasonable maximum capacity is known.
