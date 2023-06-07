package org.skillgrowth.saranya_java_web_final_project.repository;

import org.skillgrowth.saranya_java_web_final_project.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
