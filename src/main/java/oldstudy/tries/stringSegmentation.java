//package oldstudy.tries;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class stringSegmentation {
//
//
//    public static boolean can_segment_string(String s, Set<String> dict) {
//
//        Set<String> solved = new HashSet<String>();
//        return can_segment_string(s, dict, solved);
//    }
//
//
//    public static boolean can_segment_string(String s, Set<String> dict, Set<String> solved) {
//
//      for ( int i = 0; i < s.length(); i++) {
//          String first = s.substring(0,i);
//          if ( dict.contains(first)) {
//              String second = s.substring(i);
//              if ( second == null || second.length() ==0 || dict.contains(second)) {
//                  return true;
//              }
//              if ( !solved.contains(second)) {
//                  if ( can_segment_string(second, dict, solved)) {
//                      return true;
//                  }
//                  solved.add(second);
//              }
//          }
//
//      }
//    }
//
//    public static void main(String[] args) {
//        Set<String> dict = new HashSet<String>();
//        String s = "applepieapple";
//
//        dict.add("pie");
//        dict.add("apple");
//        dict.add("app");
//        dict.add("lep");
//        dict.add("in");
//
//        System.out.println("Result = " + can_segment_string(s, dict));
//    }
//
//}
