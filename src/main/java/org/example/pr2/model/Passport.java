package org.example.pr2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Passport")
public class Passport implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Person owner;

    @Column(name = "number")
    private int number;

    public Passport() {
    }

    public Passport(int number) {
        this.number = number;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "number=" + number;
    }
}
