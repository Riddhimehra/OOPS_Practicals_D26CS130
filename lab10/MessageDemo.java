class MessageBuffer{

    public boolean hasData=false;
    public String msg;
    public synchronized void produce(String msg){
        this.msg = msg;
        while(hasData){
            try{
                wait();
            }catch(Exception e){
                System.out.println(e);
            } 
        }
        System.out.println("Producer produced this message:- " + msg);
        hasData = true;
        notify();
    }

    public synchronized void consume(){
        while(!hasData){
            try{
                wait();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println("Consumer consumes this message:- " + msg);
        hasData = false;
        notify();
    }
}

class Producer implements Runnable{

    MessageBuffer msgb;
    String msg;

    Producer(MessageBuffer msgb, String msg){
        this.msgb = msgb;
        this.msg=msg;
    }

    public void run(){
        msgb.produce(msg);
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

class Consumer implements Runnable{
    MessageBuffer msgb;

    Consumer(MessageBuffer msgb){
        this.msgb = msgb;
    }

    public void run(){
        msgb.consume();
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

public class MessageDemo{
    public static void main(String[] args){
        MessageBuffer buffer = new MessageBuffer();
        Producer p = new Producer(buffer, "This is the msg");
        Consumer c = new Consumer(buffer);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}