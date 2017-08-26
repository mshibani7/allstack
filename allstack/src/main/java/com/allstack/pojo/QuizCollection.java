package com.allstack.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "QuizCollections", uniqueConstraints = {
		@UniqueConstraint(columnNames = "extQuizCollectionId") })
public class QuizCollection {
	private int quizCollectionId;
	private String extQuizCollectionId;
	private String quizCollectionName;
	private int isDefault;
	private CourseSection section;
	//private ArrayList<Question> questions = new ArrayList<Question>();
	
	public int getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "quizCollectionId", unique = true, nullable = false)
	public int getQuizCollectionId() {
		return quizCollectionId;
	}
	public void setQuizCollectionId(int quizCollectionId) {
		this.quizCollectionId = quizCollectionId;
	}
	@Column(name = "extQuizCollectionId", unique = true)
	public String getExtQuizCollectionId() {
		return extQuizCollectionId;
	}
	public void setExtQuizCollectionId(String extQuizCollectionId) {
		this.extQuizCollectionId = extQuizCollectionId;
	}
	public String getQuizCollectionName() {
		return quizCollectionName;
	}
	public void setQuizCollectionName(String quizCollectionName) {
		this.quizCollectionName = quizCollectionName;
	}
//	public ArrayList<Question> getQuestions() {
//		return questions;
//	}
//	public void setQuestions(ArrayList<Question> questions) {
//		this.questions = questions;
//	}
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="courseSectionId")
	public CourseSection getSection() {
		return section;
	}
	public void setSection(CourseSection section) {
		this.section = section;
	}
}
