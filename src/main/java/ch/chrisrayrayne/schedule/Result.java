package ch.chrisrayrayne.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chrisrayrayne on 12.07.22.
 */
@Getter
@Setter
public class Result {
    private boolean success = false;
    private List<Slot> slots = List.of();
}
