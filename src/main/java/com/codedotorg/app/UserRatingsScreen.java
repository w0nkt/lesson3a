package com.codedotorg.app;

import com.codedotorg.MovieApp;
import com.codedotorg.Rating;
import com.codedotorg.User;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class UserRatingsScreen extends AppScreen {

    public UserRatingsScreen(Stage window, int width, int height) {
        super(window, width, height);
    }

    public void showScene() {
        VBox layout = createUserRatingsLayout();
        setAndShowScene(layout);
    }

    // This is the key method you need to implement!
    public VBox createUserRatingsLayout() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        User currentUser = MovieApp.getCurrentUser();

        Label nameLabel = new Label(currentUser.getName() + "'s Ratings");
        vbox.getChildren().add(nameLabel);

        ArrayList<Rating> userRatings = currentUser.getRatings();

        if (userRatings.isEmpty()) {
            vbox.getChildren().add(new Label("You have not rated any movies yet."));
        } else {
            ListView<String> ratingsList = new ListView<>();
            for (Rating rating : userRatings) {
                String item = rating.getMovie().getTitle() + " (" + rating.getMovie().getReleaseYear() + "): " + rating.getScore();
                ratingsList.getItems().add(item);
            }
            vbox.getChildren().add(ratingsList);
        }

        vbox.getChildren().add(getBackButton());
        return vbox;
    }
}
