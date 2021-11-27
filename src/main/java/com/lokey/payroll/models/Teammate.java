package com.lokey.payroll.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Entity
public class Teammate {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=2, max=20)
    private String firstName;

    @NotNull
    @Size(min=2, max=20)
    private String lastName;

    private float wage;

    private Position position;
    public enum Position {
        Foh, Boh
    }

    private ArrayList<Shift> shifts = new ArrayList<>(); //TODO: change this to ArrayList<Shift.getID> after getters are created?


    //getters and setters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ArrayList<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }

    public Teammate() {}
    public Teammate(int id, String firstName, String lastName, float wage, Position position, ArrayList<Shift> shifts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wage = wage;
        this.position = position;
        this.shifts = shifts;
    }
}
