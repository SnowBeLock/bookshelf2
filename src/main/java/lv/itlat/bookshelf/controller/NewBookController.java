package lv.itlat.bookshelf.controller;

import lv.itlat.bookshelf.persistence.domain.Book;
import lv.itlat.bookshelf.persistence.domain.Reservation;
import lv.itlat.bookshelf.persistence.repository.BookRepository;
import lv.itlat.bookshelf.persistence.repository.ReservationRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import static lv.itlat.bookshelf.persistence.domain.ReservationStatus.AVAILABLE;

@Named
@RequestScoped
public class NewBookController implements Serializable {

    @Inject
    private BookRepository bookRepository;
    @Inject
    private CurrentUser currentUser;
    private Book book = new Book();
    @Inject
    private ReservationRepository reservationRepository;

    public String createBook() {
        bookRepository.create(book);
        Reservation reservation = new Reservation();
        reservation.setBook(book);
        reservation.setUser(currentUser.getUser());
        reservation.setStatus(AVAILABLE);
        reservationRepository.create(reservation);
        book = new Book();

        return "book-created.xhtml";
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
