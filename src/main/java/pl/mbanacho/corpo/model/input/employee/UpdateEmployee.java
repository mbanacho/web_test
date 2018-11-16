package pl.mbanacho.corpo.model.input.employee;

import pl.mbanacho.corpo.model.input.employee.NewEmployee;

import javax.validation.constraints.NotNull;

public class UpdateEmployee extends NewEmployee {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
