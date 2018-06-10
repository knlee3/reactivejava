package ch2;

import java.util.stream.IntStream;

import io.reactivex.Observable;

/*
 * int배열 사용방법 예제
 * 
 */
public class ObservableFromArrayInt {

	public static void main(String[] args) {
		ObservableFromArrayInt ofai  = new ObservableFromArrayInt();
		ofai.intArray();
	}

	private void intArray() {
		int[] intArry = {400,500,600};
		
		Observable<Integer> source = Observable.fromArray(toIntegerArry(intArry));
		source.subscribe(System.out::println);
		
		
	}

	/*
	 * int형 배역을 레퍼객체 Intger[]로 변환함.
	 */
	private static Integer[] toIntegerArry(int[] intArry) {
		return IntStream.of(intArry).boxed().toArray(Integer[]::new);
	}

}
