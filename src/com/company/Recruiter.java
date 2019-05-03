package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Recruiter {
    ArrayList<PersonalInfo> resumeList = new ArrayList<PersonalInfo>();
    HashMap<String, PersonalInfo> hashMap = new HashMap<String, PersonalInfo>();

    public Recruiter() {

    }
    public ArrayList<PersonalInfo> getResumeList() {
        return resumeList;
    }

    public void setResumeList(ArrayList<PersonalInfo> resumeList) {
        this.resumeList = resumeList;
    }
    public HashMap<String, PersonalInfo> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, PersonalInfo> hashMap) {
        this.hashMap = hashMap;
    }
}
