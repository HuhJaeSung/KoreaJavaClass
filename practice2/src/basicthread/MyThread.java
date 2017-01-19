package basicthread;

// 이 방식은 상속을 받았기 때문에 우리 class( MyThread) 의 사용이 많이 제약된다.
public class MyThread implements Runnable {

	@Override
	public void run() {
					
				for(int i=0; i<10; i++){
					System.out.println("현재의 i 값은 : " + i );
					try {
						Thread.sleep(1000);
						if(Thread.currentThread().isInterrupted()){ // 현재 수행되고 있는 Thread의 객체가 interrupt 되었어?? 만약 되었다면 if내에 수행을 이룬다.
							break; // 가장 인접한 반복문을 빠져나간다.
						}
					} catch (Exception e) {
						System.out.println(e);
					}
				}
	}		
}
