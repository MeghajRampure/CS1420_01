package assign09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SongTest {

    @Test
    public void testAddNoteEvent() {
        Song song = new Song(120, 100);

        song.addNoteEvent(0, 10, 20, 60);
        song.addNoteEvent(0, 5, 15, 70);

        ArrayList<AudioEvent> track = song.getTrack(0);

        assertEquals(2, track.size());
        assertTrue(track.get(0) instanceof NoteEvent);
        assertTrue(track.get(1) instanceof NoteEvent);

        // Events should be sorted by time.
        assertEquals(5, track.get(0).getTime());
        assertEquals(10, track.get(1).getTime());
    }

    @Test
    public void testAddVolumeEvent() {
        Song song = new Song(120, 100);

        song.addVolumeEvent(1, 10, 50);

        ArrayList<AudioEvent> track = song.getTrack(1);

        assertEquals(2, track.size());
        assertTrue(track.get(1) instanceof VolumeEvent);

        // Events should be sorted according to AudioEvent's compareTo method.
        assertEquals(10, track.get(0).getTime());
        assertEquals(20, track.get(1).getTime());
    }

    @Test
    public void testClearTrack() {
        Song song = new Song(120, 100);

        song.addNoteEvent(0, 10, 20, 60);
        song.addVolumeEvent(0, 5, 80);
        song.addNoteEvent(1, 15, 10, 65);

        song.clearTrack(0);

        assertEquals(0, song.getTrack(0).size());
        assertEquals(1, song.getTrack(1).size());
    }

    @Test
    public void testClearAll() {
        Song song = new Song(120, 100);

        song.addNoteEvent(0, 10, 20, 60);
        song.addVolumeEvent(1, 5, 80);
        song.addNoteEvent(9, 15, 10, 65);

        song.clearAll();

        for (int i = 0; i < 10; i++) {
            assertEquals(0, song.getTrack(i).size());
        }
    }

    @Test
    public void testGetTrack() {
        Song song = new Song(120, 100);

        song.addNoteEvent(3, 10, 20, 60);
        song.addVolumeEvent(3, 5, 80);

        ArrayList<AudioEvent> track = song.getTrack(3);

        assertEquals(2, track.size());
        assertTrue(track.get(0) instanceof VolumeEvent);
        assertTrue(track.get(1) instanceof NoteEvent);
    }

    @Test
    public void testEmptyTrack() {
        Song song = new Song(120, 100);

        assertNotNull(song.getTrack(0));
        assertTrue(song.getTrack(0).isEmpty());
    }

    @Test
    public void testClearEmptyTrack() {
        Song song = new Song(120, 100);

        song.clearTrack(4);

        assertTrue(song.getTrack(4).isEmpty());
    }
}