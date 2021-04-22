package com.students.service;

import com.students.domain.Gender;

import java.util.List;

public interface GenderService {
    public Gender getGender(int id);
    public List<Gender> getAll();
}
