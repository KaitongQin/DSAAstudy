import util.List;

import java.util.ArrayList;

public class MinHeap {
    static class Node {
        public int id;
        public ArrayList <Edge> edges = new ArrayList <>();

        public Node(int id) {
            this.id = id;
        }
    }
    static class Edge{
        public Node source;
        public Node destination;
        public int weight;

        public Edge(Node source, Node destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    private Edge[] heap;
    private int size;
    private int maxsize;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        this.heap = new Edge[this.maxsize + 1];
        this.heap[0] = null;
    }

    public void enHeap(Edge newEdge) {
        int k = this.size + 1;
        this.heap[k] = newEdge;
        while (k > 1) {
            if (this.heap[k].weight < this.heap[k / 2].weight) {
                Edge tmp = this.heap[k];
                this.heap[k] = this.heap[k / 2];
                this.heap[k / 2] = tmp;
                k /= 2;
            } else {
                break;
            }
        }
        this.size++;
    }

    public Edge deHeap() {
        Edge tmp = this.heap[1];
        this.heap[1] = this.heap[this.size];
        this.heap[this.size] = null;
        int i = 1;
        while (i * 2 < this.size) {
            if (i * 2 < this.size - 1) {
                if (this.heap[i].weight > this.heap[i * 2].weight) {
                    Edge t = this.heap[i];
                    this.heap[i] = this.heap[i * 2];
                    this.heap[i * 2] = t;
                }
                break;
            }
            if(this.heap[i].weight > Math.min(this.heap[i * 2].weight, this.heap[i * 2 + 1].weight))  {
                if(this.heap[i * 2].weight == Math.min(this.heap[i * 2].weight, this.heap[i * 2 + 1].weight)) {
                    Edge t = this.heap[i];
                    this.heap[i] = this.heap[i * 2];
                    this.heap[i * 2] = t;
                    i *= 2;
                } else {
                    Edge t = this.heap[i];
                    this.heap[i] = this.heap[i * 2 + 1];
                    this.heap[i * 2 + 1] = t;
                    i = i * 2 + 1;
                }
            } else {
                break;
            }
        }
        this.size--;
        return tmp;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}