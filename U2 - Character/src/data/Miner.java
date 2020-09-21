package data;

public class Miner extends Citizen
{
    String movementType;
    String job;
    int fatigueLevel;

    public Miner(int age, int height, String genre, int lifeLevel, String tool, String movementType, String job, int fatigueLevel)
    {
        super(age, height, genre, lifeLevel, tool);
        this.movementType = movementType;
        this.job = job;
        this.fatigueLevel = fatigueLevel;
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

    public int getFatigueLevel()
    {
        return fatigueLevel;
    }

    public void setFatigueLevel(int fatigueLevel)
    {
        this.fatigueLevel = fatigueLevel;
    }
}
