package pages.calldoctor2.profiles_interfaces.musor;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

public class PersonDTO {

    private String firstName;
    private String secondName;
    @JsonFormat(pattern = "dd/MM/yyyy")// Formats output date when this DTO is passed through JSON
    @DateTimeFormat(pattern = "dd/MM/yyyy")// Allows dd/MM/yyyy date to be passed into GET request in JSON
    private Date dateOfBirth;
    private String profession;
    private BigDecimal salary;

    public PersonDTO(
            String firstName, String secondName, Date dateOfBirth, String profession, BigDecimal salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.profession = profession;
        this.salary = salary;
    }

    //
    public PersonDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}