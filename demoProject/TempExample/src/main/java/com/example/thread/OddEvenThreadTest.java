package com.example.thread;

public class OddEvenThreadTest {
	   public static void main(String[] args) {
	      CubbyHole c = new CubbyHole();
	      EvenThread p1 = new EvenThread(c, 1);
	      OddThread c1 = new OddThread(c, 1);
	      p1.start(); 
	      c1.start();
	   }
	}
	class CubbyHole {
	   private int contents;
	   private boolean isEven = false;
	   public synchronized int get() {
	      while (isEven == false) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) {
	         }
	      }
	      isEven = false;
	      notifyAll();
	      return contents;
	   }
	   public synchronized void put(int value) {
	      while (isEven == true) {
	         try {
	            wait();
	         }
	         catch (InterruptedException e) { 
	         } 
	      }
	      contents = value;
	      isEven = true;
	      notifyAll();
	   }
	}

	class OddThread extends Thread {
	   private CubbyHole cubbyhole;
	   private int number;
	   public OddThread(CubbyHole c, int number) {
	      cubbyhole = c;
	      this.number = number;
	   }
	   public void run() {
	      int value = 0;
	         for (int i = 0; i < 10; i++) {
	            value = cubbyhole.get();
	            System.out.println("OddThread #" 
				+ this.number
	+ " got: " + value);
	}
	}
	}

	class EvenThread extends Thread {
	private CubbyHole cubbyhole;
	private int number;

	public EvenThread(CubbyHole c, int number) {
	cubbyhole = c;
	this.number = number;
	}

	public void run() {
	for (int i = 0; i < 10; i++) {
	cubbyhole.put(i);
	System.out.println("EvenThread #" + this.number
	+ " put: " + i);
	try {
	sleep((int)(Math.random() * 100));
	} catch (InterruptedException e) { }
	}
	}
	}