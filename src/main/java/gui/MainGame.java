package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import java.io.File;

import java.net.URL;

/**
 * Purpose: to create a new display window using JavaFX of a chess game.
 * Implementation: this file will extend the JavaFX Application class and
 * override the start method to create the GUI.
 * Other notes: At this stage in the game, the board does not need to be
 * functional.
 */
public class MainGame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxmlLocation = getClass().getResource("Format.fxml");
        if (fxmlLocation == null) {
            fxmlLocation = getClass().getResource("/gui/Format.fxml");
        }

        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        // Retrieve the grid from the FXML to draw the chessboard
        GridPane chessBoard = (GridPane) loader.getNamespace().get("chessBoardGrid");

        if (chessBoard != null) {
            drawBoard(chessBoard);
        }

        Scene scene = new Scene(root, 700, 700);
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawBoard(GridPane grid) {
        int size = 8;
        double squareSize = 80.0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle square = new Rectangle(squareSize, squareSize);

                // Alternating colors: red and white
                if ((row + col) % 2 == 0) {
                    square.setFill(Color.BLANCHEDALMOND);
                } else {
                    square.setFill(Color.BROWN);
                }

                StackPane stack = new StackPane();
                stack.getChildren().add(square);

                String iconName = getPieceIcon(row, col);
                if (iconName != null) {
                    File iconFile = new File("src/main/java/gui/icons/" + iconName);
                    if (iconFile.exists()) {
                        // Note: Standard JavaFX 11 Image does not natively support SVG.
                        // However, using the icons as requested:
                        Image image = new Image(iconFile.toURI().toString());
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(60);
                        imageView.setFitHeight(60);
                        imageView.setPreserveRatio(true);
                        stack.getChildren().add(imageView);
                    }
                }

                // Add the stack to the grid
                grid.add(stack, col, row);
            }
        }
    }

    /**
     * Determines which piece icon should be placed at the given row and column
     * based on the layout defined in ConventionalBoardFactory.
     */
    private String getPieceIcon(int row, int col) {
        if (row == 1) return "pawn_white.svg";
        
        // Only placing white pieces for now
        if (row == 0) {
            switch (col) {
                case 0:
                case 7: return "rook_white.svg";
                case 1:
                case 6: return "knight_white.svg";
                case 2:
                case 5: return "bishop_white.svg";
                case 3: return "queen_white.svg";
                case 4: return "king_white.svg";
            }
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}