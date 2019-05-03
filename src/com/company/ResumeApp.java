package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/*
        @@@ResumeApp:
        Program that will allow a user to enter in:
        a name,
        an email address,
        at least 1 educational achievement:
        degree type (Associate's, Bachelor's, Master's, PhD, etc.),
        major,
        university name,
        graduation year,
        at least 1 work experience:
        company,
        job title,
        start date,
        end date,
        at least 1 job description
        at least 3 skills:
        skill name
        rating/proficiency (Fundamental, Novice, Intermediate, Advanced, Expert)

        and prints out a pretty resume as output!!!!
        ******
        Care has been taken to validate dates, competency, degree information, year of graduation using Regular
        expressions
        ******
*/

public class ResumeApp {

    static PersonalInfo personalInfo = new PersonalInfo();
    public static void main(String[] args) {

        //Prompt user for input
        promptUserInput();

        //Display resume
        displayResumeApp();
    }
    //Prompt user for personal Info
    public static void promptUserInput() {
        boolean input = true;
        ArrayList<Education> eList = personalInfo.getEducationList();
        ArrayList<Skill> sList = personalInfo.getSkillList();
        ArrayList<Experience>expList = personalInfo.getExperienceList();

        Scanner keyboard = new Scanner(System.in);


        System.out.print("Enter your name: ");
        personalInfo.setName(keyboard.nextLine());
        System.out.print("Enter your email address: ");

        //Validate email address
        while(!personalInfo.setEmailAddress(keyboard.nextLine())) {
            System.out.print("Email address is invalid please enter valid email address: ");
        }

        //Input the Education
        while(input) {
            Education e = new Education();
            System.out.print("Enter degree type (Associate|Bachelor|Master|Phd): ");
            //Validate degree and set
            while (!e.setDegree(keyboard.nextLine())) {
                System.out.print("Degree is invalid please enter valid degree: ");
            }
            //Enter major
            System.out.print("Enter major: ");
            e.setMajor(keyboard.nextLine());

            //Enter school name
            System.out.print("Enter school name: ");
            e.setSchoolName(keyboard.nextLine());

            //Enter year graduated
            System.out.print("Enter year graduated: ");
            while(!e.setYear(keyboard.nextLine())) {
                System.out.print("Enter valid year: ");
            }

            //Add this to personalInfo
            eList.add(e);

            //prompt if more education is to be added
            System.out.print("Do you want to add more education(Y|N): ");
            if(keyboard.nextLine().equalsIgnoreCase("N"))
                input = false;
        }

        //Input Skill minimum of 3 skills
        input = true;
        for(int i = 0; i < 3; i++) {
            Skill s = new Skill();
            System.out.print("Enter skill name: ");
            s.setSkillName(keyboard.nextLine());
            System.out.print("Enter competency (Fundamental|Novice|Intermediate|Advanced|Expert: ");
            while(!s.setCompetency(keyboard.nextLine())) {
                System.out.print("Enter valid competency (Fundamental|Novice|Intermediate|Advanced|Expert: ");
            }
            //Add skill to skill list
            sList.add(s);
        }
        //Prompt if more skills need to be added
        while(input) {
            System.out.print("Do you want to add more skills(Y|N): ");
            if(keyboard.nextLine().equalsIgnoreCase("N"))
                break;
            Skill s = new Skill();
            System.out.print("Enter skill name: ");
            s.setSkillName(keyboard.nextLine());
            System.out.print("Enter competency (Fundamental|Novice|Intermediate|Advanced|Expert: ");
            while(!s.setCompetency(keyboard.nextLine())) {
                System.out.print("Enter valid competency (Fundamental|Novice|Intermediate|Advanced|Expert: ");
            }
            //Add skill to skill list
            sList.add(s);
        }

        //Input experience
        input = true;
        while(input) {
            Experience e = new Experience();
            ArrayList<String> dList = e.getDescriptionList();
            System.out.print("Enter company name: ");
            e.setCompany(keyboard.nextLine());
            System.out.print("Enter title: ");
            e.setTitle(keyboard.nextLine());
            System.out.print("Enter start date in MM/DD/YYYY,: ");
            while(!e.setStartDate(keyboard.nextLine())) {
                System.out.print("Enter valid start date in MM/DD/YYYY,: ");
            }
            System.out.print("Enter end date in MM/DD/YYYY: ");
            while(!e.setEndDate(keyboard.nextLine())) {
                System.out.print("Enter valid end date in MM/DD/YYYY,: ");
            }
            //Validate start date is less than end date
            while(!validateDates(e.getStartDate(), e.getEndDate())) {
                System.out.println("Start date is after end date");
                while(!e.setStartDate(keyboard.nextLine())) {
                    System.out.print("Enter valid start date in MM/DD/YYYY,: ");
                }
                System.out.print("Enter end date in MM/DD/YYYY: ");
                while(!e.setEndDate(keyboard.nextLine())) {
                    System.out.print("Enter valid end date in MM/DD/YYYY,: ");
                }
            }
            //Get job description
            while(true) {
                System.out.print("Enter job description: ");
                dList.add(keyboard.nextLine());
                System.out.print("Do you want to enter more duties(Y|N): ");
                if(keyboard.nextLine().equalsIgnoreCase("N"))
                    break;
            }
            //Add this to experience list
            expList.add(e);
            //Prompt user for more input
            System.out.print("Do you want to add more experience(Y|N): ");
            if(keyboard.nextLine().equalsIgnoreCase("N"))
                break;
        }
    }
    //Function to validate the start date and end date
    public static boolean validateDates(String start, String end) {
        //Date format is MM/DD/YYYY
        String []strStartAry = start.split("/");
        String []strEndAry = end.split("/");
        Date s = new Date(Integer.parseInt(strStartAry[2]), Integer.parseInt(strStartAry[0]),
                Integer.parseInt(strStartAry[1]));
        Date e = new Date(Integer.parseInt(strEndAry[2]), Integer.parseInt(strEndAry[0]),
                Integer.parseInt(strEndAry[1]));
        if(s.before(e))
            return true;
        else
            return false;

    }
    public static void displayResumeApp() {
        System.out.println("==========================================================================================");
        System.out.println(""+personalInfo.getName());
        System.out.println("" +personalInfo.getEmailAddress());
        System.out.println("\n" +"Education");
        for(Education e:personalInfo.getEducationList()) {
            System.out.println(""+e.getDegree()+" in "+e.getMajor()+",");
            System.out.println(""+e.getSchoolName()+", "+e.getYear());
        }

        System.out.println("\n"+"Experience");
        for(Experience exp:personalInfo.getExperienceList()) {
            System.out.println("" +exp.getTitle());
            System.out.println(""+exp.getCompany() +", "+exp.getStartDate()+"-"+exp.getEndDate());
            int counter = 1;
            for(String s:exp.getDescriptionList()) {
                System.out.println("- Duty "+counter +", "+s);
                counter++;
            }
            System.out.println();

        }
        System.out.println("Skills");
        for(Skill s:personalInfo.getSkillList()) {
            System.out.println(""+s.getSkillName()+", "+s.getCompetency());
        }
    }
}
