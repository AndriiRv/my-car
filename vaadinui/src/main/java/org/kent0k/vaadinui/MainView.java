package org.kent0k.vaadinui;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.kent0k.vaadinui.dto.external.WorkerDto;
import org.kent0k.vaadinui.service.client.WorkerFeignClient;

import java.util.List;

@Route
public class MainView extends VerticalLayout {

    private Grid<WorkerDto> grid;

    public MainView(WorkerFeignClient workerFeignClient) {
        this.grid = new Grid<>(WorkerDto.class);
        this.grid.setHeight("200px");
        this.grid.setColumns("id", "firstName", "lastName", "birthDate", "email", "phoneNumber", "hasKids", "hired");
        this.grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        List<WorkerDto> workers = workerFeignClient.fetchAll().getBody();
        this.grid.setItems(!workers.isEmpty() ? workers : List.of(new WorkerDto("None of workers exists")));

        IntegerField idField = new IntegerField();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        DatePicker birthDateField = new DatePicker();
        EmailField emailField = new EmailField();
        TextField phoneNumberField = new TextField();
        Checkbox hasKidsCheckbox = new Checkbox();
        Checkbox isHiredCheckbox = new Checkbox();
        Button addButton = new Button("Add");

        VerticalLayout inputDataLayout = new VerticalLayout();

        FormLayout formLayout = new FormLayout();
        formLayout.addFormItem(idField, "ID");
        formLayout.addFormItem(firstNameField, "First name");
        formLayout.addFormItem(lastNameField, "Last name");
        formLayout.addFormItem(birthDateField, "Birth date");
        formLayout.addFormItem(emailField, "Email");
        formLayout.addFormItem(phoneNumberField, "Phone number");
        formLayout.addFormItem(hasKidsCheckbox, "Does has kids?");
        formLayout.addFormItem(isHiredCheckbox, "Currently hired?");
        formLayout.addFormItem(addButton, "Add new worker");
        inputDataLayout.add(formLayout);

        addButton.addClickListener(click -> {
            workers.add(new WorkerDto(idField.getValue(), firstNameField.getValue(), lastNameField.getValue(), birthDateField.getValue(), emailField.getValue(), phoneNumberField.getValue(), hasKidsCheckbox.getValue(), isHiredCheckbox.getValue()));
            this.grid.setItems(workers);
        });
        addButton.addClickShortcut(Key.ENTER);

        add(new H1("'My car' Workers"), grid, inputDataLayout);
    }
}