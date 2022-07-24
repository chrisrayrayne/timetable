package ch.chrisrayrayne.timetable.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.DayOfWeek.MONDAY;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void oneStudentFit() {
        var student = new Student("lastname", "firstname", 100, List.of(new Slot(MONDAY, 100, 200)));
        var template = new Template(List.of(new Slot(MONDAY, 100, 300)));
        var result = Calculator.calculate(template, List.of(student));
        assertAll(
                () -> assertTrue(result.isSuccess()),
                () -> assertEquals(1, result.getSlots().size())
        );
    }

    @Test
    public void oneStudentDoesNotFit() {
        var student = new Student("lastname", "firstname", 100, List.of(new Slot(MONDAY, 300, 500)));
        var template = new Template(List.of(new Slot(MONDAY, 100, 300)));
        var result = Calculator.calculate(template, List.of(student));
        assertAll(
                () -> assertTrue(result.isSuccess()),
                () -> assertEquals(1, result.getSlots().size())
        );
    }

    @Test
    public void twoStudentFit() {
        var student1 = new Student("lastname1", "firstname1", 100, List.of(new Slot(MONDAY, 100, 200)));
        var student2 = new Student("lastname2", "firstname2", 100, List.of(new Slot(MONDAY, 200, 300)));
        var template = new Template(List.of(new Slot(MONDAY, 100, 300)));
        var result = Calculator.calculate(template, List.of(student1, student2));
        assertAll(
                () -> assertTrue(result.isSuccess()),
                () -> assertEquals(2, result.getSlots().size())
        );
    }

    @Test
    public void twoStudentDoesNotFit() {
        var student1 = new Student("lastname1", "firstname1", 100, List.of(new Slot(MONDAY, 100, 200)));
        var student2 = new Student("lastname2", "firstname2", 100, List.of(new Slot(MONDAY, 150, 250)));
        var template = new Template(List.of(new Slot(MONDAY, 100, 300)));
        var result = Calculator.calculate(template, List.of(student1, student2));
        assertAll(
                () -> assertFalse(result.isSuccess()),
                () -> assertEquals(1, result.getSlots().size())
        );
    }

    @Test
    public void twoStudentOverlapFit() {
        var student1 = new Student("lastname1", "firstname1", 100, List.of(new Slot(MONDAY, 100, 300)));
        var student2 = new Student("lastname2", "firstname2", 100, List.of(new Slot(MONDAY, 150, 300)));
        var template = new Template(List.of(new Slot(MONDAY, 100, 300)));
        var result = Calculator.calculate(template, List.of(student1, student2));
        assertAll(
                () -> assertFalse(result.isSuccess()),
                () -> assertEquals(2, result.getSlots().size())
        );
    }
}
