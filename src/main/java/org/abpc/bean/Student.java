package org.abpc.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "student")
@SQLDelete(sql = "UPDATE student SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Student extends BaseModel implements Serializable {

    private static final long serialVersionUID = 5261212423198140046L;

    private String name;

    @OneToMany(targetEntity = Classes.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Classes> participatedClasses;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Classes> getParticipatedClasses() {
        return participatedClasses;
    }

    public void setParticipatedClasses(List<Classes> participatedClasses) {
        this.participatedClasses = participatedClasses;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
