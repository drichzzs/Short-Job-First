package my.exercises.shortjob;

public class ShortJobFirst{

    public static void jobProcessing(Job job) throws InterruptedException {
        job.setStatus(1);
        System.out.println("Status is "+job.getStatus());
        Thread.sleep(5000);
        job.setStatus(2);
    }
    public static void main(String[] args) throws InterruptedException {
        MyQueueLinked readyQ = new MyQueueLinked();
        System.out.println("Creating Jobs");
        Job[] jobs = {
                new Job(1, 2,5,0),
                new Job(3, 7,5,1),
                new Job(6, 1,5,2),
                new Job(8, 2,5,3),
                new Job(1, 6,5,4)
        };

        Thread.sleep(1000);
        System.out.println("Creating a ready queue.");
        for(Job job:jobs){
            job.setStatus(0);
            MyQueueLinked greaterJobs = new MyQueueLinked();
            int currentQLen = readyQ.size();
            while(!readyQ.isEmpty() && currentQLen != 0){
                Job currentJob = (Job) readyQ.dequeue();
                if(currentJob.compareTo(job) > 0)
                    greaterJobs.enqueue(currentJob);
                else
                    readyQ.enqueue(currentJob);
                currentQLen--;
            }
            readyQ.enqueue(job);
            while(!greaterJobs.isEmpty()){
                readyQ.enqueue(greaterJobs.dequeue());
            }
            greaterJobs = null;
        }
        System.out.println("Ready Queue is done.");
        Thread.sleep(1000);
        int len = readyQ.size();

        System.out.println("=====================================================================================");
        while(!readyQ.isEmpty() && len !=0){
            Job job = (Job) readyQ.dequeue();
            System.out.println("Job | ID: "+job.getJobSize()+" | Size: "+job.getJobSize());
            System.out.println("Status is "+job.getStatus());
            Thread.sleep(1000);
            jobProcessing(job);
            System.out.println("Status is "+job.getStatus());
            readyQ.enqueue(job);
            Thread.sleep(1000);
            System.out.println("=====================================================================================");
            len--;
        }


    }

}
