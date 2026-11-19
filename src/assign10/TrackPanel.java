
package assign10;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Contains controls and editor for one song track.
 *
 * @author Meghaj Rampure
 * @version November 19, 2026
 */
public class TrackPanel extends JPanel implements ActionListener {

    private int trackNumber;
    private SimpleSynthesizer synth;
    private TrackEditor editor;

    private JComboBox<String> instrumentBox;
    private JToggleButton muteButton;
    private JToggleButton noteButton;
    private JToggleButton volumeButton;
    private JToggleButton copyButton;
    private JButton clearButton;

    /**
     * Constructs a panel for one track.
     *
     * @param trackNumber the number of this track
     * @param songLength the duration of the song
     * @param events all audio events for this track
     * @param synth the synthesizer
     */
    public TrackPanel(int trackNumber, int songLength,
                      ArrayList<AudioEvent> events, SimpleSynthesizer synth) {

        this.trackNumber = trackNumber;
        this.synth = synth;

        setLayout(new BorderLayout());

        // Create the instrument selector.
        JPanel controlsPanel = new JPanel(new FlowLayout());

        controlsPanel.add(new JLabel("Instrument:"));

        instrumentBox = new JComboBox<String>(
                new Vector<String>(synth.getInstrumentNames()));
        instrumentBox.addActionListener(this);
        controlsPanel.add(instrumentBox);

        // Create the mute button.
        muteButton = new JToggleButton("Mute");
        muteButton.addActionListener(this);
        controlsPanel.add(muteButton);

        // Create the editing mode buttons.
        noteButton = new JToggleButton("Notes");
        volumeButton = new JToggleButton("Volume");
        copyButton = new JToggleButton("Copy/Paste");

        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(noteButton);
        modeGroup.add(volumeButton);
        modeGroup.add(copyButton);

        noteButton.setSelected(true);

        noteButton.addActionListener(this);
        volumeButton.addActionListener(this);
        copyButton.addActionListener(this);

        controlsPanel.add(noteButton);
        controlsPanel.add(volumeButton);
        controlsPanel.add(copyButton);

        // Create the clear button.
        clearButton = new JButton("Clear Track");
        clearButton.addActionListener(this);
        controlsPanel.add(clearButton);

        add(controlsPanel, BorderLayout.NORTH);

        // Create the editor for this track.
        editor = new TrackEditor(trackNumber, songLength, events, synth);
        add(editor, BorderLayout.CENTER);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    /**
     * Sets the instrument used by this track.
     *
     * @param instrument the index of the instrument
     */
    public void setInstrument(int instrument) {
        synth.setInstrument(trackNumber, instrument);
        instrumentBox.setSelectedIndex(instrument);
    }

    /**
     * Updates the duration of this track's editor.
     *
     * @param songLength the new song duration in ticks
     */
    public void setSongLength(int songLength) {
        editor.setSongLength(songLength);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == muteButton) {
            synth.setMute(trackNumber, muteButton.isSelected());
        }

        if (event.getSource() == noteButton) {
            editor.setMode(TrackEditor.Mode.NOTE);
        }

        if (event.getSource() == volumeButton) {
            editor.setMode(TrackEditor.Mode.VOLUME);
        }

        if (event.getSource() == copyButton) {
            editor.setMode(TrackEditor.Mode.COPY);
        }

        if (event.getSource() == clearButton) {
            editor.clearTrack();
        }

        if (event.getSource() == instrumentBox) {
            int instrument = instrumentBox.getSelectedIndex();
            synth.setInstrument(trackNumber, instrument);
        }
    }
}
