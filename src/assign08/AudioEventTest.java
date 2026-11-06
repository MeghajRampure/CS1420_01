package assign08;

/**
 * Test cases for AudioEvent, NoteEvent, VolumeEvent
 *
 * @author Meghaj Rampure
 * @version Nov 5, 2026
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AudioEventTest {

    /**
     * Tests the NoteEvent constructor and getters.
     */
    @Test
    public void testNoteEventGetters() {
        NoteEvent note = new NoteEvent(7142, 3, 1000, 60);

        assertEquals(7142, note.getTime());
        assertEquals(3, note.getTrackNumber());
        assertEquals(1000, note.getDuration());
        assertEquals(60, note.getPitch());
    }

    /**
     * Tests the VolumeEvent constructor and getter.
     */
    @Test
    public void testVolumeEventGetters() {
        VolumeEvent volume = new VolumeEvent(7142, 5, 72);

        assertEquals(7142, volume.getTime());
        assertEquals(5, volume.getTrackNumber());
        assertEquals(72, volume.getValue());
    }

    /**
     * Tests valid boundary values for a note.
     */
    @Test
    public void testNoteEventBoundaries() {
        NoteEvent note = new NoteEvent(0, 0, 0, 0);
        assertEquals(0, note.getTime());
        assertEquals(0, note.getTrackNumber());
        assertEquals(0, note.getDuration());
        assertEquals(0, note.getPitch());

        NoteEvent highNote = new NoteEvent(10, 9, 100, 127);
        assertEquals(9, highNote.getTrackNumber());
        assertEquals(127, highNote.getPitch());
    }

    /**
     * Tests valid boundary values for volume.
     */
    @Test
    public void testVolumeEventBoundaries() {
        VolumeEvent low = new VolumeEvent(0, 0, 0);
        assertEquals(0, low.getValue());

        VolumeEvent high = new VolumeEvent(10, 9, 127);
        assertEquals(127, high.getValue());
    }

    /**
     * Tests invalid event times.
     */
    @Test
    public void testInvalidTime() {
        assertThrows(IllegalArgumentException.class,
                () -> new NoteEvent(-1, 0, 10, 60));

        assertThrows(IllegalArgumentException.class,
                () -> new VolumeEvent(-1, 0, 50));
    }

    /**
     * Tests invalid track numbers.
     */
    @Test
    public void testInvalidTrackNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> new NoteEvent(0, -1, 10, 60));

        assertThrows(IllegalArgumentException.class,
                () -> new NoteEvent(0, 10, 10, 60));

        assertThrows(IllegalArgumentException.class,
                () -> new VolumeEvent(0, -1, 50));

        assertThrows(IllegalArgumentException.class,
                () -> new VolumeEvent(0, 10, 50));
    }

    /**
     * Tests invalid note durations.
     */
    @Test
    public void testInvalidDuration() {
        assertThrows(IllegalArgumentException.class,
                () -> new NoteEvent(0, 0, -1, 60));
    }

    /**
     * Tests invalid note pitches.
     */
    @Test
    public void testInvalidPitch() {
        assertThrows(IllegalArgumentException.class,
                () -> new NoteEvent(0, 0, 10, -1));

        assertThrows(IllegalArgumentException.class,
                () -> new NoteEvent(0, 0, 10, 128));
    }

    /**
     * Tests invalid volume values.
     */
    @Test
    public void testInvalidVolume() {
        assertThrows(IllegalArgumentException.class,
                () -> new VolumeEvent(0, 0, -1));

        assertThrows(IllegalArgumentException.class,
                () -> new VolumeEvent(0, 0, 128));
    }

    /**
     * Tests the NoteEvent string representation.
     */
    @Test
    public void testNoteEventToString() {
        NoteEvent note = new NoteEvent(7142, 3, 1000, 60);

        assertEquals("Note[7142, 3, 1000, 60]", note.toString());
    }

    /**
     * Tests the VolumeEvent string representation.
     */
    @Test
    public void testVolumeEventToString() {
        VolumeEvent volume = new VolumeEvent(7142, 5, 72);

        assertEquals("Volume[7142, 5, 72]", volume.toString());
    }

    /**
     * Tests that notes come before volume events.
     */
    @Test
    public void testCompareNoteAndVolume() {
        NoteEvent note = new NoteEvent(10, 0, 100, 60);
        VolumeEvent volume = new VolumeEvent(5, 0, 70);

        assertTrue(note.compareTo(volume) < 0);
        assertTrue(volume.compareTo(note) > 0);
    }

    /**
     * Tests that higher-pitched notes come first.
     */
    @Test
    public void testCompareNotesByPitch() {
        NoteEvent high = new NoteEvent(0, 0, 100, 80);
        NoteEvent low = new NoteEvent(10, 0, 100, 40);

        assertTrue(high.compareTo(low) < 0);
        assertTrue(low.compareTo(high) > 0);
    }

    /**
     * Tests notes with equal pitches.
     */
    @Test
    public void testCompareNotesEqualPitch() {
        NoteEvent first = new NoteEvent(0, 0, 100, 60);
        NoteEvent second = new NoteEvent(10, 1, 200, 60);

        assertEquals(0, first.compareTo(second));
    }

    /**
     * Tests that earlier volume events come first.
     */
    @Test
    public void testCompareVolumesByTime() {
        VolumeEvent early = new VolumeEvent(10, 0, 50);
        VolumeEvent late = new VolumeEvent(20, 1, 80);

        assertTrue(early.compareTo(late) < 0);
        assertTrue(late.compareTo(early) > 0);
    }

}
