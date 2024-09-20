package com.example.demo_thi_module4.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestionType;
    private String questionName;
    @OneToMany(mappedBy = "questionType",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<QuestionContent> questionContent;

    public QuestionType() {
    }

    public QuestionType(Long idQuestionType, String questionName, List<QuestionContent> questionContent) {
        this.idQuestionType = idQuestionType;
        this.questionName = questionName;
        this.questionContent = questionContent;
    }

    public Long getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(Long idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<QuestionContent> getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(List<QuestionContent> questionContent) {
        this.questionContent = questionContent;
    }
}
