package ch.chrisrayrayne.timetable.calculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by chrisrayrayne on 12.07.22.
 */
@Getter
@Setter
@AllArgsConstructor
public class Result {
    private boolean success = false;
    private List<Slot> slots = List.of();
}
