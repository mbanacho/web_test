package pl.mbanacho.corpo.model.input.employee;

import org.springframework.format.annotation.DateTimeFormat;
import pl.mbanacho.corpo.service.validator.PeselConstraint;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class NewEmployee {

    @NotEmpty
    @Email
    private String email;

    private String verifyEmail;

    private Integer employeeNumber;

    private String lastName;

    private String firstName;

    @Size(min=5, max=30)
    private String extension;

    private String officeCode;

    @PeselConstraint
    private String pesel;

    private Integer reportsTo;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotNull
    @Past
    private LocalDate startDate;

    private String jobTitle;



    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(String verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
