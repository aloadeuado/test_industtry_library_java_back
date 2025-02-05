package com.test_industry.library.Services;


import com.test_industry.library.Models.Book;
import com.test_industry.library.Models.User;
import com.test_industry.library.Respository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Obtener todos los libros
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Obtener un libro por ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Crear un nuevo libro
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Actualizar un libro existente
    public Book updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setName(bookDetails.getName());
            existingBook.setDescription(bookDetails.getDescription());
            return bookRepository.save(existingBook);
        }).orElse(null);
    }

    // Eliminar un libro
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // Método para buscar libros por texto
    public List<Book> searchBooks(String text) {
        if (text.length() < 2) {
            throw new IllegalArgumentException("El texto de búsqueda debe tener al menos 2 caracteres.");
        }
        return bookRepository.searchByText(text);
    }
}
