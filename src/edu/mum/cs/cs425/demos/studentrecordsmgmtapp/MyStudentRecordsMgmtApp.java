package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.comparators.NameAscendingComparator;
import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        Student[] students = new Student[5];

        students[0] = new Student(110001, "Dave", LocalDate.of(1951, 11, 18));
        students[1] = new Student(110002, "Anna", LocalDate.of(1990, 11, 18));
        students[2] = new Student(110003, "Erica", LocalDate.of(1974, 11, 18));
        students[3] = new Student(110004, "Carlos", LocalDate.of(2009, 11, 18));
        students[4] = new Student(110005, "Bob", LocalDate.of(1990, 11, 18));

        printListOfStudents(students);
        System.out.println("\n\n");
        getListOfPlatinumAlumniStudents(students);

        System.out.println("\n\n");
        int[] numbers = {1, 5, 3, 10, 35, 7, 10, 12};
        printHelloWorld(numbers);


        System.out.println("\n\nSecond Largest Number: " +  findSecondBiggest(numbers));

    }

    private static void printListOfStudents(Student[] students){
        Arrays.sort(students, new NameAscendingComparator());

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void getListOfPlatinumAlumniStudents(Student[] students){
        int currentYear = LocalDate.now().getYear();
        students = Arrays.stream(students).filter(student ->  currentYear - student.getDateOfAdmission().getYear() >= 30)
                .sorted(Comparator.comparing(Student::getDateOfAdmission).reversed()).toArray(Student[]::new);

        for (Student student : students) {
            System.out.println(student);
        }
    }


    private static void printHelloWorld(int[] numbers){
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : numbers) {
            if (number % 5 == 0) stringBuilder.append("Hello");
            if (number % 7 == 0) stringBuilder.append("World");
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    private static int findSecondBiggest(int[] numbers){
        int largest = numbers[0];
        int secondLargest = numbers[0];

        for (int i=0; i<numbers.length; i++){
            if (numbers[i] > largest){
                secondLargest = largest;
                largest = numbers[i];
            }else if (numbers[i] > secondLargest){
                secondLargest = numbers[i];
            }
        }

        return secondLargest;
    }
}


