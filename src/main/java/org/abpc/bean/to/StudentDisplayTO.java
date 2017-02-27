package org.abpc.bean.to;

import org.abpc.bean.Student;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Map;

public class StudentDisplayTO {
    private Student student;
    private Map<Integer, Integer> classMedalAmountMap;

    public StudentDisplayTO(Student student, Map<Integer, Integer> classMedalAmountMap) {
        this.student = student;
        this.classMedalAmountMap = classMedalAmountMap;
    }

    public Student getStudent() {
        return student;
    }

    public Map<Integer, Integer> getClassMedalAmountMap() {
        return classMedalAmountMap;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
