

package geekbrains.java.lesson4;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class lesson4 {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        for (int i = 0; i < 5; i++) {
            employees[i] = new Employee("Worker" + i, "EngineerCategory" + i, 100000 + (i * 10), 41 + i);
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 40) System.out.println(employees[i].generateInfo());
        }

        System.out.println("Good sallary !");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 45) {
                System.out.println("Sallary befor! Name:"+employees[i].getName()+" , Sallary: "+employees[i].getSallary());
                employees[i].setSallary(employees[i].getSallary() + 5000);
                System.out.println("Sallary after! Name:"+employees[i].getName()+" , Sallary: "+employees[i].getSallary());
            }
        }



    }


    public void plusSellary(Employee[] employees){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= 45) ;
        }
    }
    public boolean isAgeMore(Employee[] employees, int age){
        Employee employeeOld = new Employee();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >= age);

        }
        return false;
    }



}
