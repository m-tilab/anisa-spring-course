package exta;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatTest {

    @RepeatedTest(3)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("Executing repeated test");

        System.out.println(repetitionInfo.getCurrentRepetition());

        assertEquals(2, Math.addExact(1, 1), "1 + 1 should equal 2");
    }
}
