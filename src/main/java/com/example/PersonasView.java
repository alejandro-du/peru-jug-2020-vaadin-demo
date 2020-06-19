package com.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@Theme(value = Lumo.class, variant = Lumo.DARK)
@CssImport("./css/styles.css")
public class PersonasView extends VerticalLayout {

    public PersonasView(PersonaService personaService) {
        Grid<Persona> grid = new Grid<>();
        grid.addColumn(Persona::getEmail).setHeader("Email");
        grid.addColumn(Persona::getFechaDeNacimiento).setHeader("Fecha de nacimiento");
        grid.addColumn(persona -> persona.isBloqueado() ? "Sí" : "").setHeader("Bloqueado");
        grid.addComponentColumn(persona -> new Button(VaadinIcon.TRASH.create(), event -> {
            personaService.delete(persona);
            grid.setItems(personaService.findAll());
        }));
        grid.setItems(personaService.findAll());
        grid.setColumnReorderingAllowed(true);

        RouterLink link = new RouterLink("Crear nueva", CrearView.class);

        add(link, grid);
    }

}
