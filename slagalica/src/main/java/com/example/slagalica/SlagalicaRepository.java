package com.example.slagalica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SlagalicaRepository extends JpaRepository<Slagalica, String> {
    @Query("select s.word from Slagalica s WHERE s.sortedChars = :sortedChars")
    List<String> findWordsBySortedChars(@Param("sortedChars")String sortedChars);
}
