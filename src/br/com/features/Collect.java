package br.com.features;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println(numbers + " type " + numbers.getClass().getSimpleName());

		Double avg = numbers.stream().collect(Collectors.averagingInt(n -> n.intValue()));
		System.out.println("\nAVG: " + avg);
		
		Integer sum = numbers.stream().collect(Collectors.summingInt(n -> n.intValue()));
		System.out.println("\nSUM: " + sum);

		IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(n -> n.intValue()));
		System.out.println("AVG: " + stats.getAverage());
		System.out.println("COUNT: " + stats.getCount());
		System.out.println("SUM: " + stats.getSum());
		System.out.println("MIN: " + stats.getMin());
		System.out.println("MAX: " + stats.getMax());
		
		// counting
		Long count = numbers.stream()
			.filter((n) -> n % 2 == 0)
			.collect(Collectors.counting());
		System.out.println("counting: " + count);
		
		// groupingBy
		Map<Integer, List<Integer>> groupingBy = numbers.stream()
			.collect(Collectors.groupingBy((n) -> n % 3));
		System.out.println(groupingBy);
		
		// partitioningBy
		Map<Boolean, List<Integer>> partitioningBy = numbers.stream()
			.collect(Collectors.partitioningBy((n) -> n % 2 == 0));
		System.out.println(partitioningBy);
		
		// toMap
		Map<Integer, Integer> toMap = numbers.stream()
			.collect(Collectors.toMap(n -> n, n -> Math.multiplyExact(n, 2)));
		System.out.println(toMap);
	}
}
