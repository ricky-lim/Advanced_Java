package lambdastreams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingDemo {
    private List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    public List<String> alphaSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    public List<String> lengthReverseSortWithComparator() {
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        return sampleStrings;
    }

    public List<String> lengthSortWithLambda() {
        Collections.sort(sampleStrings, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        return sampleStrings;
    }

    public List<String> lengthSortWithComparator() {
        Collections.sort(sampleStrings, Comparator.comparingInt(String::length));
        return sampleStrings;
    }

    public List<String> lengthSortThenAlphabeticalSort() {
        Collections.sort(sampleStrings,
                Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()));
        return sampleStrings;
    }

    public List<String> alphaSortUsingSorted() {
        return sampleStrings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public List<String> lengthSortThenAlphaSortUsingSorted() {
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

}
