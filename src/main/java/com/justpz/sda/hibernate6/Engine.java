package com.justpz.sda.hibernate6;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "engine")
    private Car car;
    private int power;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return power == engine.power &&
                Objects.equals(id, engine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, power);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", car=" + car +
                ", power=" + power +
                '}';
    }
}
