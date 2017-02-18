package org.abpc.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "medal")
@SQLDelete(sql = "UPDATE medal SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Medal extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1084477468035896090L;

    private String studentName;
    private Integer amount;

    public Medal() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
