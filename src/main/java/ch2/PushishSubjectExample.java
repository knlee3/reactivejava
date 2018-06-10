package ch2;

import io.reactivex.subjects.PublishSubject;

public class PushishSubjectExample {

	public static void main(String[] args) {
		PushishSubjectExample pse = new PushishSubjectExample();
		pse.marbleDiagram();
	}

	private void marbleDiagram() {
		PublishSubject<String> subject = PublishSubject.create();
		subject.onNext("0");
		subject.subscribe(data -> System.out.println("Subscriber #1 =>" + data));
		subject.onNext("1");
		subject.onNext("3");
		subject.subscribe(data -> System.out.println("Subscriber #2 =>" + data));
		subject.onNext("5");
		subject.onComplete();
	}

}
