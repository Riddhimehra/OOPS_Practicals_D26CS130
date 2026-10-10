public class CounterRace{
    public static void main(String[] args){
        Counter c =  new Counter();
        Thread t1 = new Thread(c , "One");
        Thread t2 = new Thread(c , "Two");
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            
        }
        System.out.println("Total Count:- "  + c.getCount());

    }
}

class Counter implements Runnable{
   public  int count;
    synchronized public void increment(){
        count++;
    }
    public void run(){
        for(int i=0 ; i<50000 ; i++){
            increment();
        }
    }

    public int getCount(){
        return count;
    }
}