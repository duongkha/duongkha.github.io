package com.students.repository;

import com.students.domain.Gender;
import java.util.List;

public interface GenderRepository {
    public Gender getGender(int id);
    public List<Gender> getAll();
}
