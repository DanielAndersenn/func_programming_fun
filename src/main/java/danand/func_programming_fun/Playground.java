package danand.func_programming_fun;

import danand.func_programming_fun.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Service
public class Playground {

	public Playground() {
	}

	void Lambda1() {

	Runnable r = () -> {
		System.out.println("HELLO FROM Lambda");
		};

	r.run();

	}

	void Lambda2() {

		new Thread(() -> { System.out.println("Thread started"); }).start();

	}

	void Lambda3() {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
		//Print unsorted list
		System.out.println(words);
		//Sort list
		Collections.sort(words, Comparator.comparingInt(String::length));
		//Print sorted list
		System.out.println(words);
	}

	void Lambda4() {
		Predicate<String> isEmptyPredicate = (s) -> s.isEmpty();
		System.out.println(isEmptyPredicate.test(""));
		System.out.println(isEmptyPredicate.test("NotEmpty"));
	}

	void Lambda5() {
		Function<String, Integer> toInteger = (s) -> Integer.parseInt(s);
		System.out.println(toInteger.apply("40"));
		try {
			System.out.println(toInteger.apply("YO"));
		} catch (NumberFormatException ex) {
			System.out.println("NumberFormatException caught");
		}

	}

	void Lambda6() {
		Consumer<String> print = (s) -> System.out.println(s);
		print.accept("Hello from Lambda6");
	}

	public void Lambda7() {
		Supplier<String> randomizeString = () -> UUID.randomUUID().toString();
		System.out.println("Hello from Lambda7 " + randomizeString.get());
	}

	public void Lambda8() {
		List<Book> bookList = new ArrayList<>();

		Book book1 = new Book("Superimperialism", "Michael Hudosn");
		Book book2 = new Book("Consequences of Capitalism", "Noam Chomsky");
		Book book3 = new Book("The Jakarta Method", "IDK");

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);

		Optional<Book> book = findBookByTitle(bookList, "Superimperialism");
		Book result = book.orElse(new Book("Not Found", "Unknown"));
		System.out.println(result.getTitle());

		Optional<Book> book23 = findBookByTitle(bookList, "Kek");
		Book result23 = book23.orElse(new Book("Not Found", "Unknown"));
		System.out.println(result23.getTitle());

	}

	public static Optional<Book> findBookByTitle(List<Book> bookList, String title) {
		return bookList.stream()
				.filter(b -> b.getTitle().equals(title))
				.findFirst();
	}

	public void Lambda9() {
		String s = "Hello from Lambda9";
		Optional<Integer> number = parseStringToInteger(s);
		int result = number.orElse(0);
		System.out.println("Hello from Lambda9 " + result);

		String t = "600";
		Optional<Integer> number2 = parseStringToInteger(t);
		int result2 = number2.orElse(0);
		System.out.println("Hello from Lambda9 " + result2);

	}

	public static Optional<Integer> parseStringToInteger(String s) {
		try {
			return Optional.ofNullable(Integer.parseInt(s));
		} catch(NumberFormatException nfe) {
			return Optional.empty();
		}
	}


	public void Lambda10() {
		int result = calculator((a, b) -> a + b, 5, 2);
	}

	public static <T> T calculator(Operation<T> function, T value1, T value2) {

		T result = function.operate(value1, value2);
		System.out.println("This is my result: " + result);
		return result;
	}

}
