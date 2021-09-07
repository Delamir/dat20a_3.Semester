package streams;

import java.util.Date;
import java.util.stream.Stream;

public class ObjectStream {

    public static void main(String[] args) {
        Stream<Date> clock = Stream.generate(Date::new);

        //clock.forEach(timeStamp -> System.out.println(timeStamp));

        clock.forEach(System.out::println);
    }
}
