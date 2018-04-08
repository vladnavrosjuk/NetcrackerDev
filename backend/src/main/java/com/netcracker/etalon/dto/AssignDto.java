package com.netcracker.etalon.dto;

import java.util.ArrayList;
import java.util.List;

public class AssignDto {
    private List<Integer> students =new ArrayList<>();
    private Integer requestId;

    public List<Integer> getStudents() {
        return students;
    }

    public void setStudents(List<Integer> students) {
        this.students = students;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
}
