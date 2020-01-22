package ru.job4j.array;

/**
 * Checker for array.
 *
 * @author Max Vanny.
 * @version 1.0
 * @since 0.1
 */
public class Check {
    /**
     * Mono.
     *
     * @param data data
     * @return result
     */
    public final boolean mono(final boolean[] data) {
        boolean result = true;
        for (boolean runner : data) {
            if (data[0] != runner) {
                result = false;
                break;
            }
        }
        return result;
    }
}
