package com.threads.readerWriter.eg2;

/**
 *
 * 5 threads reading and writing on singleton collection.
 *
 * When same monitor is used in MyCollection i.e. either readMonitor or writeMonitor, more time is taken.
 * e.g. output
    Before starting time => 1393161931933
    After completing time => 1393161931933
    Total time taken => 0
    MyCollection reading(). Thread : processor1_thread1, current time : 1393161931934
    MyCollection writing(). Thread : processor1_thread1, current time : 1393161931935
    MyCollection writing(). Thread : processor2_thread2, current time : 1393161931936
    MyCollection writing(). Thread : processor2_thread1, current time : 1393161931937
    MyCollection reading(). Thread : processor2_thread1, current time : 1393161931938
    MyCollection reading(). Thread : processor1_thread3, current time : 1393161931939
    MyCollection writing(). Thread : processor1_thread3, current time : 1393161931940
    MyCollection reading(). Thread : processor1_thread2, current time : 1393161931941
    MyCollection writing(). Thread : processor1_thread2, current time : 1393161931941
     MyCollection reading(). Thread : processor2_thread2, current time : 1393161931942

 *  When different monitors are used on 2 different methods of MyCollections i.e. writeMonitor on write()
 *  and readMonitor on read(), less time is taken.
 *  e.g. output
    Before starting time => 1393161776084
    After completing time => 1393161776085
    Total time taken => 1
    MyCollection reading(). Thread : processor1_thread1, current time : 1393161776086
    MyCollection writing(). Thread : processor2_thread1, current time : 1393161776086
    MyCollection writing(). Thread : processor1_thread1, current time : 1393161776087
    MyCollection reading(). Thread : processor1_thread3, current time : 1393161776088
    MyCollection writing(). Thread : processor2_thread2, current time : 1393161776088
    MyCollection reading(). Thread : processor1_thread2, current time : 1393161776089
    MyCollection writing(). Thread : processor1_thread3, current time : 1393161776089
    MyCollection reading(). Thread : processor2_thread2, current time : 1393161776090
    MyCollection writing(). Thread : processor1_thread2, current time : 1393161776090
    MyCollection reading(). Thread : processor2_thread1, current time : 1393161776091
 *
 */
public class MultiThreadsMultiLocksTest {

    public static void main(String[] args){

        MyCollection myCollection = MyCollection.getInstance();

        Thread reader1 = new Thread(new MyCollectionProcessor1(myCollection));
        Thread reader2 = new Thread(new MyCollectionProcessor1(myCollection));
        Thread reader3 = new Thread(new MyCollectionProcessor1(myCollection));

        Thread writer1 = new Thread(new MyCollectionProcessor2(myCollection));
        Thread writer2 = new Thread(new MyCollectionProcessor2(myCollection));

        reader1.setName("processor1_thread1");
        reader2.setName("processor1_thread2");
        reader3.setName("processor1_thread3");

        writer1.setName("processor2_thread1");
        writer2.setName("processor2_thread2");

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


class MyCollectionProcessor1 implements Runnable{
    MyCollection myCollection;
    public MyCollectionProcessor1(MyCollection myCollection){
        this.myCollection = myCollection;
    }

    @Override
    public void run() {
        myCollection.readCollection(Thread.currentThread().getName());
        myCollection.writeCollection(Thread.currentThread().getName());
    }
}

class MyCollectionProcessor2 implements Runnable{

    MyCollection myCollection;

    public MyCollectionProcessor2(MyCollection myCollection){
        this.myCollection = myCollection;
    }

    @Override
    public void run() {
        myCollection.writeCollection(Thread.currentThread().getName());
        myCollection.readCollection(Thread.currentThread().getName());
    }
}