package com.threads.readerWriter.eg2;

/**
 * Singleton class
 */
public class MyCollection {

  private static MyCollection myCollection;

  private static MyCollection readMonitor = new MyCollection();
  private static MyCollection writeMonitor = new MyCollection();

  private MyCollection(){
  }

  public static MyCollection getInstance() {
    if(null == myCollection){
        myCollection = new MyCollection();
    }
    return myCollection;
  }

  public void readCollection(String threadName){
      synchronized (readMonitor){
          // Counter added to get clear difference in time lags, thus thread will be busy for some time.
          int count = 100000;
          while (count > 0){
              count --;
          }
          System.out.println("MyCollection reading(). Thread : " + threadName + ", current time : " + System.currentTimeMillis());
      }
  }

  public void writeCollection(String threadName){
      synchronized (writeMonitor){
          // Counter added to get clear difference in time lags, thus thread will be busy for some time.
          int count = 100000;
          while (count > 0){
              count --;
          }
          System.out.println("MyCollection writing(). Thread : " + threadName + ", current time : " + System.currentTimeMillis());
      }
  }
}
