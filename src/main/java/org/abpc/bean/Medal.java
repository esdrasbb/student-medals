package org.abpc.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "medal")
@SQLDelete(sql = "UPDATE medal SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Medal extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1084477468035896090L;

    @NotNull
    @Min(value = 1)
    private Integer amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    @NotNull
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_classes", referencedColumnName = "id")
    @NotNull
    private Classes classes;

    public Medal() {
    }

    public Medal(Integer amount, Student student, Classes classes) {
        this.amount = amount;
        this.student = student;
        this.classes = classes;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
