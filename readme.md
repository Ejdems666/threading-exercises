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