package com.grupo6.uth.views.registrodevehículo;

import com.grupo6.uth.data.entity.Vehiculo;
import com.grupo6.uth.views.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

@PageTitle("Registro de Vehículo")
@Route(value = "registro-vehiculo/:vehiculoID?/:action?(edit)", layout = MainLayout.class)
public class RegistrodeVehículoView extends Div implements BeforeEnterObserver {

    private final String VEHICULO_ID = "vehiculoID";
    private final String VEHICULO_EDIT_ROUTE_TEMPLATE = "registro-vehiculo/%s/edit";

    private final Grid<Vehiculo> grid = new Grid<>(Vehiculo.class, false);

    private TextField marca;
    private TextField modelo;
    private TextField placa;
    private DatePicker fechaentrada;
    private DatePicker fechasalida;
    private TextField servicio;
    private TextField costo;

    private final Button cancel = new Button("Cancel");
    private final Button save = new Button("Save");



    private Vehiculo vehiculo;


    public RegistrodeVehículoView( ) {
        addClassNames("registrode-vehículo-view");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("marca").setAutoWidth(true);
        grid.addColumn("modelo").setAutoWidth(true);
        grid.addColumn("placa").setAutoWidth(true);
        grid.addColumn("fechaentrada").setAutoWidth(true);
        grid.addColumn("fechasalida").setAutoWidth(true);
        grid.addColumn("servicio").setAutoWidth(true);
        grid.addColumn("costo").setAutoWidth(true);

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(VEHICULO_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(RegistrodeVehículoView.class);
            }
        });

      

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.vehiculo == null) {
                    this.vehiculo = new Vehiculo();
                }
              
                clearForm();
                refreshGrid();
                Notification.show("Data updated");
                UI.getCurrent().navigate(RegistrodeVehículoView.class);
            } catch (ObjectOptimisticLockingFailureException exception) {
                Notification n = Notification.show(
                        "Error updating the data. Somebody else has updated the record while you were making changes.");
                n.setPosition(Position.MIDDLE);
                n.addThemeVariants(NotificationVariant.LUMO_ERROR);
            } catch (Exception el) {
                Notification.show("Failed to update the data. Check again that all values are valid");
            }
        });
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<Long> vehiculoId = event.getRouteParameters().get(VEHICULO_ID).map(Long::parseLong);
        if (vehiculoId.isPresent()) {
            /*Optional<Vehiculo> vehiculoFromBackend = vehiculoService.get(vehiculoId.get());
            if (vehiculoFromBackend.isPresent()) {
                populateForm(vehiculoFromBackend.get());
            } else {
                Notification.show(String.format("The requested vehiculo was not found, ID = %s", vehiculoId.get()),
                        3000, Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(RegistrodeVehículoView.class);
            }*/
        }
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setClassName("editor-layout");

        Div editorDiv = new Div();
        editorDiv.setClassName("editor");
        editorLayoutDiv.add(editorDiv);

        FormLayout formLayout = new FormLayout();
        marca = new TextField("Marca");
        modelo = new TextField("Modelo");
        placa = new TextField("Placa");
        fechaentrada = new DatePicker("Fechaentrada");
        fechasalida = new DatePicker("Fechasalida");
        servicio = new TextField("Servicio");
        costo = new TextField("Costo");
        formLayout.add(marca, modelo, placa, fechaentrada, fechasalida, servicio, costo);

        editorDiv.add(formLayout);
        createButtonLayout(editorLayoutDiv);

        splitLayout.addToSecondary(editorLayoutDiv);
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("button-layout");
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setClassName("grid-wrapper");
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getDataProvider().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(Vehiculo value) {
        this.vehiculo = value;
        

    }
}
