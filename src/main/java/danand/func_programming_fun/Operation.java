package danand.func_programming_fun;

@FunctionalInterface
public interface Operation<T> {

	T operate(T value1, T value2);

}
