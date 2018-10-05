package pages.calldoctor.profiles_interfaces;

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


//    String address;
//    String complaint;
//    String diagnosis;
//    int type;
//    String phone;
//    int source;
//    Date birthdate;
//    int seriespol;
//    int numberpol;
//
//    public PersonDTO(String profile) throws IOException {
//        File reader = new File("src\\main\\java\\pages\\calldoctor\\profiles_interfaces\\" + profile + ".json");
//        this.proData = new ObjectMapper().readValue(reader, Map.class);
//    }
//
//    public PersonDTO() {
//
//    }


//    @Test
//    public void shouldRetrieveEmbeddedMapValue()
//    {
//        DynamicDto dto = new DynamicDto();
//        Map m = new HashMap();
//        m.put("foo", new String[] {"bar", "bat"});
//        m.put("bar", new InnerClass(new String[] {"foo", "bar", "bat"}));
//        dto.setAttribute("top", m);
//        dto.setAttribute("another", "another value");
//
//        assertEquals("bar", dto.get("top.foo[0]"));
//        assertEquals("bat", dto.get("top.foo[1]"));
//        assertEquals("foo", dto.get("top.bar.embedded[0]"));
//        assertEquals("bar", dto.get("top.bar.embedded[1]"));
//        assertEquals("bat", dto.get("top.bar.embedded[2]"));
//    }
//
//    public class InnerClass
//    {
//        private Object embedded;
//
//        public InnerClass(Object value)
//        {
//            this.embedded = value;
//        }
//    }
}