import org.example.Comparators;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MainTest {
    @Test
    public void testCompareDate() {
        List<String> dateStrings = Arrays.asList("2005-07-01", "2005-01-02", "2005-01-01", "2005-05-03");
        List<String> expected = Arrays.asList("2005-01-01", "2005-01-02", "2005-05-03", "2005-07-01");

        List<String> actual = Comparators.compareDate(dateStrings);
        Assertions.assertEquals(expected, actual);
    }
}
