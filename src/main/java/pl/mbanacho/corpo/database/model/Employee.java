package pl.mbanacho.corpo.database.model;

import pl.mbanacho.corpo.model.input.employee.NewEmployee;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer employeeNumber;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String lastName;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String extension;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officeCode", insertable=false, updatable=false)
    private Office officeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo", insertable=false, updatable=false)
    private Employee reportsTo;

    @Column(columnDefinition = "varchar(50)", nullable = false)
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

    public Office getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(Office officeCode) {
        this.officeCode = officeCode;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
