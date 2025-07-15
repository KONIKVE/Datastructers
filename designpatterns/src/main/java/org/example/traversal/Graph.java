package org.example.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Graph<E> {
    private Vertice<E> rootVertice;

    public Graph() {
    }

    public Graph(Vertice<E> rootVertice) {
        this.rootVertice = rootVertice;
    }

    private void levelOrderTraversal(Vertice<E> rootVertice, List<E> traversal) {
        Queue<Vertice<E>>  queue = new ArrayDeque<>();
        queue.offer(rootVertice);

        // Base Condition until queue becomes empty!
        while(!queue.isEmpty()){
            Vertice<E> vertice = queue.poll();
            vertice.setVisited(Boolean.TRUE);
            traversal.add(vertice.getValue());
            System.out.println("Vertice:"+vertice.value);

            if ( vertice.getAdjacentVertices() != null) {
                for(Vertice<E> obj :  vertice.getAdjacentVertices()){

                    // Base Condition if vertex is already visited we don't add it in to the queue.
                    if(!obj.visited)
                        queue.offer(obj);

                }
            }
        }
        System.out.println(traversal);
    }

    public void DFS(List<E> traversal){
        System.out.println(depthFirstSearch(rootVertice,traversal));
    }

    public List<E> depthFirstSearch(Vertice<E> vertice, List<E> traversal) {
        vertice.setVisited(Boolean.TRUE);
        traversal.add(vertice.getValue());

        if (vertice.getAdjacentVertices() != null) {
            for (Vertice<E> eVertice : vertice.getAdjacentVertices()) {
                if (!eVertice.isVisited()) {
                    depthFirstSearch(eVertice, traversal);
                }
            }
        }

        return traversal;
    }

    private static class Vertice<E> {
        private E value;
        private List<Vertice<E>> adjacentVertices;
        private boolean visited;

        private int weight ;

        public Vertice() {
        }

        public Vertice(E value) {
            this.value = value;
        }

        public Vertice(E value, List<Vertice<E>> adjacentVertices, boolean visited) {
            this.value = value;
            this.adjacentVertices = adjacentVertices;
            this.visited = visited;
        }

        public void setValue(E value) {
            this.value = value;
            this.visited = false;
        }

        public void setAdjacentVertices(List<Vertice<E>> adjacentVertices) {
            this.adjacentVertices = adjacentVertices;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public E getValue() {
            return value;
        }

        public List<Vertice<E>> getAdjacentVertices() {
            return adjacentVertices;
        }

        public boolean isVisited() {
            return visited;
        }

        @Override
        public String toString() {
            return "Vertice{" +
                    "value=" + value +
                    ", adjacentVertices=" + adjacentVertices +
                    ", visited=" + visited +
                    '}';
        }
    }

    public static void main(String[] args) {
        Vertice<String> A = new Vertice<>("A");
        Vertice<String> B = new Vertice<>("B");
        Vertice<String> C = new Vertice<>("C");
        Vertice<String> D = new Vertice<>("D");
        Vertice<String> E = new Vertice<>("E");
        Vertice<String> F = new Vertice<>("F");
        Vertice<String> G = new Vertice<>("G");
        A.setAdjacentVertices(List.of(B,C,D));
        B.setAdjacentVertices(List.of(E,F));
        C.setAdjacentVertices(List.of(A));
        D.setAdjacentVertices(List.of(G));
        Graph<String> graph = new Graph<>(A);
        List<String> traversal = new ArrayList<>();
     // graph.levelOrderTraversal(A,traversal);
        graph.DFS(traversal);
    }

}