package dev.patika.LibraryApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @Column(name = "stock", nullable = false)
    private int stock;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    //Örneğin; cascade = CascadeType.REMOVE belirtilmediğinde,
    // ilişkili entity'lerin silinmesi için bunu kod ile yazmak gerekecektir.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    //Eğer bir Book silindiğinde ona bağlı tüm BookBorrowing'lerin de silinmesini istiyorsak
    //cascade = {CascadeType.REMOVE} bu işlevi yerine getirecektir.
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<BookBorrowing> bookBorrowings;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_category", //yeni oluşacak tablo adı
            joinColumns = @JoinColumn(name = "book_id"), //
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

}
