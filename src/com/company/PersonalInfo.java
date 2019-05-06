package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalInfo {
    private String name = "";
    private String emailAddress = "";



    private String phone = "";

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
    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        boolean value = false;
        if(validatePhoneNumber(phone)) {
            this.phone = phone;
            value = true;
        }
        return value;

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
    private static boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
            //validating phone number with extension length from 3 to 5
        else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            //validating phone number where area code is in braces ()
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
            //return false if nothing matches the input
        else return false;

    }


}
