#Day 1

##exercise 1

* I used Thread.join to sync thread execution and volatile keyword for terminate property in third task.
* I used volatile to prevent caching of Task3.terminate, because I was setting it from main thread, which is outside of the thread it was running in.

##exercise 2

* Yes I'm able to provoke the error
* Depends on number of iterations in the Task for loop, but it's 9/10 times with 1e3 iterations
* I synchronized the programme by adding synchronized keyword to Even.next() method
* My solution is correct, because by using synchronized keyword the Even.next() method is locked by the current executing and inaccessible for all other threads. This makes the next method atomic and therefore there is no way it can return an odd number. It was happening, because the same local variables in the method were using by 2 threads at the same time.

##turnstiles

* No I don't get the right result
* The problem is that the TurnslideCounter.incr() is not atomic. I fixed this using synchornized keyword

##producer consumer

* **When and why will we use Threads in our programs?:**
  * When we need to put expensive calculations to be computed in parallel, so the rest of the application isn't blocked by it, or when we want to schedule some tasks.
* **What is the Race Condition Problem and how can you solve it?**
  * A race condition occurs when two or more threads can access shared data and they try to change it at the same time.
  * We can solve it by locking the operations on the shared data or making them atomic
* **Explain the Producer/Consumer-problem and how to solve it in modern Java Programs**
  * When we have a producer task producing some data that is used by consumer task. The problem is that consumer can ask for data that isn't yet available. To solve this in Java we use BlockingQueue, that handles the waiting process of consumer task when data is not yet available.
* **Explain what Busy Waiting is and why it's a bad thing in a modern software system.**
  * When a process repeatedly checks for a condition
  * It is expensive for CPU
* **Describe Java's BlockingQueue interface...**
  * BlockingQueue represents a queue which is thread safe to put into, and take instances from.
  * implementations:
    * ArrayBlockingQueue - bounded queue (can store only limited number of elements), that stores elements as array 
    * LinkedBlockingQueue - keeps the elements internally in a linked structure (one element references the other)
  * methods relevant for producer/consumer problem:
    * poll - Retrieves and removes head element from the queue, can be set to wait for a time for the element to be available, returns null if queue is empty
    * take - retrieves and removes head element, waits if necessary for element to be available
    * put - inserts element to queue, waits if necessary for space in the queue