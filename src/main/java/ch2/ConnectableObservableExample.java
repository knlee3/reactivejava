package ch2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableObservableExample {

	public static void main(String[] args) throws InterruptedException {
		ConnectableObservableExample coe = new ConnectableObservableExample();
		coe.marbleDiagram();
		
	}

	private void marbleDiagram() throws InterruptedException {
		System.out.println("1: " + new Date());
		String [] dt = {"1", "3", "5" }; //발행하고자 하는 data
		Observable<String> balls = Observable.interval(1000L, TimeUnit.MILLISECONDS)
											 .map(Long::intValue)
											 .map(i -> dt[i])
											 .take(dt.length);
		System.out.println("2: " + new Date());
		ConnectableObservable<String> source = balls.publish();
		source.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		source.subscribe(data -> System.out.println("Subscriber #2 => " + data));
		source.connect();
		System.out.println("3: " + new Date());
		Thread.sleep(2000);
		System.out.println("4: " + new Date());
		source.subscribe(data -> System.out.println("Subscriber #3 => " + data));
		System.out.println("5: " + new Date());
		Thread.sleep(1000);
		System.out.println("6: " + new Date());
	}

}
