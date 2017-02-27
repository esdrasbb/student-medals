package org.abpc.service;

import org.abpc.bean.Student;
import org.abpc.bean.to.StudentDisplayTO;
import org.abpc.repository.ClassesRepository;
import org.abpc.repository.MedalRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private MedalRepository medalRepository;

    @Autowired
    private ClassesRepository classesRepository;

    public Collection<StudentDisplayTO> getStudentsDisplay(Collection<Student> students) {
        if (CollectionUtils.isEmpty(students)) {
            //TODO chamar logger e levantar exception
        }
        Collection<StudentDisplayTO> studentsDisplay = new ArrayList<>(students.size());

        students.forEach(s -> {
            Map<Integer, Integer> classMedalAmountMap = new HashMap<>(students.size());
            classesRepository.findClassesWithStudent(s.getId()).forEach(c -> classMedalAmountMap.put(c.getId(),
                    medalRepository.getByStudentIdAndClassesId(s.getId(), c.getId()).getAmount()));
            studentsDisplay.add(new StudentDisplayTO(s, classMedalAmountMap));
        });

        return studentsDisplay;
    }


}
