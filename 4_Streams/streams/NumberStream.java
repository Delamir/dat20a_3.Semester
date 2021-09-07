package streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class NumberStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8);

        int sum = numbers.stream().mapToInt(number -> number).sum();
        System.out.println(sum);

        // ParallelStream opretter en ny Thread
        int sumParallelized = numbers.parallelStream().mapToInt(number -> number).sum();

        System.out.println(sumParallelized);

        double averageTemperature = numbers.stream().mapToInt(number -> number).average().getAsDouble();
        System.out.println(averageTemperature);

        List<Integer> squaredNumbers = numbers.stream().map(nomNom -> nomNom * nomNom).collect(Collectors.toList());

        System.out.println(squaredNumbers);

        List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());

        System.out.println(evenNumbers);

        List<Integer> oddNumbers = numbers.stream().filter(number -> number % 2 != 0).collect(Collectors.toList());

        System.out.println(oddNumbers);

        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNumbers);

        // Nedenstående er ikke at foretrække
        IntSummaryStatistics summary = numbers
                .parallelStream()
                .mapToInt(number -> number)
                .summaryStatistics();
        System.out.println(summary.getMin());
        System.out.println(summary.getMax());
        System.out.println(summary.getSum());
        System.out.println(summary.getAverage());
        System.out.println(summary);
    }
}
