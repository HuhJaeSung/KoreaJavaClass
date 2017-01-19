package threadsynchronization;

public class MyThread implements Runnable{
	
	SharedObject obj;
	public static final Object monitor = new Object();
	
	public MyThread(SharedObject obj) {
		this.obj = obj;
	}
	//Dependency Injection
	// Thread가 공공자원을 사용할 수 있게 하기위해 공유자원을 생성자에 공유자원을 이용하여 instance를 만들 수 있게 생성자를 만들어 놓는다.
	
	// 공유객체를 사용하는 business method를 작성해보아요.
	
	
	public void printObj(){ // 공공자원을 여러 Thread가 같이 이용하는 과정중에서 synchronized keyword를 사용하여 동기화를 할 수 있다.
		// 이 경우는 method 자체가 동기화되버려서 효율이 안좋을 수 있다. method 내에 모든 code가 동기화가 되어버리기 때문에, 효율이 떨어질 수 있다.
		// 따라서, 동기화가 필요한 부분만을 따로 block 처리를 할 수 있게 해주는 방법이 있다.
		
		synchronized (monitor) {// (monitor)가 바로 모니터이다.
			obj.printlist(); // method가 지금까지 동시처리에서 순차처리가 된다. (효율이 조금 떨어진다.)
			// eclipse의 출력을 조심해야 하는 것이 이 출력자체도 Thread로 출력이 되기 때문에, 지금 나오는 순서가 수행이된 순서라는 것을 보장할 수 없다.			
		}

	}
	
	@Override
	public void run() {
		for(int i = 1; i<5; i++){
			printObj();
//			System.out.println("Current Thread : " + Thread.currentThread().getName()
//					+ " i의 값은 : " + i);
		}
		
	}

}
