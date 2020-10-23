import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class DynamicConnectivity<T> {


    List<List<Integer>> comp = new ArrayList<>();

    List<List<Integer>> connections = new ArrayList<>();
    Set sites = new HashSet();

    public static void main(String[] args) {

        int[][] connectinos = {{4, 3}, {3, 8},  {6, 5},{9, 4}, {2, 1}, {8, 9}, {5, 0}, {7, 2}, {6, 1}, {1, 0}, {6, 7}};

        DynamicConnectivity dynamicConnectivity = new DynamicConnectivity();

        for (int i = 0; i < connectinos.length; i++) {

            dynamicConnectivity.union(connectinos[i][0], connectinos[i][1]);

        }

        System.out.println(dynamicConnectivity.countInfo().toString());
        System.out.println(dynamicConnectivity.getComp().toString());
    }

    public void union(int p, int q) {
        sites.add(p);
        sites.add(q);

        if (connected(p, q) == Boolean.FALSE) {
            FindComponentWrapper pList = getComponentMap(p);
            FindComponentWrapper qList = getComponentMap(q);
            if (pList.isFound()) {
                if (qList.isFound()) {
                    if (pList.getComponentIndex() != qList.getComponentIndex()) {
                        pList.getComponent().addAll(qList.getComponent());
                        qList.getComponent().clear();
                        comp.remove(qList.getComponentIndex());
                     addConnection(p, q);
                    }

                } else {
                    pList.getComponent().add(q);
                    addConnection(p, q);
                }
            } else if (qList.isFound()) {
                qList.getComponent().add(p);
                addConnection(p, q);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(p);
                newList.add(q);
                comp.add(newList);
                addConnection(p, q);
            }

        }
    }

    public void addConnection(int p, int q) {
        connections.add(new ArrayList<Integer>() {{
            add(p);
            add(q);
        }});
    }
    public boolean connected(int q, int p) {

        for (int i = 0; i < comp.size(); i++) {
            if (comp.get(i).contains(q)) {
                if (comp.get(i).contains(p)) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;

    }

    public FindComponentWrapper getComponentMap(int p) {
        for (int i = 0; i < comp.size(); i++) {
            if (comp.get(i).contains(p)) {
                return new FindComponentWrapper(comp.get(i), i, true);
            }
        }
        return new FindComponentWrapper(null, -1, false);
    }

    //
    public CountInfo countInfo() {
        return new CountInfo(this.connections.size(), this.sites.size(), this.comp.size());
    }

    //
    public int find() {
        return 0;
    }

    public static class Nod<T> {
        Nod next;
        T item;
    }

    @Data
    @AllArgsConstructor
    @ToString
    public class CountInfo {
        private int connections;
        private int sites;
        private int components;
    }

    @Data
    @AllArgsConstructor
    public class FindComponentWrapper {

        private List<Integer> component;
        private int componentIndex;
        private boolean found;

    }
}
