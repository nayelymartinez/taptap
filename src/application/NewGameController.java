package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.Window;
import application.Main;
import java.util.HashMap;
import java.util.Iterator;

public class NewGameController implements Initializable {
	private Stage stage;
	private static String song;
	private static String song_file;
	private HashMap<String, String> song_list = new HashMap<String, String>();


	@FXML
	private Button readTutorialButton;

    @FXML
    private Button startGameButton;

    @FXML
    private ComboBox<String> selectSongDropdown;

	@Override	// This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL location, ResourceBundle resources) {
		populateDropdownMenus();

		// Dropdown listeners
		selectSongDropdown.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String old_song, String new_song) {
                set_song(new_song);
                get_song();
            }
		});

		// Button listeners
		assert readTutorialButton != null : "fx:id=\"readTutorialButton\" was not injected: check your FXML file 'new_game_screen.fxml'.";
		assert startGameButton != null : "fx:id=\"startGameButton\" was not injected: check your FXML file 'new_game_screen.fxml'.";

		readTutorialButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	loadTutorial(readTutorialButton);
            }
        });

		startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	loadNewGame(startGameButton);
            }
        });
	}

	/** Display song and difficulty options in dropdown menus
	 * @return
	 */
	private void populateDropdownMenus() {
		// Populate drop down menus
		selectSongDropdown.getItems().addAll(
				"Seven Nation Army - The White Stripes (Easy)",
				"Holy Ghost - Børns (Hard)",
				"Lange Her - Cro ft. Teesy (Legendary)");
	}

	// Getters
	protected static String get_song() {
		System.out.println("Current song:"+song);
		return song;
	}

	protected static String get_song_file() {
		System.out.println("Song file: " + song_file);
		return song_file;
	}


	// Setters
	protected void set_song(String new_song) {
		song = new_song;
	}

	protected void set_song_file(String new_song) {
		song_file = song_list.get(get_song());
	}

	/**
	 * Creates a hashmap of song files as values
	 * @return
	 */
	protected void createSongMap() {
		song_list.put("Seven Nation Army - The White Stripes", "seven_nation_army.mp3");
		song_list.put("Holy Ghost - Børns", "holy_ghost.mp3");
		song_list.put("Lange Her - Cro ft. Teesy", "lange_her.mp3");
		printSongMap();
	}

	/**
	 * Prints hashmap of song files as values
	 * @return
	 */
	private void printSongMap() {
		Set set = song_list.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			HashMap.Entry mentry = (HashMap.Entry)iterator.next();
			System.out.print("Key is: "+ mentry.getKey() + " & Value is: ");
			System.out.println(mentry.getValue());
		}
	}

	/** Display tutorial
	 * @return
	 */
	public void loadTutorial(Button readTutorialButton) {
		FXMLLoader tut_first_loader = new FXMLLoader(Main.class.getResource("/view/tutorial_first_screen.fxml"));
		Main.switchScreen(tut_first_loader,readTutorialButton);
	}

	/** Display new game screen
	 * @return
	 */
	public void loadNewGame(Button button) {
		FXMLLoader new_game_loader = new FXMLLoader(Main.class.getResource("/view/play_screen.fxml"));
		Main.switchScreen(new_game_loader, button);
	}

	/** Returns the main stage
	 * @return
	 */
	public Stage getCurrentStage(Button button) {
		stage = (Stage) button.getScene().getWindow();
		return stage;
	}

}




/***first way to do it***/
//Game game = new Game(int difficulty_level, Str song_title);
//main.getGame(game);
/***second way to do it***/
//main.getSongInfo(int difficulty_level, Str song_title);
//AnchorPane settingsScreen = (AnchorPane) loader.load();
//
//if (!settingsScreen.isVisible()) {
//	settingsScreen.setVisible(true);
//}
//// Replace with new scene
//Scene scene = new Scene(settingsScreen);
//Stage currStage = getCurrentStage(button);
//currStage.setScene(scene);
//currStage.show();



/* OLD CODE FOR LOADING CONTROLLER */
// Listen for button clicks
//assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'new_game_screen.fxml'.";

//// Switch to tutorial scene (via TutorialControllerOne)
//backButton.setOnAction(new EventHandler<ActionEvent>() {
//@Override
//public void handle(ActionEvent event) {
//	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/tutorial2.fxml"));
//	TutorialControllerOne controller = fxmlLoader.<TutorialControllerOne>getController();
//	controller.loadTutorial2();
//}
//});
