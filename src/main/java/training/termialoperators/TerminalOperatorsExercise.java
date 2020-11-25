package training.termialoperators;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperatorsExercise implements StreamTerminalOperators {

    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {
        stream.collect(Collectors.toCollection(() -> set));
    }

    @Override
    public void addToListInReverseOrder(Stream<String> stream, List<String> list) {
        stream.sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(() -> list));
    }

    @Override
    public String[] collectToArray(Stream<String> stream) {
        return stream.toArray(x -> new String[x]);
    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        return stream.collect(Collectors.toSet());
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public String mergeIntoString(Stream<String> stream) {
        return stream.collect(Collectors.joining("-", "[", "]"));
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        return stream.mapToInt(x -> x.length()).sum();
    }

    @Override
    public int longestWordLength(Stream<String> stream) {
        return stream.mapToInt(x -> x.length()).max().orElse(0);
    }

    @Override
    public String longestWord(Stream<String> stream) {
        return stream.max(Comparator.comparingInt(x -> x.length())).orElse("");
    }

    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {
        return stream.collect(Collectors.groupingBy(String::length));
    }
}
