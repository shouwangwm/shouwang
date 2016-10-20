package threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class TestNum {
	
		private AtomicInteger count = new AtomicInteger(0);
		
		public int getNextNum() {
			return count.getAndIncrement();
		}

		public static void main(String[] args) {
			TestNum sn = new TestNum();
			//3���̹߳���sn�������ӵ���ͬһ�����к�
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
	                // ��ÿ���̴߳��3������ֵ  
	                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["  
	                         + sn.getNextNum() + "]");  
	            }  
	        }  
		}  
}