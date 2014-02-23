package com.threads.readerWriter.eg1;

/**
 */
public class ReaderWriterTest {
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
            System.out.println("In Reader thread. Counter : " + i);
            synchronized (monitor){
                if(false == DBConnection.flag){
                    try {
                        System.out.println("Reader thread going to wait");
                        monitor.wait();
                    } catch (InterruptedException e) {
                        System.out.println("In Reader thread exception : " + e.toString());
                    }
                }else{
                    System.out.println("In Reader thread's turn");
                }
                System.out.println("In Reader thread with id : " + Thread.currentThread().getId());
                DBConnection.read();
                DBConnection.flag = false;
                System.out.println("Reading is done. Reader thread going to notify");
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
            System.out.println("In Writer thread. Counter : " + i);
            synchronized (monitor){
                if(true == DBConnection.flag){
                    try {
                        System.out.println("In Writer thread. going to wait");
                        monitor.wait();
                    } catch (InterruptedException e) {
                        System.out.println("In Writer thread exception : " + e.toString());
                    }
                }else{
                    System.out.println("In Writer thread's turn");
                }
                System.out.println("In Writer thread with id : " + Thread.currentThread().getId());
                DBConnection.write();
                DBConnection.flag = true;
                System.out.println("Writing is done. Writer is going to notify");
                monitor.notify();
            }
        }
    }
}