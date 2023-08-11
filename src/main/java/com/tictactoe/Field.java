package com.tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Field {
    private final Map<Integer, Sign> field;

    public Field() {
        field = new HashMap<>();
        field.put(0, Sign.EMPTY);
        field.put(1, Sign.EMPTY);
        field.put(2, Sign.EMPTY);
        field.put(3, Sign.EMPTY);
        field.put(4, Sign.EMPTY);
        field.put(5, Sign.EMPTY);
        field.put(6, Sign.EMPTY);
        field.put(7, Sign.EMPTY);
        field.put(8, Sign.EMPTY);
    }

    public Map<Integer, Sign> getField() {
        return field;
    }

    public int getEmptyFieldIndex() {
        for (Map.Entry<Integer, Sign> e : field.entrySet()) {
            if (e.getValue() == Sign.EMPTY) {
                Integer key = e.getKey();
                return key;
            }
        }
        return -1;
    }

    public List<Sign> getFieldData() {
        List<Map.Entry<Integer, Sign>> toSort = new ArrayList<>();
        for (Map.Entry<Integer, Sign> integerSignEntry : field.entrySet()) {
            toSort.add(integerSignEntry);
        }
        toSort.sort(Map.Entry.comparingByKey());
        List<Sign> list = new ArrayList<>();
        for (Map.Entry<Integer, Sign> integerSignEntry : toSort) {
            Sign value = integerSignEntry.getValue();
            list.add(value);
        }
        return list;
    }

    public Sign checkWin() {
        List<List<Integer>> winPossibilities = List.of(
                List.of(0, 1, 2),
                List.of(3, 4, 5),
                List.of(6, 7, 8),
                List.of(0, 3, 6),
                List.of(1, 4, 7),
                List.of(2, 5, 8),
                List.of(0, 4, 8),
                List.of(2, 4, 6)
        );

        for (List<Integer> winPossibility : winPossibilities) {
            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(1))
                && field.get(winPossibility.get(0)) == field.get(winPossibility.get(2))) {
                return field.get(winPossibility.get(0));
            }
        }
        return Sign.EMPTY;
    }
}