package dev.patika.LibraryManagement.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Books")


public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id" , columnDefinition = "serial")
    private int id;

    @Column(name = "book_name" , nullable = false)
    private String name;

    @Column(name = "publication_year")
    private int publicationYear;

    @Column(name = "book_stock" , nullable = false)
    private int stock;

    //Bir yazarın birden fazla kitabı olabilir ve bir kitabın bir yazarı olur.
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book" , cascade = CascadeType.REMOVE)
    private List<BookBorrowing> bookBorrowwingList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_publisher_id",referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "BookCategories" ,
            joinColumns = {
                    @JoinColumn(name = "BookCategories_book_id")
            },
            inverseJoinColumns = {@JoinColumn(name = "BookCategories_category_id")})
    private List<Category> categoryList;



    public Book() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public List<BookBorrowing> getBookBorrowwingList() {
        return bookBorrowwingList;
    }
    public void setBookBorrowwingList(List<BookBorrowing> bookBorrowwingList) {
        this.bookBorrowwingList = bookBorrowwingList;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public List<Category> getCategoryList() {
        return categoryList;
    }
    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", stock=" + stock +
                ", author=" + author +
                ", bookBorrowwingList=" + bookBorrowwingList +
                ", publisher=" + publisher +
                '}';
    }
}