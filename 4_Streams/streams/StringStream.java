package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStream {
    public static void main(String[] args) {
        List<String> coolWords = Arrays.asList("Joachim Prutter", "Fuck Patrick", "Sverri er den bedste", "", "", "Joachim Prutter");

        List<String> onlyWords = coolWords.stream().filter(word -> !word.isEmpty()).collect(Collectors.toList());
        System.out.println(onlyWords);

        long vocabulary = coolWords.stream().filter(word -> !word.isEmpty()).distinct().count();
        System.out.println(vocabulary);

        String sentence = coolWords
                .parallelStream()
                .filter(word -> !word.isEmpty())
                .collect(Collectors.joining(" ")) + ".";
        System.out.println(sentence);

    }
}
