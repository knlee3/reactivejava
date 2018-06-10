package ch2;

import io.reactivex.subjects.ReplaySubject;


/*
 * ReplaySubject 클래스는 구독자가 새로 생기면 항상 데이터의 처음부터 끝까지 발행하는 것을 보장함.
 */
public class ReplaySubjectExample {

	public static void main(String[] args) {
		ReplaySubjectExample rse = new ReplaySubjectExample();
		rse.marbleDiagram();
		
	}

	/*
Subscriber #1 => 1
Subscriber #1 => 3
Subscriber #2 => 1
Subscriber #2 => 3
Subscriber #1 => 5
Subscriber #2 => 5

	 */
	private void marbleDiagram() {
		ReplaySubject<String> subject = ReplaySubject.create();
		subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		subject.onNext("1");
		subject.onNext("3");
		subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
		subject.onNext("5");
	}

}
