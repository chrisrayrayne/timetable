package ch.chrisrayrayne.timetable.calculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.ArrayList;

/**
 * Created by chrisrayrayne on 12.07.22.
 */
@Getter
@Setter
@AllArgsConstructor
public class Slot {

    private ArrayList<Student> students = new ArrayList<Student>();
    private int startTime;
    private int endTime;
    private DayOfWeek weekday;

    public Slot(DayOfWeek weekday, int startTime, int endTime) {
        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
