package se.umu.cs.apjava;

import java.util.Stack;

/**
 * EditorTextMementoManager used to store  EditorText object states.
 * @author Vincent Johansson (dv14vjn@cs.umu.se)
 */
public class EditorTextMementoManager {

    private final Stack<EditorTextMemento> stack;

    /**
     * Initializes a new se.umu.cs.apjava.EditorTextMementoManager
     */
    public EditorTextMementoManager() {
        stack = new Stack<>();
    }

    /**
     * Save a EditorTextInterface state
     * @param memento EditorText object state saved as EditorTextMemento object
     */
    public void save(EditorTextMemento memento) {
        stack.push(memento);
    }

    /**
     * Returns the most recently saved EditorTextMemento object
     * @return EditorTextMemento object
     */
    public EditorTextMemento restore() {
        return stack.pop();
    }

    /**
     * Checks if there are any EditorTextMemento objects in the stack
     * @return false if stack is empty, true if there are mementos saved
     */
    public boolean hasMemento() {
        return !stack.empty();
    }
}
