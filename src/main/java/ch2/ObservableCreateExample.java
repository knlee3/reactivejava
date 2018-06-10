package ch2;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


/*
 * create() 함수는 onNext, onComplete, onError 같은 알림을 직접 호출해줘야 함.
 * 
 */
public class ObservableCreateExample {

	public static void main(String[] args) {
		ObservableCreateExample oc = new ObservableCreateExample();
		oc.emit();
	}

	private void emit() {
		Observable<Integer> source = Observable.create(
	emitter -> {
		emitter.onNext(100);
		emitter.onNext(200);
		emitter.onNext(300);
		emitter.onNext(400);
		emitter.onComplete();
	}
				
		);
	 
    Disposable	d = source.subscribe(System.out::println);
	//source.subscribe(  v -> System.out.println(v)); 
	  System.out.println(d.isDisposed());
	}

}
