package geekbrains.java.j2l3;

/**
 * Created by myname on 09.03.17.
 */
class Box implements Comparable<Box>{
    int haight;
    int weight ;
    public Box(int haight,int weight){
        this.haight=haight;
        this.weight = weight;
    }


    @Override
    public int compareTo(Box o) {
        return weight + haight - o.weight - o.haight;

    }
}
