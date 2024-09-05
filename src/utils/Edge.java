package utils;

public class Edge<DestType, WeightType extends Comparable<WeightType>> implements Comparable<Edge<DestType, WeightType>> {
    public DestType d;
    public WeightType w;

    public Edge(DestType d, WeightType w) {
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Edge<DestType, WeightType> other) {
        return this.w.compareTo(other.w);
    }

    @Override
    public String toString() {
        return "(" + this.d + "," + this.w + ")";
    }
}