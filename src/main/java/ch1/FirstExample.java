package ch1;


import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/*
 *  Observable 클래스는 데이터의 변화가 발생하는 데이터 소스
 *  리액티브 프로그래밍에서는 Observable에서 시작함. *  
 *  
 */
public class FirstExample {
	
	public void emit() {
		//just()함수는 가장 단순한 Observable 선언 방식이며, 데이터소스에서 Hello와 RxJava 2!!를 발행함.
		//Integer와 같은 레퍼타입부터 Order와 같은 사용자 정의 클래스의 객체도 인자로 넣을수 있음.
		//subscribe()는 Observable를 구독함. Observable은 subscribe함수를 호출해야 비로소 변화한 데이터를 구독할 수 있음.
		//반드시 데이터를 수신할  구독자가 subscribe()함수를 호출해야 Observable에서 데이터가 발행됨..
		Disposable d = Observable.just("Hello","RxJava 2!!").subscribe(System.out::println);
		System.out.println("isDisposed(): "+ d.isDisposed());
		
		
	}
	
	
	public static void main(String[] args) {
       FirstExample demo =  new FirstExample();
       demo.emit();
	}

}