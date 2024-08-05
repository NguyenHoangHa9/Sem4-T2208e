package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subjectId")
    private Subject subject;

    private float score1;
    private float score2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        this.score1 = score1;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        this.score2 = score2;
    }
}

