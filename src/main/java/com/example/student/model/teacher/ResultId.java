package com.example.student.model.teacher;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString

@Embeddable
public class ResultId implements Serializable {
    private Long matricNo;
    private String courseCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultId)) return false;
        ResultId resultId = (ResultId) o;
        return Objects.equals(matricNo, resultId.matricNo) &&
               Objects.equals(courseCode, resultId.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricNo, courseCode);
    }
}


