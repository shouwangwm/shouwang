package test;

import java.util.concurrent.atomic.AtomicInteger;

public class Automic {
	
	public static void main(String[] args) {
		
		AtomicInteger in = new AtomicInteger(1);
		System.out.println(in.getAndIncrement());
		System.out.println(in.getAndIncrement());
		System.out.println(in.getAndIncrement());
	}
}
