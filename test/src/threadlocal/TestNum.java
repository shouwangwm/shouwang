package threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class TestNum {
	
		private AtomicInteger count = new AtomicInteger(0);
		
		public int getNextNum() {
			return count.getAndIncrement();
		}

		public static void main(String[] args) {
			TestNum sn = new TestNum();
			//3个线程共享sn，但增加的是同一个序列号
			TestClient t1 = new TestClient(sn);
			TestClient t2 = new TestClient(sn);
			TestClient t3 = new TestClient(sn);
			t1.start();
			t2.start();
			t3.start();
		}

		private static class TestClient extends Thread {  
	        private TestNum sn;  
	  
	        public TestClient(TestNum sn) {  
	            this.sn = sn;  
	        }  
	  
	        public void run() {  
	            for (int i = 0; i < 3; i++) {  
	                // ④每个线程打出3个序列值  
	                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["  
	                         + sn.getNextNum() + "]");  
	            }  
	        }  
		}  
}