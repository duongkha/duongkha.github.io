package com.students.serviceimpl;

import com.students.domain.Gender;
import com.students.repository.GenderRepository;
import com.students.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    GenderRepository genderRepository;

    @Override
    public Gender getGender(int id) {
        return genderRepository.getGender(id);
    }

    @Override
    public List<Gender> getAll() {
        return genderRepository.getAll();
    }
}
