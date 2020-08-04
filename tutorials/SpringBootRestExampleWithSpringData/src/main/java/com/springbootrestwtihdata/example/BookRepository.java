package com.springbootrestwtihdata.example;

import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data Magic
public interface BookRepository extends JpaRepository<Book, Long> {

}
