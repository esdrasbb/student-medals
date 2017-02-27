package org.abpc.bean.to;


import org.abpc.bean.Student;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StudentMedalTO {

    private Student student;
    private Long medalAmount;

    public StudentMedalTO(Student student, Long medalAmount) {
        this.student = student;
        this.medalAmount = medalAmount;
    }

    public Student getStudent() {
        return student;
    }

    public Long getMedalAmount() {
        return medalAmount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
