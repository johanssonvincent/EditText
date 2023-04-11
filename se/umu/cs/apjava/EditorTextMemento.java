package se.umu.cs.apjava;

/**
 * EditorTextMemento serves as a container for EditorText object states
 * @author Vincent Johansson (dv14vjn@cs.umu.se)
 */
public class EditorTextMemento {

    private final EditorTextInterface state;

    /**
     * Initializes a new se.umu.se.apjava.EditorTextMemento
     * @param editorState EditorTextInterface of which the state is to be saved
     */
    public EditorTextMemento(EditorTextInterface editorState) {
        state = new EditorText();
        state.setText(editorState.getText());
        state.setCursorPosition(editorState.getCursorPosition(), editorState.getSelectionEndPosition());
    }

    /**
     * Returns the saved EditorTextInterface state
     * @return state EditorTextInterface
     */
    public EditorTextInterface getState() {
        return state;
    }
}
