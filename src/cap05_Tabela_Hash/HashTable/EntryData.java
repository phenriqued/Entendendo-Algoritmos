package cap05_Tabela_Hash.HashTable;

public class EntryData<K, V> {

    private final int hash;
    private final K key;
    private V value;
    private EntryData<K,V> next;

    public EntryData(int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public int getHash() {
        return hash;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public EntryData<K, V> getNext() {
        return next;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(EntryData<K, V> next) {
        this.next = next;
    }
}
