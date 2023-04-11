package se.umu.cs.apjava;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EditorTextGuiBuilder().buildGui(new EditorText()));
    }
}
