package com.ragdroid.rxify.logic.data.remote;

import android.support.annotation.NonNull;

import com.ragdroid.rxify.core.data.StudentDataSource;
import com.ragdroid.rxify.entity.Student;
import com.ragdroid.rxify.logic.random.Randomizer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Simulates network call by adding latency
 * Created by garimajain on 05/11/16.
 */
public final class StudentRemoteDataSource implements StudentDataSource {

    private final HashMap<String, Student> studentMap;
    private final Randomizer randomizer;

    @Inject
    public StudentRemoteDataSource(Randomizer randomizer) {
        this.randomizer = randomizer;
        this.studentMap = new LinkedHashMap<>(5);

        addStudent("Hermione");
        addStudent("Harry");
        addStudent("Ron");
        addStudent("Crab");
        addStudent("Draco");
    }

    private Student addStudent(String studentName) {
        Student student = new Student(studentName);
        studentMap.put(studentName, student);
        return student;
    }

    @Override
    public Observable<Student> getStudent(@NonNull String name) {
        Student student = studentMap.get(name);
        if (student == null) {
            student = addStudent(name);
        }

        return Observable.just(student)
                .delay(randomizer.randomInRange(2, 5), TimeUnit.SECONDS);
    }

    @Override
    public Single<List<Student>> getStudents() {
        return Observable.fromIterable(studentMap.values())
                .delay(randomizer.randomInRange(2, 5), TimeUnit.SECONDS)
                .toList();
    }

    @Override
    public void saveStudent(@NonNull Student student) {
        studentMap.put(student.getName(), student);
    }
}
