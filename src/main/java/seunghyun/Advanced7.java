package seunghyun;

import java.util.Scanner;

public class Advanced7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 20;

        float totalGrade = 0;
        float totalCredit = 0;

        String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        float[] gradePoints = {4.5f, 4.0f, 3.5f, 3.0f, 2.5f, 2.0f, 1.5f, 1.0f, 0.0f};

        for (int i = 0; i < N; i++) {
            String subject = sc.next();
            if (subject.length() > 50 || 1 > subject.length() || subject.contains(" ")) {
                throw new IllegalArgumentException();
            }
            float gradeScale = sc.nextFloat();
            if (!(gradeScale == 1.0 || gradeScale == 2.0 || gradeScale == 3.0 || gradeScale == 4.0)) {
                throw new IllegalArgumentException();
            }
            String grade = sc.next();
            if (!(grade.equals("A+") || grade.equals("A0") || grade.equals("B+") || grade.equals("B0") || grade.equals("C+") || grade.equals("C0") || grade.equals("D+") || grade.equals("D0") || grade.equals("F") || grade.equals("P"))) {
                throw new IllegalArgumentException();
            }

            if (!(grade.equals("P"))) {
                float gradePoint = 0;

                for (int j = 0; j < grades.length; j++) {
                    if (grade.equals(grades[j])) {
                        gradePoint = gradePoints[j];
                        break;
                    }
                }

                totalGrade += gradeScale * gradePoint;
                totalCredit += gradeScale;
            }
        }
        if (totalCredit > 0) {
            float average = totalGrade / totalCredit;
            System.out.printf("%.6f\n", average);
        } else {
            float average = 0;
            System.out.printf("%.6f\n", average);
        }
    }
}
