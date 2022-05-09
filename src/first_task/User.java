package first_task;

public class User {
    protected String name;
    protected String surname;
    protected String food;

    public User(){

    }
    public User(String name, String surname, String food) {
        this.name = name;
        this.surname = surname;
        this.food = food;
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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}
