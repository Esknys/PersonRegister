package com.example.personregister;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class HelloController {

    private ArrayList<Person> personArrayList = new ArrayList<>();

    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

    private PersonRegister personRegister = new PersonRegister(personObservableList);
    private String navn;
    private String alder;
    private LocalDate dato;
    private String epost;
    private String telefonnummer;

    public FileSaverTxt fileSaverTxt = new FileSaverTxt();

    Path path = Paths.get("src/main/java/com/example/personregister/personregister.txt");

    public FileOpenerTxt fileOpenerTxt = new FileOpenerTxt();

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
    private TableView<Event> tableView;

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
            personRegister.addPersoner(person);
            String ut = "";
            for (Person p : personRegister.personer)
            {
                ut += p.getNavn() + " " + p.getAlder() + " " + p.getFoedselsdato() + " " + p.getEpost() + " " + p.getTelefonnummer() + "\n";
            }
            txtRegister.setText(ut);

            fileSaverTxt.save(personRegister.personer, path);

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

        try {
            List<Person> personList = fileOpenerTxt.read("src/main/java/com/example/personregister/personregister.txt");
            System.out.println(personList);

            String ut = "";
            for (Person p : personList)
            {
                ut += p.getNavn() + " " + p.getAlder() + " " + p.getFoedselsdato() + " " + p.getEpost() + " " + p.getTelefonnummer() + "\n";
            }
            txtRegister.setText(ut);

        } catch (IOException ioe) {
            errRegistrer.setText(ioe.getMessage());
        } catch (InputException ie) {
            errRegistrer.setText((ie.getMessage()));
        }
    }
}