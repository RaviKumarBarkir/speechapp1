package com.personal.repository;

import com.personal.entity.Speech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpeechRepository extends JpaRepository<Speech, String>, JpaSpecificationExecutor<Speech>, PagingAndSortingRepository<Speech,String> {


}