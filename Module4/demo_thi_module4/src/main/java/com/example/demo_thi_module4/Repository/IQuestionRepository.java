package com.example.demo_thi_module4.Repository;

import com.example.demo_thi_module4.Model.QuestionContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepository extends JpaRepository<QuestionContent, Long> {
}
