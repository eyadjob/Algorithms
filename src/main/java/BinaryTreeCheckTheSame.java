//public class BinaryTreeCheckTheSame {
//
//
//    public boolean sameTree(Object nod1, Object nod2) {
//
//
//        if (nod1 == null && nod2 == null) {
//            return Boolean.TRUE;
//        } else if (nod1 != null ^ nod2 != null) {
//            return Boolean.FALSE;
//        }
//
//        if (nod1.data == nod2.data && sameTree(nod1.right, nod2.righ) && sameTree(nod1.left == nod2.left)) {
//            return Boolean.TRUE;
//        }
//
//        return Boolean.FALSE;
//    }
//
//}