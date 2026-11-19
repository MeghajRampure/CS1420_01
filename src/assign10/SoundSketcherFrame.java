package assign10;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The main window for the SoundSketcher application.
 *
 * @author Meghaj Rampure
 * @version November 19, 2026
 */
public class SoundSketcherFrame extends JFrame
        implements ActionListener, ChangeListener {

    private static final int DEFAULT_TEMPO = 300;
    private static final int DEFAULT_SONG_LENGTH = 16;

    private Song song;
    private TrackPanel[] trackPanels;

    private JToggleButton playButton;
    private JToggleButton loopButton;
    private JSlider tempoSlider;
    private JSpinner lengthSpinner;
    private JTabbedPane tabbedPane;

    /**
     * Constructs the main window for application.
     * Initializes the song, track panels, and GUI components.
     * Sets up the layout doe the users
     */
    public SoundSketcherFrame() {
        song = new Song(DEFAULT_TEMPO, DEFAULT_SONG_LENGTH);
        trackPanels = new TrackPanel[10];

        setTitle("SoundSketcher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 800));
        setLayout(new BorderLayout());

        JPanel controlsPanel = new JPanel(new FlowLayout());

        playButton = new JToggleButton("Play");
        playButton.addActionListener(this);
        controlsPanel.add(playButton);

        loopButton = new JToggleButton("Loop");
        loopButton.addActionListener(this);
        controlsPanel.add(loopButton);

        JLabel tempoLabel = new JLabel("Tempo (ticks per minute):");
        controlsPanel.add(tempoLabel);

        tempoSlider = new JSlider(
                JSlider.HORIZONTAL, 20, 600, DEFAULT_TEMPO);
        tempoSlider.setMajorTickSpacing(100);
        tempoSlider.setMinorTickSpacing(20);
        tempoSlider.setPaintTicks(true);
        tempoSlider.setPaintLabels(true);
        tempoSlider.addChangeListener(this);
        controlsPanel.add(tempoSlider);

        JLabel lengthLabel = new JLabel("Song length (ticks):");
        controlsPanel.add(lengthLabel);

        lengthSpinner = new JSpinner(
                new SpinnerNumberModel(DEFAULT_SONG_LENGTH, 4, 1024, 4));
        lengthSpinner.addChangeListener(this);
        controlsPanel.add(lengthSpinner);

        add(controlsPanel, BorderLayout.NORTH);

        // Create the track panels and their tabs.
        tabbedPane = new JTabbedPane();

        for (int trackNum = 0; trackNum < trackPanels.length; trackNum++) {
            trackPanels[trackNum] = new TrackPanel(
                    trackNum,
                    song.getSongLength(),
                    song.getTrack(trackNum),
                    song.getSynthesizer());

            tabbedPane.addTab(
                    "Track " + (trackNum + 1),
                    trackPanels[trackNum]);
        }

        add(tabbedPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This is for the clicks and loops in the app
     *
     * @param event the action event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == playButton) {
            if (playButton.isSelected()) {
                song.play();
                playButton.setText("Stop");
            } else {
                song.stop();
                playButton.setText("Play");
            }
        }

        if (event.getSource() == loopButton) {
            song.enableLoop(loopButton.isSelected());
        }
    }

    /**
     * This is to handle changes in the tempo slider and length spinner.
     *
     * @param event the change event
     */
    @Override
    public void stateChanged(ChangeEvent event) {
        if (event.getSource() == tempoSlider) {
            song.setTempo(tempoSlider.getValue());
        }

        if (event.getSource() == lengthSpinner) {
            int newLength = (Integer) lengthSpinner.getValue();

            song.setSongLength(newLength);

            for (int i = 0; i < trackPanels.length; i++) {
                trackPanels[i].setSongLength(newLength);
            }
        }
    }
}
