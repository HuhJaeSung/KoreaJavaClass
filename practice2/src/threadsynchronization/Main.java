package threadsynchronization;

public class Main {

	public static void main(String[] args) {
		
		//data와 method가 같이 
		
		//Thread 를 3개정도 생성할거에요!~
		//이렇게 생선한 Thread를 실행시킬거에요!
		System.out.println("Main이 시작합니다.");
		//공유객체를 하나 만들어 놓아요!
		SharedObject obj = new SharedObject();
		
		// 우리가 MyThread에 Business logic을 사용하는데, 이 때 각 객체들이 공유객체를 사용할 수 있게 해야하기 때문에 , obj를 injection 시킨다.
		MyThread my1 = new MyThread(obj);
		MyThread my2 = new MyThread(obj);
		MyThread my3 = new MyThread(obj);
		//mythread라는 class의 Instance를 만들었을 뿐이다. 이렇게 Runnable interface를 구현한 3개의 instance를 Thread로 생성
		Thread t1 = new Thread(my1);
		Thread t2 = new Thread(my2);
		Thread t3 = new Thread(my3);
		// Thread instance로 생성되었다.
		
		//JVM 안에 있는 Thread Scheduler 에게 실행요청!
		t1.start();
		t2.start();
		t3.start();
		
		
		
	}

}
