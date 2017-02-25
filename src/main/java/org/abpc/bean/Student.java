package org.abpc.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "student")
@SQLDelete(sql = "UPDATE student SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Student extends BaseModel implements Serializable {

    private static final long serialVersionUID = 5261212423198140046L;

    private String name;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
