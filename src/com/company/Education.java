package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Education {
    String degree = "";
    String major = "";
    String schoolName = "";
    String year = "";

    public Education() {

    }

    public String getDegree() {
        return degree;
    }

    public boolean setDegree(String degree) {
        boolean value = false;
        if(isDegreeValid(degree)) {
            this.degree = degree;
            value = true;
        }
        return value;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getYear() {
        return year;
    }

    public boolean setYear(String year) {
        boolean value = false;
        if(isYearValid(year)) {
            this.year = year;
            value = true;
        }
        return value;
    }


    private boolean isYearValid(String year){
        boolean isValid = false;
        String expression = "^\\d{4}$";
        //String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = year;
        //Make the comparison case-insensitive.
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }
    private boolean isDegreeValid(String degree){
        boolean isValid = false;
        if(degree.equalsIgnoreCase("Associate") ||
           degree.equalsIgnoreCase("Bachelor") ||
           degree.equalsIgnoreCase("Master") ||
           degree.equalsIgnoreCase("Phd"))
            isValid = true;

        return isValid;
    }

}
