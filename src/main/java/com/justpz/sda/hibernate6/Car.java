package com.justpz.sda.hibernate6;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Car {
    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "car_name")
    private String name;
    private String model;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Engine engine;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Set<Seat> seats;
    @OneToMany(mappedBy = "mainCar", cascade = CascadeType.PERSIST)
    private Set<Person> owners = new HashSet<>();

    public Set<Person> getOwners() {
        return owners;
    }

    public void addOwner(Person owner){
        owner.setMainCar(this);
        owners.add(owner);
    }



    public void setOwners(Set<Person> owners) {
        this.owners = owners;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public Engine getEngine() {

        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(name, car.name) &&
                Objects.equals(model, car.model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
