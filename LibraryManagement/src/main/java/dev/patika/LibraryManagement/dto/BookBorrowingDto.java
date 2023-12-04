package dev.patika.LibraryManagement.dto;

import java.time.LocalDate;

public class BookBorrowingDto {
    private int id;
    private String borrowerName;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private String bookName;
}
