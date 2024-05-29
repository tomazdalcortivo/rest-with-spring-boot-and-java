package br.com.tomaz.api_gateway.repository;

import br.com.tomaz.api_gateway.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}