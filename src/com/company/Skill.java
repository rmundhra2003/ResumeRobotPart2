package com.company;

public class Skill {
    String skillName = "";
    String competency = "";

    public Skill() {

    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getCompetency() {
        return competency;
    }

    public boolean setCompetency(String competency) {
        boolean value = false;
        if(isCompetencyValid(competency)) {
            this.competency = competency;
            value = true;
        }
        return value;
    }


    private boolean isCompetencyValid(String c){
        boolean isValid = false;
        if(c.equalsIgnoreCase("Fundamental") ||
                c.equalsIgnoreCase("Novice") ||
                c.equalsIgnoreCase("Intermediate") ||
                c.equalsIgnoreCase("Advanced") ||
                c.equalsIgnoreCase("Expert"))
            isValid = true;

        return isValid;
    }
}
