package ch2;

import io.reactivex.Observable;


/*
 * fromArry() 팩토리 메소를 이용한 Observable 만들기
 */
public class ObservableFromArray {

	public static void main(String[] args) {
		ObservableFromArray ofa = new ObservableFromArray();
		ofa.integerArray();
	}

	private void integerArray() {
		Integer[] arr = {100,200,300};
				
		Observable<Integer> source = Observable.fromArray(arr);
		source.subscribe(System.out::println);
	}
	
	


}
