//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class PlaneRoute {
//
//
//    public static void main(String[] args) {
//
//    }
//
//    public Map<String,Integer> getOptimalRoute(int maxTravelDist, Map<Integer, Integer> forwardRouteList, Map<Integer, Integer> retumRouteList) {
//
//
//        Map<Integer, String> result = new TreeMap<>();
//        for (Map.Entry<Integer, Integer> forwardEn : forwardRouteList.entrySet()) {
//
//            for (Map.Entry<Integer, Integer> returnE : retumRouteList.entrySet()) {
//
//                int utilitzation = maxTravelDist - (forwardEn.getData() + returnE.getData());
//                if (utilitzation >= 0) {
//                    result.put( utilitzation,forwardEn.getKey() + "" + returnE.getKey());
//
//                }
//
//            }
//
//        }
//
//
//        for (Map.Entry<Integer,String> re : result.entrySet()) {
//
//            }
//        }
//
//        return min;
//    }
//
//}
