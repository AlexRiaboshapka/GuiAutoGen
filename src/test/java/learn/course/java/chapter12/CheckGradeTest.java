package learn.course.java.chapter12;

import logger.CustomLogger;

import java.util.Map;

public class CheckGradeTest extends TestResults {

    static Map gradeResult = getOriginalGrades();
    static Map gradeRetry = getMakeUpGrades();

    public static void main(String[] args) {

        printGrade(getTheBestScore(gradeResult, gradeRetry));
    }

    public static Map getTheBestScore(Map<String, Integer> score1, Map<String, Integer> score2) {
        for (Map.Entry<String, Integer> student : score2.entrySet()) {
            Integer firstGrade = score1.get(student.getKey());
            Integer secondGrade = score2.get(student.getKey());
            if (secondGrade > firstGrade) {
                score1.put(student.getKey(), secondGrade);
            }
        }
        return score1;
    }

    public static void printGrade(Map grade) {
        grade.forEach((k, v) -> CustomLogger.logger.info("Student: " + k + " Grade: " + v));
    }
}
