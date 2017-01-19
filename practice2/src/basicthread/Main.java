package basicthread;

public class Main {

	//현재 우리프로그램은 main thread 하나만 존재하는 단일 Thread 프로그램이에요!
	//프로그램이 종료된다는 의미는 해당 프로그램 내에서 생성된 모든 thread가 종료되면 프로그램이 종료된다고 표현한다!!
	public static void main(String[] args) {
		// 프로그램의 Entry point
		
		System.out.println("메인이 시작되었어요!!");
		
		//Runnable Interface 를 구현한 객체를 하나 생성!
		MyThread t = new MyThread();
		Thread tt = new Thread(t);
		// Thread라는 객체에 runnable interface 객체를 넣어서 만들었다.
		// 하나의 객체를 다른 객체에 넣어주는 방식 (Dependency Injection)
		
		tt.setDaemon(true); // daemon thread로 변신! Main이 꺼지는 순간 같이 꺼진다.

		
		// 객체에 대한 method 호출!
//		t.run(); // 이렇게 Thread를 실행시키는게 아닙니다!!! 잘못된 코드다! 조심!!!
		tt.start(); //Thread를 실행시키는 method!!! Thread의 class에 있는 method이다.
		// start라는 method를 호출하면 요상한 현상이 발생!
		// java 프로그램은 JVM이 모든 실행을 관장한다! / JVM안에 Thread Scheduler라는게 존재한다! (어떤 thread를 먼저 실행시키고 어떤 것은 나중에 시켜주는지 정해주는 역할)
		// JVM이 프로그램을 실행시켜주는 주체이다! 내가 아니다. 나는 직접 Thread를 실행시킬 수 없다.
		// Scheduler에게 부탁한다. ( 해당 Thread를 시간될 때 실행시켜주세요!!) 어떤 Thread가 실행되는지 프로그램 측면에서는 알수가 없다. -> 이것이 Thread를 관리하는데 가장 어려운 점이다.
		// Thread가 언제 실행되는지에 대한 시점을 우리가 정확히 파악할 수 없다.
		
		//start라는 method는 우리가 일반적으로 사용하는 method처럼 blocking이 되지 않는 method이다.
		// 대부분의 method는 그 method가 실행이 되고 그 method가 끝나야 다른 게 실행된다.
		// start라는 method는 JVM에게 thread를 시작해달라고만 부탁만 하고 끝난다.
		// server에 여러사람이 동시에 수행하는 프로그램을 만드려면 Thread가 꼭 있어야한다.
		
		try {		// 다른 Thread (tt)가 종료될때까지 기다리려면 어떻게 해야할까요???
			tt.join();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//join은 해당 Thread가 종료될때까지 (Dead) 기다리는 역할을 해준다. join은 try ~ catch문이 강제된다.
		
		// Thread의 종료
		// tt.stop(); // 해당 method는 deprecated되었다. 가운데 줄이 그어져있다. stop이라는 method는 문제가 많다. 더 이상 쓰이지 않는다.
		 //scheduler한테 적당한 시기에 thread를 나갈 수 있도록 표시를 해준다.
		System.out.println("메인이 종료되요!!!");
		// main method가 끝나면 프로그램이 종료! 단일 쓰레드 프로그램
	}

}

// 독립적인 실행흐름을 나타내는 Thread를 만들려고 한다!
// 1.Thread class를 상속하여 사용하는 방법
// 2.Interface로 구현하는 방법