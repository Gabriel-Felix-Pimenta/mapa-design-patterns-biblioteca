
package com.example.libmanager.patterns.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrategyPatternTest {

    @Test
    void shouldApplyAlphabeticalStrategy() {
        SortingStrategy strategy = new AlphabeticalSort();
        var result = strategy.sort(List.of("C", "A", "B"));

        assertEquals(List.of("A", "B", "C"), result);
    }
}
