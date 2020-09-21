package data;

public class Farmer extends Citizen
{
    String movementType;
    String job;
    int workLevel;

    public Farmer(int age, int height, String genre, int lifeLevel, String tool, String movementType, String job, int workLevel)
    {
        super(age, height, genre, lifeLevel, tool);
        this.movementType = movementType;
        this.job = job;
        this.workLevel = workLevel;
    }

    public String getMovementType()
    {
        return movementType;
    }

    public void setMovementType(String movementType)
    {
        this.movementType = movementType;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    public int getWorkLevel()
    {
        return workLevel;
    }

    public void setWorkLevel(int workLevel)
    {
        this.workLevel = workLevel;
    }
}
