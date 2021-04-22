package com.students.repositoryimpl;

import com.students.domain.Gender;
import com.students.repository.GenderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GenderRepositoryImpl implements GenderRepository {
    private List<Gender> genders;

    public GenderRepositoryImpl() {
        this.genders = new ArrayList<Gender>();
        Gender male = new Gender(1, "Male");
        Gender female = new Gender(2, "Female");
        Gender unknown = new Gender(3, "Unknown");
        genders.add(male);
        genders.add(female);
        genders.add(unknown);
    }

    @Override
    public Gender getGender(int id) {
        return genders.stream().filter(x->x.getId() == id).findFirst().get();
    }

    @Override
    public List<Gender> getAll() {
        return genders;
    }
}
