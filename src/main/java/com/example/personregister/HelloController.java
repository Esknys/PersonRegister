package com.example.personregister;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class HelloController {

    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

    public FileOpenerJobj fileOpenerJobj = new FileOpenerJobj();
    Path path1 = Paths.get("personer.jobj");

    private ArrayList<PersonJobj> personJobjs = fileOpenerJobj.openJobj(path1);

    private PersonRegisterJobj personRegisterJobj = new PersonRegisterJobj(personJobjs);

    private PersonRegister personRegister = new PersonRegister(personObservableList);

    ArrayList<Person> personer1 = new ArrayList<>();
    private String navn;
    private String alder;
    private LocalDate dato;
    private String epost;
    private String telefonnummer;

    public FileSaverTxt fileSaverTxt = new FileSaverTxt();

    Path path = Paths.get("src/main/java/com/example/personregister/personregister.txt");

    File file = new File("personer.jobj");

    public FileOpenerTxt fileOpenerTxt = new FileOpenerTxt();

    public FileSaverJobj fileSaverJobj = new FileSaverJobj();

    @FXML
    private TextField txtNavn;

    @FXML
    private TextField txtAlder;

    @FXML
    private DatePicker datovelger;

    @FXML
    private TextField txtEpost;

    @FXML
    private TextField txtTelefonnummer;

    @FXML
    private Button btnRegistrer;

    @FXML
    private Button btnLesFraFil;

    @FXML
    private Label errNavn;

    @FXML
    private Label errDatovelger;

    @FXML
    private Label errAlder;

    @FXML
    private Label errRegistrer;

    @FXML
    private Label errEpost;

    @FXML
    private Label errTelefonnummer;

    @FXML
    private TextArea txtRegister;

    @FXML
    private TableView tableView;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextField txtFilter;

    @FXML
    protected void filtrer() {

        ObservableList<Person> people = FXCollections.observableArrayList();

        people = personObservableList;

            switch (choiceBox.getValue()) {
                case "Navn":
                    people = people.stream().filter(i -> i.getNavn().contains(txtFilter.getText())).collect(Collectors.toCollection(FXCollections::observableArrayList));
                    break;
                case "Alder":
                    people = people.stream().filter(i -> i.getAlder().contains(txtFilter.getText())).collect(Collectors.toCollection(FXCollections::observableArrayList));
                    break;
                case "E-post":
                    people = people.stream().filter(i -> i.getEpost().contains(txtFilter.getText())).collect(Collectors.toCollection(FXCollections::observableArrayList));
                    break;
                case "Telefonnummer":
                    people = people.stream().filter(i -> i.getTelefonnummer().contains(txtFilter.getText())).collect(Collectors.toCollection(FXCollections::observableArrayList));
                    break;
            }

        tableView.setItems(people);
    }

    @FXML
    protected void navnEdited(TableColumn.CellEditEvent<Person, String> event) throws InputException {
        if (PersonValidator.ValidateNavn(event.getNewValue())) {
            event.getRowValue().setNavn(event.getNewValue());
        }

        tableView.refresh();
    }

    @FXML
    protected void alderEdited(TableColumn.CellEditEvent<Person, String> event) throws InvalidAgeException {
        if (PersonValidator.ValidateAlder(event.getNewValue())) {
            event.getRowValue().setAlder(event.getNewValue());
        }

        tableView.refresh();
    }

    @FXML
    protected void foedselsdatoEdited(TableColumn.CellEditEvent<Person, LocalDate> event) throws InvalidDateException {
        if (PersonValidator.ValidateFoedselsdato(event.getNewValue())) {
            event.getRowValue().setFoedselsdato(event.getNewValue());
        }

        tableView.refresh();
    }

    @FXML
    protected void epostEdited(TableColumn.CellEditEvent<Person, String> event) throws InputException {
        if (PersonValidator.ValidateEpost(event.getNewValue())) {
            event.getRowValue().setEpost(event.getNewValue());
        }

        tableView.refresh();
    }

    @FXML
    protected void telefonnummerEdited(TableColumn.CellEditEvent<Person, String> event) throws InputException {
        if (PersonValidator.ValidateTelefonnummer(event.getNewValue())) {
            event.getRowValue().setTelefonnummer(event.getNewValue());
        }

        tableView.refresh();
    }

    @FXML
    protected void onRegistrerButtonClick() {

            navn = txtNavn.getText();

            alder = txtAlder.getText();

            dato = datovelger.getValue();

            epost = txtEpost.getText();

            telefonnummer = txtTelefonnummer.getText();

        try {
            Person person = new Person(navn, alder, dato, epost, telefonnummer);
            PersonJobj personJobj = new PersonJobj(navn, alder, dato, epost, telefonnummer);
            personRegisterJobj.addPersoner(personJobj);
            personRegister.addPersoner(person);
            String ut = "";
            for (Person p : personRegister.personer)
            {
                ut += p.getNavn() + " " + p.getAlder() + " " + p.getFoedselsdato() + " " + p.getEpost() + " " + p.getTelefonnummer() + "\n";
            }
            txtRegister.setText(ut);

            fileSaverTxt.save(personRegister.personer, path);

            for (Person p : personRegister.personer) {
                personer1.add(p);
            }

            fileSaverJobj.saveJobj(personRegisterJobj.personer, file);

            personRegister.attachTableView(tableView);

            txtNavn.setText("");
            txtAlder.setText("");
            txtEpost.setText("");
            txtTelefonnummer.setText("");

        } catch (InputException ie) {
            System.err.println(ie.getMessage());
            errRegistrer.setText(ie.getMessage());
        } catch (InvalidAgeException iae) {
            System.err.println(iae.getMessage());
            errAlder.setText(iae.getMessage());
        } catch (InvalidDateException ide) {
            System.err.println(ide.getMessage());
            errDatovelger.setText(ide.getMessage());
        } catch (IOException ioe) {
            errRegistrer.setText(ioe.getMessage());
        }

    }

    @FXML
    protected void onLesFraFilButtonClick() {

            Path path1 = Paths.get("personer.jobj");
            ArrayList<PersonJobj> personList = fileOpenerJobj.openJobj(path1);
            System.out.println(personList);

            String ut = "";
            for (PersonJobj p : personList)
            {
                ut += p.getNavn() + " " + p.getAlder() + " " + p.getFoedselsdato() + " " + p.getEpost() + " " + p.getTelefonnummer() + "\n";
            }
            txtRegister.setText(ut);

    }

}