package se.umu.cs.apjava;

import javax.swing.*;
import java.awt.*;

public class EditorTextGuiBuilder {

    /**
     * Builds the GUI
     * @param editorText EditorText object
     */
    void buildGui(EditorText editorText) {
        var frame = new JFrame();
        frame.setSize(500,500);

        /* Create JETextArea object and configure it */
        JETextArea textArea = new JETextArea(editorText);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        /* Add buttons that can save and restore state of the JETextArea */
        var buttonPanel = new JPanel();
        var saveButton = new JButton("Save");
        EditorTextMementoManager memManager = new EditorTextMementoManager(); /* Stores and handles saved states */
        saveButton.addActionListener(e-> {
            EditorTextMemento mem = new EditorTextMemento(editorText);
            memManager.save(mem);
        });
        var restoreButton = new JButton("Restore");
        restoreButton.addActionListener(e-> {
            /* Restores saved state and sets editorText values to the values of the saved state */
            if (memManager.hasMemento()) {
                EditorTextMemento mem = memManager.restore();
                editorText.setText(mem.getState().getText());
                editorText.setCursorPosition(mem.getState().getCursorPosition(),
                        mem.getState().getSelectionEndPosition());
            }
        });
        buttonPanel.add(saveButton);
        buttonPanel.add(restoreButton);

        /* Add components to frame and make it visible */
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
