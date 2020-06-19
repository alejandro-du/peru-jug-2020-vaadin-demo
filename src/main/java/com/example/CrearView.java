package com.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("crear")
public class CrearView extends VerticalLayout {

    private TextField email = new TextField("Email");
    private PasswordField contrasena = new PasswordField("Contraseña");
    private DatePicker fechaDeNacimiento = new DatePicker("Fecha de nacimiento");
    private Checkbox bloqueado = new Checkbox("Bloqueado");

    public CrearView(PersonaService personaService) {
        BeanValidationBinder<Persona> binder = new BeanValidationBinder<>(Persona.class);
        binder.bindInstanceFields(this);
        binder.setBean(new Persona());

        Button guardar = new Button("Guardar", event -> {
            if (binder.validate().isOk()) {
                personaService.save(binder.getBean());
                Notification.show("Guardado");
                binder.setBean(new Persona());
            }
        });
        add(
                email,
                contrasena,
                fechaDeNacimiento,
                bloqueado,
                guardar,
                new RouterLink("Lista de personas", PersonasView.class)
        );
    }

}
