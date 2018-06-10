package ch2;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.reactivex.Observable;

public class ObservableFromFuture {

	public static void main(String[] args) {

		ObservableFromFuture off = new ObservableFromFuture();
		off.basic();
		off.withoutLambda();
		
		
	}

	private void withoutLambda() {
		Future<String> future = Executors.newSingleThreadExecutor().submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				return "Hello Future";
			}
			
			
		});
		
		Observable<String> source = Observable.fromFuture(future);
		source.subscribe(System.out::println);
		
		
	}

	//rxjava에서는 Excutors클래스보다는 Rxjava에서 제공하는 스케쥴러를 활용하도록 권장함.
	private void basic() {
		Future<String> future = Executors.newSingleThreadExecutor().submit(()-> {	
				Thread.sleep(1000);
				return "Hello Future";			
		});
		
		Observable<String> source = Observable.fromFuture(future);
		source.subscribe(System.out::println);
		
		
		
	}

}
