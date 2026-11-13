package assign09;

/**
 * Represents a Volume event
 *
 * @author Meghaj Rampure
 * @version Nov 5, 2026
 */

public class VolumeEvent extends AudioEvent {

    private int value;

    /**
     * Constructor for VolumeEvent
     *
     * @param time the starting time
     * @param trackNumber the track number
     * @param value the new volume
     * @throws IllegalArgumentException if value is invalid
     */

    public VolumeEvent(int time, int trackNumber, int value) {
        super(time, trackNumber);

        if(value < 0 || value > 127){
            throw new IllegalArgumentException("value must be between 0 and 127");
        }

        this.value = value;
    }

    /**
     * Returns the volume value
     *
     * @return the volume value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the volume.
     *
     * @param synth the synthesizer
     */
    @Override
    public void execute(SimpleSynthesizer synth) {
        synth.setVolume(getTrackNumber(), value);
    }

    /**
     * Returns a string describing the volume event.
     *
     * @return the volume event as a string
     */
    @Override
    public String toString() {
        return "Volume[" + getTime() + ", " + getTrackNumber()
                + ", " + value + "]";
    }
    /**
     * Compares volume events by time, with earlier times first.
     *
     * @param other the audio event to compare
     * @return a negative, zero, or positive value
     */
    @Override
    public int compareTo(AudioEvent other) {
        if (other instanceof NoteEvent) {
            return 1;
        }

        VolumeEvent otherVolume = (VolumeEvent) other;

        if (getTime() < otherVolume.getTime()) {
            return -1;
        }

        if (getTime() > otherVolume.getTime()) {
            return 1;
        }

        return 0;
    }
}
