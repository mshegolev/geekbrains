package geekbrains.java.lesson5.Zoo;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Parrot extends Bird {
    private int fluHeight;
    public Parrot(int age, String color,String name,int flyHeight){
        super(age,color,name,flyHeight);
    }

    public boolean voice(){
        System.out.println(this.name + " wanna cracker!");
    }

    @Override
    public boolean run() {
        return false;
    }

    public void speak() {
        System.out.println(this.name + " wanna cracker!");
    }
}
