/**
 * 
 */
package ch2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import common.Order;
import io.reactivex.Observable;

/**
 * @author knlee
 *
 */
public class ObservableFromIterable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObservableFromIterable ofi = new ObservableFromIterable();
	//	ofi.listExample();
	//	ofi.setExample();
		
		ofi.blockingQueueExample();
	}

	private void listExample() {
		List<String> names = new ArrayList<>();
		names.add("Jerry");
		names.add("William");
		names.add("Bob");
		
		Observable<String> source = Observable.fromIterable(names);
		source.subscribe(System.out::println);
	//	source.subscribe(next -> System.out.println(next));
		
	}
	
	void setExample(){
		Set<String> cities = new HashSet<String>();
		cities.add("Seoul");
		cities.add("London");
		cities.add("Paris");
		
		Observable<String> source = Observable.fromIterable(cities);
		source.subscribe(System.out::println);
			
	}
	
	void blockingQueueExample(){
		BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
		orderQueue.add(new Order("ORD-1"));
		orderQueue.add(new Order("ORD-2"));
		orderQueue.add(new Order("ORD-3"));
		orderQueue.add(new Order("ORD-4"));
		
		Observable<Order> source = Observable.fromIterable(orderQueue);
		source.subscribe(System.out::println);
		
		
	}
	
	
	

}
