package ch2;

import io.reactivex.subjects.BehaviorSubject;

/*
 * BehaviorSubject 클래스는 구독자가 구독을 하면 가장 최근 값 혹은 기본값을 넘겨주는 클래스
 */
public class BehaviorSubjectExample {

	public static void main(String[] args) {
		BehaviorSubjectExample bse = new BehaviorSubjectExample();
		bse.marbleDiagram();
		
	}

	
	/*
		Subscriber #1: => 6
		Subscriber #1: => 1
		Subscriber #1: => 3
		Subscriber #2: => 3
		Subscriber #1: => 5
		Subscriber #2: => 5
	 */
	private void marbleDiagram() {
		BehaviorSubject<String> subject = BehaviorSubject.createDefault("6"); // 기본값 6 설정
		subject.subscribe(data -> System.out.println("Subscriber #1: => " + data));
		subject.onNext("1");
		subject.onNext("3");
		subject.subscribe(data -> System.out.println("Subscriber #2: => " + data));
		subject.onNext("5");
		subject.onComplete();
	}

}
