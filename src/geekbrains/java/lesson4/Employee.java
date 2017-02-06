package geekbrains.java.lesson4;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Employee {
    private static String name;
    private String surname;
    private String patronymic;
    private String position;
    private String email;
    private String phone;
    private int sallary, age;

    public Employee() {
        name = "John";
        surname = "Doh";
        patronymic = "Vladimirovich";
        position = "cleaner";
        email = name + "." + surname + "@employee.com";
        phone = "+712365498765";
        sallary = 100;
        age = 25;
    }

    public String getName() {
        return name;
    }

    public void getAge(String name) {this.name=name;}

    public int getAge() {
        return age;
    }

    public void getSurnmae(String surname) {this.surname=surname;}

    public String getPosition() {
        return position;
    }

    public int getSallary() {
        return sallary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSallary(int sallary) {
        this.sallary= sallary;
    }




    Employee(String name, String surname, int sallary, int age) {
        this.name = name;
        this.surname = surname;
        this.sallary = sallary;
        this.age = age;
    }


    public Employee(String _name, String _surname, int _sallary, int _age, String _phone, String _email, String _position, String _patronymic) {
        name = _name;
        surname = _surname;
        patronymic = _patronymic;
        position = _position;
        email = _email;
        phone = _phone;
        age = _age;
        sallary = _sallary;
    }

    public Employee(String _name) {
        name = _name;
        surname = "Unknow";
        patronymic = "Unknow";
        position = "Unknow";
        email = "Unknow";
        phone = "Unknow";
        age = 0;
        sallary = 0;
    }

    public String generateInfo() {
        String a;
        return a = "     name = " + name + "\n" +
                "        surname = " + surname + "\n" +
                "        patronymic = " + patronymic + "\n" +
                "        position = " + position + "\n" +
                "        email = " + email + "\n" +
                "        phone = " + phone + "\n" +
                "        sallary = " + sallary + "\n" +
                "        age = " + age;
    }
}
