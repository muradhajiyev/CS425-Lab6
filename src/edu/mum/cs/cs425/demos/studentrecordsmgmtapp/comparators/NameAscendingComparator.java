package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.comparators;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.util.Comparator;

public class NameAscendingComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
