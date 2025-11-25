package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

public class PlaylistRecommenderTest {
    @Test
    void testClassifyEnergy() {
        // test ranges
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(Arrays.asList(135, 140, 150)));
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(Arrays.asList(139, 120, 98)));
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(Arrays.asList(102, 50, 90)));

        // test boundaries
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(Arrays.asList(139, 140, 141)));
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(Arrays.asList(99, 100, 101)));
        
        // test exceptions
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(null));
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(Collections.emptyList()));
    }

    @Test
    void testIsValidTrackTitle() {
        // basic title
        assertTrue(PlaylistRecommender.isValidTrackTitle("NEW MAGIC WAND"));

        // boundaries
        assertTrue(PlaylistRecommender.isValidTrackTitle("A".repeat(30)));
        assertFalse(PlaylistRecommender.isValidTrackTitle("a".repeat(31)));

        // special characters
        assertFalse(PlaylistRecommender.isValidTrackTitle("Lalala#lalala"));

        // numbers
        assertFalse(PlaylistRecommender.isValidTrackTitle("aAbBcC5dDeEfF"));

        // null or empty
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
        assertFalse(PlaylistRecommender.isValidTrackTitle(""));
    }

    @Test
    void testNormalizeVolume()
    {
        assertEquals(100, PlaylistRecommender.normalizeVolume(101));
        assertEquals(100, PlaylistRecommender.normalizeVolume(125));
        assertEquals(0, PlaylistRecommender.normalizeVolume(-1));   
        assertEquals(0, PlaylistRecommender.normalizeVolume(-30));
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
        assertEquals(99, PlaylistRecommender.normalizeVolume(99));
        assertEquals(1, PlaylistRecommender.normalizeVolume(1));
    }
   
}
