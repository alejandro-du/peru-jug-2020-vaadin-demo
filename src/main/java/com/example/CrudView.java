package com.example;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("crud")
public class CrudView extends VerticalLayout {

    public CrudView(PersonaService personaService) {
        GridCrud<Persona> crud = new GridCrud<>(Persona.class);
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.setSizeFull();
        crud.setFindAllOperation(personaService::findAll);
        crud.setAddOperation(personaService::save);
        crud.setUpdateOperation(personaService::update);
        crud.setDeleteOperation(personaService::delete);
        add(crud);
        setSizeFull();
    }
}
