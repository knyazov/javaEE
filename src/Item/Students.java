package Item;

public class Students {
    private Long id;
    private String name;
    private String surname;
    private String birth_date;
    private String city;
    private Countries country;


    public Students() {
    }

    public Students(Long id, String name, String surname, String birth_date, String city, Countries country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }
}
