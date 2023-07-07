package com.grupo6.uth.views.registrodeclientes;


import com.grupo6.uth.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Registro de Clientes")
@Route(value = "registro-clientes", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class RegistrodeClientesView extends Div {

    private TextField firstName = new TextField("Identidad");
    private TextField lastName = new TextField("Nombre");
    private TextField email = new TextField("Apellido");
    private TextField phone = new TextField("Telefono");

    private Button cancel = new Button("Cancelar");
    private Button save = new Button("Guardar");

 

    public RegistrodeClientesView() {
        addClassName("registrode-clientes-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        
        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            
            clearForm();
        });
    }

    private void clearForm() {
    	firstName.clear();
    	lastName.clear();
    	email.clear();
    	phone.clear();
    }

    private Component createTitle() {
        return new H3("Personal information");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(firstName, lastName,  phone, email);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

   
    

}
