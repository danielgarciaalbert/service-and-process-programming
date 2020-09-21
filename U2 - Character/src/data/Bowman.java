package data;


public class Bowman extends Soldier
{
    String movementType;
    int damage;

    public Bowman(int age, int height, String genre, int lifeLevel, String movementType, int damage)
    {
        super(age, height, genre, lifeLevel);
        this.movementType = movementType;
        this.damage = damage;
    }

    public String getMovementType()
    {
        return movementType;
    }

    public void setMovementType(String movementType)
    {
        this.movementType = movementType;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }
}
