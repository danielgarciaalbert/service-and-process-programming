package data;

public class Character
{
    protected int age;
    protected int height;
    protected String genre;
    protected int lifeLevel;

    public Character(int age, int height, String genre, int lifeLevel)
    {
        this.age = age;
        this.height = height;
        this.genre = genre;
        this.lifeLevel = lifeLevel;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public int getLifeLevel()
    {
        return lifeLevel;
    }

    public void setLifeLevel(int lifeLevel)
    {
        this.lifeLevel = lifeLevel;
    }

    @Override
    public String toString() {
        return "Character{" +
                "age=" + age +
                ", height=" + height +
                ", genre='" + genre + '\'' +
                ", lifeLevel=" + lifeLevel +
                '}';
    }
}
