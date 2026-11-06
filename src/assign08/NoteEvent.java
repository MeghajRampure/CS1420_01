package assign08;
/**
 * Represents a note event
 *
 * @author Meghaj Rampure
 * @version Nov 5, 2026
 */

public class NoteEvent extends AudioEvent {

    private int duration;
    private int pitch;

    /**
     * Constructs the NoteEvent
     *
     * @param time the starting time
     * @param trackNumber the track number
     * @param duration the duration of a note
     * @param pitch the pitch of a note
     * @throws IllegalArgumentException if duration or pitch are invalid
     */
    public NoteEvent(int time, int trackNumber, int duration, int pitch) {
        super(time, trackNumber);

        if(duration < 0){
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        if(pitch < 0 || pitch > 127){
            throw new IllegalArgumentException("Pitch must be between 0 and 127");
        }
        this.duration = duration;
        this.pitch = pitch;
    }

    /**
     * Returns the duration
     *
     * @return duration of a note
     */

    public int  getDuration() {
        return duration;
    }

    /**
     * Returns the pitch
     *
     * @return the pitch
     */

    public int getPitch() {
        return pitch;
    }

    /**
     * Plays the note
     *
     * @param synth the synthesizer
     */

    @Override
    public void execute(SimpleSynthesizer synth){
        synth.noteOn(getTrackNumber(), pitch);

    }

    /**
     * Stops playing the note.
     *
     * @param synth the synthesizer
     */

    public void complete(SimpleSynthesizer synth) {
        synth.noteOff(getTrackNumber(), pitch);
    }

    /**
     * Returns a string describing the note.
     *
     * @return the note as a string
     */

    @Override
    public String toString() {
        return "Note[" + getTime() + ", " + getTrackNumber() + ", "
                + duration + ", " + pitch + "]";
    }

    /**
     * Compares notes by pitch
     *
     * @param other the audio event to compare
     * @return negative, zero, or positive value
     */

    @Override
    public int compareTo(AudioEvent other) {
        if (other instanceof VolumeEvent) {
            return -1;
        }

        NoteEvent otherNote = (NoteEvent) other;

        if (pitch > otherNote.getPitch()) {
            return -1;
        }
        if (pitch < otherNote.getPitch()) {
            return 1;
        }
        return 0;
    }
}
