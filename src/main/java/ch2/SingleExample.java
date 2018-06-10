package ch2;

import common.Order;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Single Class는 오직 데이터 1개만 발행함. 데이터 하나가 발행과 동시에 종료됨. 
 * onNext와 onComplete가 onSuccess로 통합된 경우임.
 * @author knlee
 *
 */
public class SingleExample {

	public static void main(String[] args) {
		SingleExample se = new SingleExample();
	//	se.just();
	    se.fromObservable();			
	}

	private void fromObservable() {
		//1. 기존 Observable에서 Single 객체로 변환한 case
		Observable<String> source = Observable.just("Hello Single fromObservable");
		Single.fromObservable(source).subscribe(System.out::println);
		
		//2. single()함수를 호출해 Single객체 생성함.
		Observable.just("Hello Single single()").single("default val").subscribe(System.out::println);
				
		//3. first()함수를 호출하여 Single 객체를 생성함
		String[] colors = {"Red", "Yellow", "Green"};
		Observable.fromArray(colors).first("default Gold").subscribe(System.out::println);
		
		//4. empty Observable에서 Single객체 생성함
		Observable.empty().single("defualt value").subscribe(System.out::println);
		
		//5. take()할수에서 Single 객체 생성하기
		Observable.just(new Order("order-1"), new Order("order-2")).take(1).single(new Order("defult order")).subscribe(System.out::println);
		
		
	}

	private void just() {
		Single<String> source = Single.just("Hello Single");
		source.subscribe(System.out::println);
		
	}
	
	

}
