package dev.patika.LibraryManagement.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Authors")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",columnDefinition = "serial")
    private int id;
    @Column(name = "author_name", nullable = false)
    private String Name;
    @Temporal(TemporalType.DATE)
    @Column(name = "author_birthDate")
    private LocalDate birthday;

    @Column(name = "author_country")
    private String country;
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> bookList;

    //Getter ve Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", birthday=" + birthday +
                ", country='" + country + '\'' +
                '}';
    }
}
