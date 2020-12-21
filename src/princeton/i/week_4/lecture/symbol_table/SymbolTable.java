package princeton.i.week_4.lecture.symbol_table;

import java.util.Arrays;

public class SymbolTable<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;

    public SymbolTable() {
    }

    public void put(Key key, Value val) {
        int index = getIndex(key);
        if (index != -1) {
            values[index] = val;
        } else {
            keys = Arrays.copyOf(keys, keys.length + 1);
            keys[keys.length - 1] = key;
            values = Arrays.copyOf(values, values.length + 1);
            values[values.length - 1] = val;
        }
    }

    public Value get(Key key) {
        int index = getIndex(key);
        if (index != -1) {
            return values[index];
        } else {
            return null;
        }
    }

    public void delete(Key key) {
        // lazy version
        put(key, null);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return keys.length == 0;
    }

    public int size() {
        return keys.length;
    }

    // public Iterable<Key> keys() {
    // }

    private int getIndex(Key key) {
        // sequential search
        // for (int i = 0; i < keys.length; i++) {
        //     if (keys[i].compareTo(key) == 0) {
        //         return i;
        //     }
        // }

        // binary search
        if (isEmpty()) {
            return -1;
        }
        return rank(key);
    }

    private int rank(Key key) {
        int lo = 0, hi = keys.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
