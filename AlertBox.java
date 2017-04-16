package seel.javafx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertBox {
    private Stage window = new Stage();
    private String text = "default";
    private String titleText = "Alert";
    private String buttonText = "Ok";

    private VBox layout = new VBox(10);
    private Label textLabel = new Label(text);
    private Button button = new Button(buttonText);

    public static class Style {
        public static int LIGHT = 1;
        public static int DARK = 2;
        public static int DARK_SECONDARY = 3;
    }

    public AlertBox(String text) {
        setStyle(Style.LIGHT);
        this.text = text;
        setButtonSize();
    }

    public AlertBox(String text, int style) {
        setStyle(style);
        this.text = text;

        setButtonSize();
    }

    private void setButtonSize() {
        button.setMinWidth(75);
        button.setMaxWidth(75);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void display() {
        window.initStyle(StageStyle.UTILITY);
        window.setResizable(false);
        window.setTitle(titleText);

        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(250, 125);
        layout.setMaxSize(250, 125);

        textLabel.setText(text);

        button.setText(buttonText);

        button.setOnAction(event -> {
            window.close();
        });

        layout.getChildren().addAll(textLabel, button);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public void setStyle(int style) {
        if (style == Style.LIGHT) {
            layout.setStyle("-fx-background-color: white");
            layout.setStyle("-fx-text-fill: black");

            button.setStyle("-fx-background-color: #d6d4d0;");
            button.setOnMouseEntered(event -> {
                button.setStyle("-fx-background-color: #e2e0dc;");
            });
            button.setOnMousePressed(event -> {
                button.setStyle("-fx-background-color: #aeaca9;");
            });
            button.setOnMouseExited(event -> {
                button.setStyle("-fx-background-color: #d6d4d0;");
            });
        } else if (style == Style.DARK) {
            layout.setStyle("-fx-background-color: #504f4e");
            textLabel.setStyle("-fx-text-fill: white;");

            button.setStyle("-fx-background-color: #696865; -fx-text-fill: white;");
            button.setOnMouseEntered(event -> {
                button.setStyle("-fx-background-color: #7d7c78; -fx-text-fill: white;");
            });
            button.setOnMousePressed(event -> {
                button.setStyle("-fx-background-color: #5a5957; -fx-text-fill: white;");
            });
            button.setOnMouseExited(event -> {
                button.setStyle("-fx-background-color: #696865; -fx-text-fill: white;");
            });
        } else if (style == Style.DARK_SECONDARY) {
            layout.setStyle("-fx-background-color: #504f4e; -fx-border-color: white; -fx-border-width: 2px;");
            textLabel.setStyle("-fx-text-fill: white;");

            button.setStyle("-fx-background-color: #696865; -fx-text-fill: white;");
            button.setOnMouseEntered(event -> {
                button.setStyle("-fx-background-color: #7d7c78; -fx-text-fill: white;");
            });
            button.setOnMousePressed(event -> {
                button.setStyle("-fx-background-color: #5a5957; -fx-text-fill: white;");
            });
            button.setOnMouseExited(event -> {
                button.setStyle("-fx-background-color: #696865; -fx-text-fill: white;");
            });
        } else {
            setStyle(Style.LIGHT);
        }
    }
}