package jdk.java.util.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class StreamCreationTest
{

    @Test
    void streamFromString() throws IOException
    {
	var contents = Files.readString(Path.of("src/main/resources/alice.txt"));
	Stream<String> words = Stream.of(contents.split("\\PL+"));
	System.out.println(words.limit(10).toList());
    }

    @Test
    void streamFromSeveralStrings()
    {
	var words = Stream.of("gently", "down", "the", "stream");
	System.out.println(words.limit(10).toList());
    }

    @Test
    void emptyStream()
    {
	var empty = Stream.empty();
	System.out.println(empty.limit(10).toList());
    }

    @Test
    void streamFromGenerator()
    {
	var echos = Stream.generate(() -> "echo");
	System.out.println(echos.limit(10).toList());

	var ramdoms = Stream.generate(Math::random);
	System.out.println(ramdoms.limit(10).toList());
    }

    @Test
    void streamFromIterate()
    {
	var integers = Stream.iterate(0, n -> n + 1);
	System.out.println(integers.limit(100).toList());
    }

    @Test
    void streamFromStringLines()
    {
	var lines = "Hello\nGuten Tag\nBonjour".lines();
	System.out.println(lines.toList());
    }

    @Test
    void streamFromFileLines() throws IOException
    {
	var lines = Files.lines(Path.of("src/main/resources/alice.txt"));
	System.out.println(lines.toList());
    }

    @Test
    void streamFromRegex() throws IOException
    {
	var contents = Files.readString(Path.of("src/main/resources/alice.txt"));
	Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
	System.out.println(wordsAnotherWay.toList());
    }
}
