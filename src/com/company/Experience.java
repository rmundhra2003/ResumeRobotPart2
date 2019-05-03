package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Experience {
    String company = "";
    String title = "";
    String startDate="";
    String endDate = "";
    ArrayList <String> descriptionList = new ArrayList<String>();

    public Experience() {

    }
    public ArrayList<String> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(ArrayList<String> descriptionList) {
        this.descriptionList = descriptionList;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public boolean setStartDate(String startDate) {
        boolean value = false;
        if(isDateValid(startDate)) {
            this.startDate = startDate;
            value = true;
        }
        return value;
    }

    public String getEndDate() {
        return endDate;
    }

    public boolean setEndDate(String endDate) {
        boolean value = false;
        if(isDateValid(endDate)) {
            this.endDate = endDate;
            value = true;
        }
        return value;
    }


    private boolean isDateValid(String year){
        boolean isValid = false;
        String expression = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
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

}
