package training.intermediateoperators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperatorsExercise implements StreamIntermediateOperators {

    @Override
    public Stream<String> wordsLongerThanFiveCharacters(List<String> words) {
        return words.stream()
                .filter(x -> x.length() > 5);
    }

    @Override
    public Stream<String> firstThreeWordsLongerThanFiveCharacters(List<String> words) {
        return words.stream()
                .filter(x -> x.length() > 5)
                .limit(3);

    }

    @Override
    public Stream<String> firstThreeDistinctWordsLongerThanFiveCharactersInReverseAlphabeticalOrder(List<String> words) {
        return words.stream()
                .distinct()
                .filter(x -> x.length() > 5)
                .limit(3)
                .sorted(Comparator.reverseOrder());
    }

    @Override
    public Stream<Integer> lengthOfWords(List<String> words) {
        return words.stream()
                .map(x -> x.length());
    }

    @Override
    public Stream<Integer> staircase() {
        return Stream.of(0, 1, 2, 3, 4, 5, 6)
                .flatMap(n -> Stream.iterate(0, x -> x+1).limit(n+1));
    }
}
