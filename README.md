# Stream API Operations Project

The Stream API in Java provides a set of sequence of elements supporting sequential and parallel aggregate operations. It allows us to perform complex data processing queries on a source of data. The Stream API is not about storing data, it's about computing on data.

The operations of the Stream API are divided into two categories: intermediate and terminal operations.

Intermediate operations are operations that transform a stream into another stream. They are always lazy, executing an intermediate operation such as `filter()` does not actually perform any filtering, but instead creates a new stream that, when traversed, contains the elements of the initial stream that match the given predicate. Intermediate operations are always invoked on a Stream and after they process, they give a Stream.

Terminal operations are operations that produce a result or a side-effect. After the terminal operation is performed, the stream pipeline is considered consumed, and can no longer be used. If you need to traverse the same data source again, you must return to the data source to get a new stream.

Here is a brief description of each operation:

Intermediate Operations:
- `filter(Predicate)`: Selects elements that satisfy a given condition.
- `map(Function)`: Transforms each element in the stream using a provided function.
- `flatMap(Function)`: Flattens the result of applying a function to each element, producing a stream of values.
- `distinct()`: Removes duplicate elements from the stream.
- `sorted()`: Sorts the elements of the stream.
- `distinct()`: Removes duplicate elements from the stream.
- `peek(Consumer)`: Performs an action for each element in the stream without modifying its contents.
- `limit(long)`: Reduces the stream to the first 'n' elements.
- `skip(long)`: Skips the first 'n' elements in the stream.
- `takeWhile(Predicate)`: Takes elements from the start of the stream while the condition is true.
- `dropWhile(Predicate)`: Skips elements from the start of the stream while the condition is true.

Terminal Operations:
- `forEach(Consumer)`: Executes a specified action for each element in the stream.
- `toArray()`: Returns an array containing the elements of the stream.
- `reduce(BinaryOperator)`: Performs a reduction on the elements of the stream using an associative accumulation function.
- `collect(Collector)`: Transforms the elements of the stream into a different form.
- `min(Comparator)`: Finds the minimum element in the stream based on the provided comparator.
- `max(Comparator)`: Finds the maximum element in the stream based on the provided comparator.
- `count()`: Returns the number of elements in the stream.
- `anyMatch(Predicate)`: Checks if any element in the stream satisfies a given condition.
- `allMatch(Predicate)`: Checks if all elements in the stream satisfy a given condition.
- `noneMatch(Predicate)`: Checks if none of the elements in the stream satisfy a given condition.
- `findFirst()`: Returns the first element in the stream.
- `findAny()`: Returns any element in the stream.

Each operation is demonstrated with a list of `Movie` objects, where each `Movie` has properties such as title, rating, and genre. The `Genre` is an enumeration with values ACTION, COMEDY, and THRILLER.
