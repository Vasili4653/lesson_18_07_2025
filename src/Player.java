import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Player implements Serializable {//для сериализации нужно наследование от интерфейса Serializable

    private static final long serialVersionUID = 1;
    private float health;
    public String name;
    public int mana;

    public int rank;

    public int age;

    public float test;


    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        /*try{
            ois.defaultReadObject();
        } catch (Exception e){
            // TODO
            System.out.println("error");
        }*/
        //this.health = ois.readFloat();
        ObjectInputStream.GetField fields = ois.readFields();
        System.out.println(fields);

    }
}
