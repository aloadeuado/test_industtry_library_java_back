package com.test_industry.library.Respository;

import com.test_industry.library.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}
