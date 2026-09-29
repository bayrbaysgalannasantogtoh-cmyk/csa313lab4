package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
 
        GradeCalculator calc = new GradeCalculator();
 
        String grade = calc.letterGrade(90.0);
 
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой (хязгаарын тохиолдол)")
    void eightyNinePointNineNineIsB() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(89.99);
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("60 оноо яг D дүн байх ёстой (хязгаарын тохиолдол)")
    void sixtyIsExactlyD() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(60.0);
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой (хязгаарын тохиолдол)")
    void fiftyNinePointNineNineIsF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(59.99);
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("Буруу оролт буюу 100-аас их үед IllegalArgumentException шидэх")
    void scoreGreaterThan100ThrowsException() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.letterGrade(101.0);
        });
    }

    @Test
    @DisplayName("Буруу оролт буюу сөрөг утгад IllegalArgumentException шидэх")
    void negativeScoreThrowsException() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.letterGrade(-1.0);
        });
    }

    @ParameterizedTest
    @CsvSource({
        "95.0, A",
        "90.0, A",
        "89.99, B",
        "85.0, B",
        "75.0, C",
        "65.0, D",
        "59.99, F",
        "0.0, F"
    })
    @DisplayName("Parameterize ашиглан олон төрлийн үсгэн дүнг шалгах")
    void testLetterGradeParameterized(double score, String expectedGrade) {
        GradeCalculator calc = new GradeCalculator();
        assertEquals(expectedGrade, calc.letterGrade(score));
    }

    @Test
    @DisplayName("Нийт оноо хэвийн үед зөв тооцогдох")
    void totalScoreValidInputs() {
        GradeCalculator calc = new GradeCalculator();
 
        double total = calc.totalScore(10.0, 40.0, 10.0, 10.0, 30.0);
        assertEquals(100.0, total);
    }

    @Test
    @DisplayName("totalScore руу сөрөг утга өгөхөд IllegalArgumentException шидэх")
    void totalScoreNegativeInputThrowsException() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calc.totalScore(-5.0, 40.0, 10.0, 10.0, 30.0);
        });
    }

    @Test
    @DisplayName("totalScore руу хязгаараас хэтэрсэн утга өгөхөд IllegalArgumentException шидэх")
    void totalScoreExceededInputThrowsException() {
        GradeCalculator calc = new GradeCalculator();
 
        assertThrows(IllegalArgumentException.class, () -> {
            calc.totalScore(10.0, 41.0, 10.0, 10.0, 30.0);
        });
    }

    @ParameterizedTest
    @CsvSource({
        "10, 40, 10, 10, 30, 100",
        "5,  20, 5,  5,  15, 50",
        "0,  0,  0,  0,  0,  0"
    })
    @DisplayName("totalScore-д зориулсан Parameterized тест")
    void testTotalScoreParameterized(double att, double lab, double q1, double q2, double exam, double expected) {
        GradeCalculator calc = new GradeCalculator();
        assertEquals(expected, calc.totalScore(att, lab, q1, q2, exam));
    }
}
