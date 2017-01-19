package yieldtest;

public class MyYieldThread implements Runnable {

	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
			for(int i=0; i<10; i++){
				if(i==5){
					System.out.println("현재 Thread : " + Thread.currentThread().getName() + "yield 발생");
					Thread.yield();
				}
				System.out.println("현재 i값은 : " + i + "," + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			System.out.println(e);
			}
		
	}

	
}
