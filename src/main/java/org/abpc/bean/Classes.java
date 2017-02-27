package org.abpc.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.abpc.bean.json.CustomDateDeserializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "classes")
@SQLDelete(sql = "UPDATE classes SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Classes extends BaseModel implements Serializable {

    private static final long serialVersionUID = 607426898190203102L;

    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @NotNull
    private Date date;

    public Classes() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
