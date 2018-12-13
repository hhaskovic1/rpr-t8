package sample;


import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<String> list;
    @FXML
    private TextField word = new TextField();

    @FXML
    private Button dugme;
    private File folder = new File("C:\\Users\\User");
    private List<String> holder = new ArrayList<>();


    public Button getSearch() {
        return dugme;
    }

    public void setSearch(Button search) {
        this.dugme = search;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void dugme(ActionEvent event) {
        pretraga(word.getText(), folder);

        for (String s : holder) {
            list.getItems().add(s);
        }
    }


    public void pretraga(String word, File file) {
        if (file == null) return;

        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i] == null) continue;
                else if (files[i].getPath().contains(word)) {
                    holder.add(files[i].getAbsolutePath());
                } else {
                    if (files[i].isDirectory())
                        pretraga(word, files[i]);
                }
            }
        }
    }

    public void wordAction(ActionEvent actionEvent) {
    }

    public void listAction(ListView.EditEvent<String> stringEditEvent) {
    }
}
