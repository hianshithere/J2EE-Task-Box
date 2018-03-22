/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syook.work;
/**
 *
 * @author hians
 */
public class Taskbox {

    /**
     * @return the Member
     */
    public String getMember() {
        return Member;
    }

    /**
     * @param Member the Member to set
     */
    public void setMember(String Member) {
        this.Member = Member;
    }
    private int id;
    private String Task, Due, Member;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Task
     */
    public String getTask() {
        return Task;
    }

    /**
     * @param Task the Task to set
     */
    public void setTask(String Task) {
        this.Task = Task;
    }

    /**
     * @return the Due
     */
    public String getDue() {
        return Due;
    }

    /**
     * @param Due the Due to set
     */
    public void setDue(String Due) {
        this.Due = Due;
    }
}
