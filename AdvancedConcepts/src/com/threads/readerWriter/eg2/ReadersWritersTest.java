package com.threads.readerWriter.eg2;

/**
 *
 * 5 threads reading and writing on singleton collection.
 *
 * When same monitor is used in MyCollection i.e. either readMonitor or writeMonitor, more time is taken.
 * e.g. output
    Before starting time => 1393158619628
    After completing time => 1393158619629
    Total time taken => 1
    MyCollection reading(). Thread : reader1, current time : 1393158619629
    MyCollection writing(). Thread : reader1, current time : 1393158619630
    MyCollection writing(). Thread : writer2, current time : 1393158619631
    MyCollection reading(). Thread : writer2, current time : 1393158619632
    MyCollection writing(). Thread : writer1, current time : 1393158619633
    MyCollection reading(). Thread : writer1, current time : 1393158619634
    MyCollection reading(). Thread : reader3, current time : 1393158619635
    MyCollection writing(). Thread : reader3, current time : 1393158619636
    MyCollection reading(). Thread : reader2, current time : 1393158619637
    MyCollection writing(). Thread : reader2, current time : 1393158619638

 *  When different monitors are used on 2 different methods of MyCollections i.e. writeMonitor on write()
 *  and readMonitor on read(), less time is taken.
 *  e.g. output
    Before starting time => 1393158708074
    After completing time => 1393158708075
    Total time taken => 1
    MyCollection reading(). Thread : reader1, current time : 1393158708076
    MyCollection writing(). Thread : writer1, current time : 1393158708077
    MyCollection reading(). Thread : reader3, current time : 1393158708077
    MyCollection writing(). Thread : reader1, current time : 1393158708078
    MyCollection reading(). Thread : reader2, current time : 1393158708078
    MyCollection writing(). Thread : writer2, current time : 1393158708079
    MyCollection reading(). Thread : writer1, current time : 1393158708079
    MyCollection writing(). Thread : reader2, current time : 1393158708080
    MyCollection reading(). Thread : writer2, current time : 1393158708081
    MyCollection writing(). Thread : reader3, current time : 1393158708081
 *
 */
public class ReadersWritersTest {

    public static void main(String[] args){

        MyCollection myCollection = MyCollection.getInstance();

        Thread reader1 = new Thread(new Reader(myCollection));
        Thread reader2 = new Thread(new Reader(myCollection));
        Thread reader3 = new Thread(new Reader(myCollection));

        Thread writer1 = new Thread(new Writer(myCollection));
        Thread writer2 = new Thread(new Writer(myCollection));

        reader1.setName("reader1");
        reader2.setName("reader2");
        reader3.setName("reader3");

        writer1.setName("writer1");
        writer2.setName("writer2");

        try {
            reader1.join();
            reader2.join();
            reader3.join();
            writer1.join();
            writer2.join();
        } catch (InterruptedException e) {
            System.out.println("Main method : exception in join()");
        }

        long startTime = System.currentTimeMillis();
        System.out.println("Before starting time => " +startTime);

        reader1.start();
        reader2.start();
        reader3.start();

        writer1.start();
        writer2.start();

        long endTime = System.currentTimeMillis();
        System.out.println("After completing time => " +endTime);
        System.out.println("Total time taken => " + (endTime - startTime));

    }
}


class Reader implements Runnable{
    MyCollection myCollection;
    public Reader(MyCollection myCollection){
        this.myCollection = myCollection;
    }

    @Override
    public void run() {
        myCollection.readCollection(Thread.currentThread().getName());
        myCollection.writeCollection(Thread.currentThread().getName());
    }
}

class Writer implements Runnable{

    MyCollection myCollection;

    public Writer (MyCollection myCollection){
        this.myCollection = myCollection;
    }

    @Override
    public void run() {
        myCollection.writeCollection(Thread.currentThread().getName());
        myCollection.readCollection(Thread.currentThread().getName());
    }
}