package com.github.grishasht.docdropper.client;

import com.github.grishasht.docdropper.client.model.File;
import com.github.grishasht.docdropper.client.model.Similarity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller
{

    @FXML
    private Button uploadButton;

    @FXML
    private Button getAllButton;

    @FXML
    private Button downloadButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button calculateAllButton;

    @FXML
    private TableView<File> filesTable;

    @FXML
    private TableColumn<?, ?> fileNameColumn;

    @FXML
    private TableColumn<?, ?> fileSizeColumn;

    @FXML
    private TableColumn<?, ?> fileDateUploadedColumn;

    @FXML
    private TableColumn<?, ?> fileModifiedDate;

    @FXML
    private TableView<Similarity> similaritiesTable;

    @FXML
    private TableColumn<?, ?> simNameColumn;

    @FXML
    private TableColumn<?, ?> simSizeColumn;

    @FXML
    private TableColumn<?, ?> similarityColumn;


    @FXML
    void initialize() {
        assert uploadButton != null : "fx:id=\"uploadButton\" was not injected: check your FXML file 'main.fxml'.";
        assert getAllButton != null : "fx:id=\"getAllButton\" was not injected: check your FXML file 'main.fxml'.";
        assert downloadButton != null : "fx:id=\"downloadButton\" was not injected: check your FXML file 'main.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'main.fxml'.";
        assert calculateAllButton != null : "fx:id=\"calculateAllButton\" was not injected: check your FXML file 'main.fxml'.";
        assert filesTable != null : "fx:id=\"filesTable\" was not injected: check your FXML file 'main.fxml'.";
        assert fileNameColumn != null : "fx:id=\"fileNameColumn\" was not injected: check your FXML file 'main.fxml'.";
        assert fileSizeColumn != null : "fx:id=\"fileSizeColumn\" was not injected: check your FXML file 'main.fxml'.";
        assert fileDateUploadedColumn != null : "fx:id=\"fileDateUploadedColumn\" was not injected: check your FXML file 'main.fxml'.";
        assert fileModifiedDate != null : "fx:id=\"fileModifiedDate\" was not injected: check your FXML file 'main.fxml'.";
        assert similaritiesTable != null : "fx:id=\"similaritiesTable\" was not injected: check your FXML file 'main.fxml'.";
        assert simNameColumn != null : "fx:id=\"simNameColumn\" was not injected: check your FXML file 'main.fxml'.";
        assert simSizeColumn != null : "fx:id=\"simSizeColumn\" was not injected: check your FXML file 'main.fxml'.";
        assert similarityColumn != null : "fx:id=\"similarityColumn\" was not injected: check your FXML file 'main.fxml'.";

        final float lab1Size = 24.64f;
        final float doc1Size = 14.3f;
        final float doc2Size = 34.23f;
        final float lab2Size = 44.22f;
        final float doc3Size = 456.1f;
        final float doc4Size = 3.0f;
        final float doc5Size = 98.64f;
        final float doc6Size = 33.76f;
        final float doc7Size = 80.564f;
        final ObservableList<File> fileObservableList = FXCollections.observableArrayList(
                new File("lab1.docx", lab1Size, "25.05.2020", "25.05.2020"),
                new File("doc1.docx", doc1Size, "26.05.2020", "26.05.2020"),
                new File("doc2.docx", doc2Size, "26.05.2020", "28.05.2020"),
                new File("lab2.docx", lab2Size, "26.05.2020", "30.05.2020"),
                new File("doc3.docx", doc3Size, "25.05.2020", "25.05.2020"),
                new File("doc4.docx", doc4Size, "28.05.2020", "30.05.2020"),
                new File("doc5.docx", doc5Size, "25.05.2020", "25.05.2020"),
                new File("doc6.docx", doc6Size, "26.05.2020", "30.05.2020"),
                new File("doc7.docx", doc7Size, "27.05.2020", "27.05.2020")
        );

        fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        fileSizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        fileDateUploadedColumn.setCellValueFactory(new PropertyValueFactory<>("uploadedDate"));
        fileModifiedDate.setCellValueFactory(new PropertyValueFactory<>("modifiedDate"));

        filesTable.setItems(fileObservableList);

        final ObservableList<Similarity> similarityObservableList = FXCollections.observableArrayList(
                new Similarity("doc2.docx", doc2Size, 81.5f),
                new Similarity("doc7.docx", doc7Size, 79.3f),
                new Similarity("lab2.docx", lab2Size, 73.7f),
                new Similarity("lab1.docx", lab1Size, 59.0f),
                new Similarity("doc5.docx", doc5Size, 57.5f),
                new Similarity("doc4.docx", doc4Size, 52.4f),
                new Similarity("doc7.docx", doc7Size, 49.3f),
                new Similarity("doc3.docx", doc3Size, 43.3f),
                new Similarity("doc1.docx", doc1Size, 24.8f)
        );

        simNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        simSizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        similarityColumn.setCellValueFactory(new PropertyValueFactory<>("similarity"));

        similaritiesTable.setItems(similarityObservableList);
    }

    @FXML
    void calculateAllSimilarities(ActionEvent event)
    {

    }

    @FXML
    void deleteFile(ActionEvent event)
    {

    }

    @FXML
    void detAllFiles(ActionEvent event)
    {

    }

    @FXML
    void downloadFile(ActionEvent event)
    {

    }

    @FXML
    void uploadFile(ActionEvent event)
    {

    }


}