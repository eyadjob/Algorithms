package facebookposition.fbquestions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
    public static void main(String[] args) {
        List<List<Interval>> sch = new ArrayList<>();
        Interval interval1 = new Interval(1, 2);

        Interval interval2 = new Interval(5, 6);

        List<Interval> fe = new ArrayList<>() {{
            add(interval1);
            add(interval2);
        }};

        Interval interval3 = new Interval(1, 3);

        List<Interval> se = new ArrayList<>() {{
            add(interval3);
        }};

        List<Interval> te = new ArrayList<>() {{
            add(new Interval(4, 10));
        }};

        sch.add(fe);
        sch.add(se);
        sch.add(te);
        System.out.println(employeeFreeTime(sch));


//                [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
//        Output: [[5,6],[7,9]]

        List<List<Interval>> sch2 = new ArrayList<>();


        List<Interval> fe2 = new ArrayList<>() {{
            add(new Interval(1, 3));
            add(new Interval(6, 7));
        }};

        List<Interval> se2 = new ArrayList<>() {{
            add(new Interval(2, 4));
        }};

        List<Interval> te2 = new ArrayList<>() {{
            add(new Interval(2, 5));
            add(new Interval(9, 12));
        }};


        sch2.add(fe2);
        sch2.add(se2);
        sch2.add(te2);
        System.out.println(employeeFreeTime(sch2));




    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        List<Interval> timeLine = new ArrayList<>();
        schedule.forEach(e -> timeLine.addAll(e));
        Collections.sort(timeLine, ((a, b) -> a.start - b.start));

        Interval temp = timeLine.get(0);
        for (Interval each : timeLine) {
            if (temp.end < each.start) {
                result.add(new Interval(temp.end, each.start));
                temp = each;
            } else {
                temp = temp.end < each.end ? each : temp;
            }
        }
        return result;
    }

    static class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }


}

//    We are given a list schedule of employees, which represents the working time for each employee.
//
//        Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
//
//        Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
//
//        (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
//
//
//
//        Example 1:
//
//        Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//        Output: [[3,4]]
//        Explanation: There are a total of three employees, and all common
//        free time intervals would be [-inf, 1], [3, 4], [10, inf].
//        We discard any intervals that contain inf as they aren't finite.
//        Example 2:
//
//        Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
//        Output: [[5,6],[7,9]]
//
//
//        Constraints:
//
//        1 <= schedule.length , schedule[i].length <= 50
//        0 <= schedule[i].start < schedule[i].end <= 10^8
