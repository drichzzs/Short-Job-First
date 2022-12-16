# Short-Job-First

This code defines a Java class called ShortJobFirst that contains a main method and a jobProcessing method.

The main method first creates an instance of a class called MyQueueLinked, which appears to be a queue data structure implemented using linked lists. It then creates an array of Job objects with some predefined parameters, and adds these Job objects to the readyQ queue using a process that appears to sort the jobs by some criteria before adding them to the queue.

After all the jobs have been added to the queue, the main method enters a loop that dequeues each Job object from the queue, prints some information about it, calls the jobProcessing method on it, and then re-adds the Job object to the queue.

The jobProcessing method takes a Job object as a parameter and sets its status to 1, prints a message indicating the new status, and then waits for 5 seconds (using the Thread.sleep method). After the 5 seconds have passed, it sets the Job object's status to 2.


<img src="https://aldrich.smokyz01.repl.co/a1.png"/>
