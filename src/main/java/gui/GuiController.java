package gui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

/**
 * Purpose: to control input to the chessboard, when a user clicks and moves a pices, etc
 * Implementation: this file will read from the Format.fxml file and control the gameplay .java files in game/ and main/
 * Notes: -
 */
public class GuiController {

    @FXML
    private GridPane chessBoardGrid;

    @FXML
    public void initialize() {
        // Setup initial interactions or data bindings here in the future
    }
}