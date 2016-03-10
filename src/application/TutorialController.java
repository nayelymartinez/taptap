package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TutorialController implements Initializable {

	/* Page 1 Tutorial buttons */
    @FXML
    private Button nextButton;

    @FXML
    private Button skipButton;

	@Override	// This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL location, ResourceBundle resources) {
        // All @FXML variables will have been injected
		assert nextButton != null : "fx:id=\"nextButton\" was not injected: check your FXML file 'tutorial_first_screen.fxml'.";
		assert skipButton != null : "fx:id=\"skipButton\" was not injected: check your FXML file 'tutorial_first_screen.fxml'.";

		// Go straight to new game screen
        skipButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	loadNewGame(skipButton);
            }

        });

        // Continue to second tutorial page
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	loadTutorialTwo(nextButton);
            }
        });


	}

	/** Display the second tutorial scene
	 * @return
	 */
	protected void loadTutorialTwo(Button button) {
		FXMLLoader tut_second_loader = new FXMLLoader(Main.class.getResource("/view/tutorial_second_screen.fxml"));
		Main.switchScreen(tut_second_loader, button);

	}

	/** Display the new game screen
	 * @return
	 */
	protected void loadNewGame(Button button) {
		FXMLLoader new_game_loader = new FXMLLoader(Main.class.getResource("/view/new_game_screen.fxml"));
		Main.switchScreen(new_game_loader, button);
	}

}
