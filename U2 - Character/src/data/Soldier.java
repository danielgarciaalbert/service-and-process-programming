package data;

public class Soldier extends Character
{
    protected String weapon;


    public Soldier(int age, int height, String genre, int lifeLevel)
    {
        super(age, height, genre, lifeLevel);
    }

    public String getWeapon()
    {

        return weapon;
    }

    public void setWeapon(String weapon)
    {
        this.weapon = weapon;
    }
}
