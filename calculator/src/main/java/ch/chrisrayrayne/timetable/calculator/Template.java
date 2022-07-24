package ch.chrisrayrayne.timetable.calculator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chrisrayrayne on 12.07.22.
 */
@AllArgsConstructor
@Getter
public class Template {
    private List<Slot> slots = new ArrayList<>();
}
