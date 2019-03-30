package com.justpz.sda.hibernate6.exercise1;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private LocalDateTime creationDate;
    @ManyToMany
    private Set<Product>products;




    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipt recipt = (Recipt) o;
        return Id == recipt.Id &&
                Objects.equals(creationDate, recipt.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, creationDate);
    }
}
