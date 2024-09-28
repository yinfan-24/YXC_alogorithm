package JAVA_LEARNING;

import java.util.Comparator;

public class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second){
        this.first = first;
        this.second = second;
    }

    public K getFirst(){return this.first;}
    public V getSecond(){return this.second;}
    public void setSecond(V second){this.second = second;}
    public void setFirst(K first){this.first = first;}

    public static <K extends Comparable<K>, V> Comparator<Pair<K, V>> firstComparator(){
        return (Comparator.comparing(Pair::getFirst));
    }
}

