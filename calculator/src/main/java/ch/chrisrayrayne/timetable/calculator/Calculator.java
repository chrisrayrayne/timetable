package ch.chrisrayrayne.timetable.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chrisrayrayne on 12.07.22.
 */
public class Calculator {

    public static Result calculate(Template template, List<Student> students) {
        var templateSlots = createSlotsFromTemplate(template);
        var slots = createSlotsFromTemplate(template);
        slots = createSlotsFromStudents(slots, students);
        // TODO Sort Slots ascending by size of students
        // TODO if top size are multiple, sort by count slots by students ascending
        // TODO if only one top size, set it
        // TODO recalculate slotscount and studentscount

        var success = checkForSuccess(slots, students);
        return new Result(success, slots);
    }

    private static List<Slot> createSlotsFromStudents(List<Slot> slots, List<Student> students) {
        var newSlots = new ArrayList<Slot>(slots);
        for (Student student : students) {
            for (Slot slot : student.getSlots()) {
                var availableSlots = newSlots.stream().filter(
                        s -> s.getWeekday().equals(slot.getWeekday()) &&
                                (slot.getStartTime() >= s.getStartTime() && slot.getStartTime() < s.getEndTime()) ||
                                (slot.getEndTime() > s.getStartTime() && slot.getEndTime() <= s.getEndTime())).toList();
                newSlots.removeAll(availableSlots);
                newSlots.addAll(splitSlots(availableSlots, slot));
            }
        }
        return newSlots;
    }

    private static List<Slot> splitSlots(List<Slot> availableSlots, Slot slot) {
        var slots = new ArrayList<Slot>();
        for (var aSlot : availableSlots) {
            var start = aSlot.getStartTime();
            var end = aSlot.getEndTime();
            if (start < slot.getStartTime()) {
                slots.add(new Slot(slot.getWeekday(), start, slot.getStartTime()));
                start = slot.getStartTime();
            }
            if (end > slot.getEndTime()) {
                slots.add(new Slot(slot.getWeekday(), slot.getEndTime(), end));
                end = slot.getEndTime();
            }
            slots.add(new Slot(slot.getWeekday(), start, end));
        }
        return slots;
    }

    private static boolean checkForSuccess(List<Slot> slots, List<Student> students) {
        return false;
    }

    private static List<Slot> createSlotsFromTemplate(Template template) {
        return List.copyOf(template.getSlots());
    }
}
