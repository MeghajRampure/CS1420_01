package assign08;

/**
 * Represents an audio event
 *
 * @author Meghaj Rampure
 * @version Nov 5, 2026
 */

public abstract class AudioEvent {
    private int time;
    private int trackNumber;

    /**
     *Constructor for AudioEvent
     *
     * @param time starting time of the event
     * @param trackNumber the track number
     * @throws IllegalArgumentException If arguments are invalid
     */

    public AudioEvent(int time, int trackNumber) {
        if(time < 0){
            throw new IllegalArgumentException();
        }

        if(trackNumber < 0 || trackNumber > 9){
            throw new IllegalArgumentException();
        }
        this.time = time;
        this.trackNumber = trackNumber;
    }

    /**
     * Returns the starting time
     *
     * @return starting time
     */

    public int getTime() {
        return time;
    }

    /**
     * Returns the track number
     *
     * @return the track number
     */

    public int getTrackNumber() {
        return trackNumber;
    }

    public abstract void execute(SimpleSynthesizer synth);

    public abstract int compareTo(AudioEvent other);
}
