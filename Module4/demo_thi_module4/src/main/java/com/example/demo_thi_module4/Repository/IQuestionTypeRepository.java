package com.example.demo_thi_module4.Repository;

import com.example.demo_thi_module4.Model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType, Long> {
}
