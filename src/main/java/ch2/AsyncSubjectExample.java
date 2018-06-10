package ch2;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;


/*
 * AsyncSubject 클래스는 Obsevable에서 발행한 마지막 데이터를 얻어옴. 완료되기 전 마지막 데이터만 관심이 있으며, 이전 데이터는 무시됨.
 * 완료되기 전까지는 구독자에게 데이터를 전달하지 않다가 완료됨과 동시에 구독자들에게 마지막 데이터를 발행하고 종료함.
 */
public class AsyncSubjectExample {

	public static void main(String[] args) {
		AsyncSubjectExample ase = new AsyncSubjectExample();
		//ase.marbleDiagram();
	//	ase.asSubscribe();
		ase.afterComplete();
	}

	//	Subscriber: #1 => 12
	//	Subscriber: #2 => 12
	//	Subscriber: #3 => 12
	//  onComplete이후의 onNext 이벤트는 무시됨.
	private void afterComplete() {
		AsyncSubject<Integer> subject = AsyncSubject.create();
		subject.onNext(10);
		subject.onNext(11);
		subject.subscribe(data -> System.out.println("Subscriber: #1 => " + data));
		subject.onNext(12);
		subject.onComplete();
		subject.onNext(13);
		subject.subscribe(data -> System.out.println("Subscriber: #2 => " + data));
		subject.subscribe(data -> System.out.println("Subscriber: #3 => " + data));
		
	}


	// 출력결과 : Subscriber #1 => 12.5
	// AsyncSubject가 Observable의 구독자로 동작하는 예제
	private void asSubscribe() {
		Float[] temperature = {10.1f, 13.4f, 12.5f};
		Observable<Float> source = Observable.fromArray(temperature);
		AsyncSubject<Float> subject = AsyncSubject.create();
		subject.subscribe(data -> System.out.println("Subscriber #1 => " + data)); 		
		source.subscribe(subject);		
	}
	
	


	/*
	      출력결과 : 
	   Subscriber #1 => 5
	   Subscriber #2 => 5
	 */
	private void marbleDiagram() {
		AsyncSubject<String> subject = AsyncSubject.create();
		//첫번째 구독자
		subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		subject.onNext("1");
		subject.onNext("3");
		//두번째 구독자
		subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
		subject.onNext("5");
		subject.onComplete();
		
	}
	
	
	
	

}
