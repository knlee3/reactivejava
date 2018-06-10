package ch2;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import io.reactivex.Observable;

public class ObservableFromPublisher {

	public static void main(String[] args) {
		ObservableFromPublisher ofp = new ObservableFromPublisher();
		// ofp.withoutLambda();
		ofp.basic();
	}

	private void withoutLambda() {
		Publisher<String> publisher = new Publisher<String>() {

			@Override
			public void subscribe(Subscriber<? super String> s) {
				s.onNext("Hello Observable.fromPublisher()");
				s.onComplete();
				
			}
			
		};
		
		Observable<String> source = Observable.fromPublisher(publisher);
		source.subscribe(System.out::println);
		
		
	}
	
	
	private void basic() {
		Publisher<String> publisher = s -> {
				s.onNext("Hello basic Observable.fromPublisher()");
				s.onComplete();
				
			}
			
		;
		
		Observable<String> source = Observable.fromPublisher(publisher);
		source.subscribe(System.out::println);
		
		
	}



}
