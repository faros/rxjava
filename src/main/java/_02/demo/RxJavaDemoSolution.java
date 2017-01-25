package _02.demo;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

public class RxJavaDemoSolution {

	public static void main (String[] args) throws InterruptedException {
		List<String> list1 = Arrays.asList("a", "b", "c");
		List<String> list2 = Arrays.asList("1", "2", "3");
		
		Observable<String> o1 = Observable.from(list1);
		Observable<String> o2 = Observable.from(list2);

		o1.concatWith(o2).subscribe(System.out::println);
		
		Thread.sleep(10000);
	}
}