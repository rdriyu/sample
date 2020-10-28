package com.lti.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_questions")
public class Questions {

	@Id
	@SequenceGenerator(name = "qnSeq", initialValue = 9001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qnSeq")
	@Column(name = "question_id")
	int questionId;

	@Column(name = "question_level_id")
	int levelId;

	@Column(name = "question_subject_type")
	SubjectType subjectType;

	@Column(name = "question_optionA")
	String optionA;

	@Column(name = "question_optionB")
	String optionB;

	@Column(name = "question_optionC")
	String optionC;

	@Column(name = "question_optionD")
	String optionD;

	@Column(name = "question_correct_option")
	char correctOption;

	String questionStatement;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public SubjectType getSubjecType() {
		return subjectType;
	}

	public void setSubjecType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionc) {
		this.optionC = optionc;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public char getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(char correctOption) {
		this.correctOption = correctOption;
	}

	public String getQuestionStatement() {
		return questionStatement;
	}

	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}

}
