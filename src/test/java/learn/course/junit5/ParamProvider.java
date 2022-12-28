package learn.course.junit5;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ParamProvider {

    static Stream<Arguments> sourceStreamStringDouble() {
        return Stream.of(Arguments.arguments("lemon", 1.2));
    }
}
