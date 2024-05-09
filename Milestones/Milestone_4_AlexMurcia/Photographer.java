package Milestones.Milestone_4_AlexMurcia;

public class Photographer {
    private int photographerId;
    private String name;
    private boolean awarded;

    public Photographer(int photographerId, String name, boolean awarded){
        this.photographerId= photographerId;
        this.name= name;
        this.awarded= awarded;
    }

    public String getName() {
        return name;
    }

    public int getPhotographerId() {
        return photographerId;
    }
    public boolean getAwarded(){
        return awarded;
    }
}
