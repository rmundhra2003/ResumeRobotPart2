package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalInfo {
    private String name = "";
    private String emailAddress = "";

    //Arraylist of objects for this person's professional profile
    ArrayList<Education> educationList = new ArrayList<Education>();
    ArrayList<Skill> skillList = new ArrayList<Skill>();
    ArrayList<Experience>experienceList = new ArrayList<Experience>();


    public PersonalInfo() {

    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public boolean setEmailAddress(String emailAddress) {
        boolean value = false;
        if(isEmailValid(emailAddress)) {
            this.emailAddress = emailAddress;
            value = true;
        }
        return value;
    }

    public ArrayList<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(ArrayList<Education> educationList) {
        this.educationList = educationList;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }

    public ArrayList<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(ArrayList<Experience> experienceList) {
        this.experienceList = experienceList;
    }
    private boolean isEmailValid(String email){
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        //Make the comparison case-insensitive.
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }
}
