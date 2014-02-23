package com.threads.readerWriter.eg1;

/**
 */
public class MultiThreadMultiLocksTest {
    public static void main(String[] args){
        Integer monitor = new Integer(2);
        Thread reader = new Thread(new Reader(monitor));
        Thread writer = new Thread(new Writer(monitor));

        writer.start();
        reader.start();

        try{
            reader.join();
            writer.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

class Reader implements Runnable{

    Integer monitor;

    public Reader(Integer monitor){
        this.monitor = monitor;
    }


    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("In MyCollectionProcessor1 thread. Counter : " + i);
            synchronized (monitor){
                if(false == DBConnection.flag){
                    try {
                        System.out.println("MyCollectionProcessor1 thread going to wait");
                        monitor.wait();
                    } catch (InterruptedException e) {
                        System.out.println("In MyCollectionProcessor1 thread exception : " + e.toString());
                    }
                }else{
                    System.out.println("In MyCollectionProcessor1 thread's turn");
                }
                System.out.println("In MyCollectionProcessor1 thread with id : " + Thread.currentThread().getId());
                DBConnection.read();
                DBConnection.flag = false;
                System.out.println("Reading is done. MyCollectionProcessor1 thread going to notify");
                monitor.notify();
            }
        }
    }
}


class Writer implements Runnable{
    Integer monitor;

    public Writer(Integer monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("In MyCollectionProcessor2 thread. Counter : " + i);
            synchronized (monitor){
                if(true == DBConnection.flag){
                    try {
                        System.out.println("In MyCollectionProcessor2 thread. going to wait");
                        monitor.wait();
                    } catch (InterruptedException e) {
                        System.out.println("In MyCollectionProcessor2 thread exception : " + e.toString());
                    }
                }else{
                    System.out.println("In MyCollectionProcessor2 thread's turn");
                }
                System.out.println("In MyCollectionProcessor2 thread with id : " + Thread.currentThread().getId());
                DBConnection.write();
                DBConnection.flag = true;
                System.out.println("Writing is done. MyCollectionProcessor2 is going to notify");
                monitor.notify();
            }
        }
    }
}