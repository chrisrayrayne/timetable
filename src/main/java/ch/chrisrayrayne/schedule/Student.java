package ch.chrisrayrayne.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chrisrayrayne on 12.07.22.
 */
@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String lastname;
    private String firstname;
    private int length;
    private List<Slot> slots;

    public Student(String lastname, String firstname, int length) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.length = length;
    }
}
