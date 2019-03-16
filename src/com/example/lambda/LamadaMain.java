package com.example.lambda;

import java.util.function.Supplier;

public class LamadaMain {

  public static void main(String[] args) {
	  Integer i = new Integer(10);
	Supplier<Integer> supplier = () -> 10;
	//输出10
	System.out.println(supplier.get());
	System.out.println("Hello Word");
    
  }
}