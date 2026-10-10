import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskRunner implements Runnable

 {
    private final int taskId;
    public TaskRunner(int taskId) 

    {
        this.taskId = taskId;
    }
    @Override
    public void run()
    {
        String threadName = Thread.currentThread().getName();

        System.out.println("Task " + taskId + " started by " + threadName);
        try
         {
            Thread.sleep(200);

        } 
        catch (InterruptedException e)
         {
            Thread.currentThread().interrupt();
       }

        System.out.println("Task " + taskId + " completed by " + threadName);
    }
}
public class ThreadPoolRunner
{
    public static void main (String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=1;i<=10;i++)
        {
            executor.submit(new TaskRunner(i));

        }
        executor.shutdown();
        try
        {
            if(!executor.awaitTermination(5,TimeUnit.SECONDS))
            {
                executor.shutdown();

            }
        }  
        catch (InterruptedException e )
        {
            executor.shutdownNow();
            Thread.currentThread().interrupt();

        }

   System.out.println("All tasks completed.");
}

}