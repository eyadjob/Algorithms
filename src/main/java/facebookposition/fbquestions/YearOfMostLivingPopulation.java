package facebookposition.fbquestions;

import java.util.Map;
import java.util.TreeMap;

class YearOfMostPopulation {


    public static void main(String[] args) {
        int test = 0;
        int[][] dates = {{1990, 1992}, {1995, 1999}, {1992, 2000}, {1990, 1996}};
        System.out.println(findMostPopulationYear(dates));
        System.out.println(test);

    }

    public static int findMostPopulationYear(int[][] dates) {
        Map<Integer, Integer> personCountPerYear = fillPersonsCount(dates);
        int maxYear = sumOfYearsValues(personCountPerYear);
        return maxYear;

    }

    public static Map<Integer, Integer> fillPersonsCount(int[][] ar) {
        Map<Integer, Integer> personCountPerYear = new TreeMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (personCountPerYear.get(ar[i][0]) == null) {
                personCountPerYear.put(ar[i][0], 1);
            } else {
                personCountPerYear.put(ar[i][0], personCountPerYear.get(ar[i][0]) + 1);
            }

            if (personCountPerYear.get(ar[i][1]) == null) {
                personCountPerYear.put(ar[i][1], -1);
            } else {
                personCountPerYear.put(ar[i][1], personCountPerYear.get(ar[i][1]) - 1);
            }
        }
        return personCountPerYear;
    }

    public static int sumOfYearsValues(Map<Integer, Integer> personCountPerYear) {
        int maxYear = 0, tempCount = 0, maxCount = 0;
        for (Map.Entry<Integer, Integer> e : personCountPerYear.entrySet()) {
            tempCount += e.getValue();
            if (maxCount < tempCount) {
                maxCount = tempCount;
                maxYear = e.getKey();
            }
        }
        return maxYear;
    }

}