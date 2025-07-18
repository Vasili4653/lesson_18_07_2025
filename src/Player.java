import java.io.Serializable;

public class Player implements Serializable {//для сериализации нужно наследование от интерфейса Serializable

    private static final long serialVersionUID = 1;
    private float health;
    public String name;
    public int mana;

    public int rank;


    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }
}
