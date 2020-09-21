package data;

public class Knight extends Soldier
{
    String movementType;
    int damage;
    int horseLifeLevel;

    public Knight(int age, int height, String genre, int lifeLevel, String movementType, int damage, int horseLifeLevel)
    {
        super(age, height, genre, lifeLevel);
        this.movementType = movementType;
        this.damage = damage;
        this.horseLifeLevel = horseLifeLevel;
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

    public int getHorseLifeLevel()
    {
        return horseLifeLevel;
    }

    public void setHorseLifeLevel(int horseLifeLevel)
    {
        this.horseLifeLevel = horseLifeLevel;
    }
}
