package data;

public class Citizen extends Character
{
    protected String tool;

    public Citizen(int age, int height, String genre, int lifeLevel, String tool)
    {
        super(age, height, genre, lifeLevel);
        this.tool = tool;
    }
}
