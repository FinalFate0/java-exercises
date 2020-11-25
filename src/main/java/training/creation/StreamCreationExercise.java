package training.creation;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationExercise implements StreamCreator {

    @Override
    public IntStream positiveDigitsUsingOf() {
        return IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Override
    public IntStream positiveDigitsUsingRange() {
        return IntStream.range(1, 9+1);
    }

    @Override
    public IntStream positiveDigitsUsingIterate() {
        return IntStream.iterate(1, x -> x+1)
                .limit(9);
    }

    @Override
    public IntStream powersOfTwo() {
        return IntStream.iterate(2, x -> x*2)
                .limit(10);
    }

    @Override
    public DoubleStream from0Till1WithTenSteps() {
        return DoubleStream.iterate(0, x -> x+1)
                .limit(10)
                .map(x -> x/10);
    }

    @Override
    public Stream<String> alphabet() {
        return Stream.iterate(65, x -> x+1)
                .limit(26)
                .map(x -> Character.toString(x));
    }

}
