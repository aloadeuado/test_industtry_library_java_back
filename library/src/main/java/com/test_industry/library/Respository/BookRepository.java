package com.test_industry.library.Respository;

import com.test_industry.library.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE LOWER(b.name) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "OR LOWER(b.description) LIKE LOWER(CONCAT('%', :text, '%'))")
    List<Book> searchByText(@Param("text") String text);
}
