/**
 * 
 */
package ch2;

import java.util.concurrent.Callable;

import io.reactivex.Observable;

/**
 * FromCallable()는  비동기 실행 후 결과를 반환하는 call() 메소드를 정의함.
 *
 */
public class ObservableFromCallable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObservableFromCallable ofc = new ObservableFromCallable();
//		ofc.withoutLambda();
		ofc.basic();
	}
	
	void basic() {
		Callable<String> callable = () -> {
				Thread.sleep(1000); //1초 sleep
				return "Hello Callable";
		};
		
		Observable<String> source = Observable.fromCallable(callable);
		source.subscribe(System.out::println);
	}
	 

	void withoutLambda() {
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(1000); //1초 sleep
				return "Hello Callable";
			}
			
		};
		
		Observable<String> source = Observable.fromCallable(callable);
		source.subscribe(System.out::println);
	}
	
	
}
