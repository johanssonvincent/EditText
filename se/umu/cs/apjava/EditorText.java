package se.umu.cs.apjava;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of se.umu.cs.apjava.EditorTextInterface
 * @author Vincent Johansson (dv14vjn@cs.umu.se)
 */
public class EditorText implements EditorTextInterface {

    private String text;
    private final List<EditorTextChangeListener> listeners;
    private int cursorPos;
    private int selectionEndPos;

    /**
     * Initializes a new se.umu.cs.apjava.EditorText
     */
    public EditorText() {
        text = "";
        listeners = new ArrayList<>();
        cursorPos = 0;
        selectionEndPos = 0;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
        notifyListeners();
    }

    @Override
    public void setCursorPosition(int cursorPosition, int selectionEnd) {
        cursorPos = cursorPosition;
        selectionEndPos = selectionEnd;
        notifyListeners();
    }

    @Override
    public int getCursorPosition() {
        return cursorPos;
    }

    @Override
    public int getSelectionEndPosition() {
        return selectionEndPos;
    }

    @Override
    public void addChangeListener(EditorTextChangeListener listener) {
        if (!listeners.contains(listener)) listeners.add(listener);
    }

    @Override
    public void removeChangeListener(EditorTextChangeListener editorTextChangeListener) {
        listeners.remove(editorTextChangeListener);
    }

    /**
     * Method used to notify the objects listeners
     */
    protected void notifyListeners() {
        for (EditorTextChangeListener l : listeners) {
            l.stateUpdated(this);
        }
    }
}
