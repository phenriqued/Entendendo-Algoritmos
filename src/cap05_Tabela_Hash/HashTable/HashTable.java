package cap05_Tabela_Hash.HashTable;

import java.util.Objects;
/**
 * Implementação de uma Tabela Hash (HashMap) usando encadeamento para resolução de colisões.
 * A tabela utiliza capacidade inicial baseada em número primo e redimensionamento automático
 * quando o fator de carga é excedido.
 *
 * @param <K> O tipo das chaves.
 * @param <V> O tipo dos valores.
 */
public class HashTable<K, V> {

    private static final int INITIAL_CAPACITY = 17;
    private static final float LOAD_FACTOR = 0.7f;

    private EntryData<K, V>[] table;
    private int size;
    private int bound;
    private int capacity = INITIAL_CAPACITY;

    public HashTable() {
        this.table = new EntryData[INITIAL_CAPACITY];
        this.bound = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
    }
    /**
     * Calcula o valor hash para uma chave, garantindo que seja não negativo.
     *
     * @param key A chave para calcular o hash.
     * @return O valor hash não negativo da chave.
     * @throws NullPointerException Se a chave for null.
     *
     * A máscara 0x7FFFFFFF remove o bit de sinal, garantindo hash positivo.
     */
    private int hash(K key){
        if(Objects.isNull(key)) throw new NullPointerException("key cannot be null");
        return key.hashCode() & 0x7FFFFFFF;
    }
    /**
     * Mapeia um valor hash para um índice válido no array da tabela.
     *
     * @param hash O valor hash a ser mapeado.
     * @return O índice correspondente no array da tabela.
     *
     * Usa operação módulo para distribuir uniformemente as entradas.
     */
    private int indexFor(int hash){
        return hash % capacity;
    }
    /**
     * Recupera o valor associado à chave especificada.
     *
     * @param key A chave cujo valor associado deve ser retornado.
     * @return O valor associado à chave, ou null se a chave não existir.
     * @throws NullPointerException Se a chave for null.
     *
     * Percorre a lista encadeada no bucket correspondente para encontrar a chave.
     * Compara tanto o hash quanto a chave para garantir correção.
     */
    public V get(K key){
        if(Objects.isNull(key)) throw new NullPointerException("Key cannot be null");

        int hash = hash(key);
        int index = indexFor(hash);
        var node = table[index];

        while (node != null){
            if(node.getHash() == hash &&  key.equals(node.getKey())){
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }
    /**
     * Remove o mapeamento para a chave especificada se estiver presente.
     *
     * @param key A chave cujo mapeamento deve ser removido.
     * @return O valor anterior associado à chave, ou null se a chave não existir.
     * @throws NullPointerException Se a chave for null.
     *
     * Casos de remoção:
     * 1. Único elemento no bucket: define table[index] como null.
     * 2. Primeiro elemento de lista: define table[index] como próximo elemento.
     * 3. Elemento no meio/fim: ajusta ponteiro next do elemento anterior.
     */
    public V remove(K key){
        if(Objects.isNull(key)) throw new NullPointerException("Key cannot be null");

        int hash = hash(key);
        int index = indexFor(hash);
        var node = table[index];
        EntryData<K, V> prevNode = null;

        while (node != null){
            var nextNode = node.getNext();
            if(node.getHash() == hash &&  key.equals(node.getKey())){
                if (Objects.isNull(prevNode) && Objects.isNull(node.getNext())){
                    table[index] = null;
                }else if(Objects.isNull(prevNode) && Objects.nonNull(node.getNext())){
                    table[index] = node.getNext();
                }else{
                    prevNode.setNext(nextNode);
                }
                V value = node.getValue();
                node = null;
                size--;
                return value;
            }
            prevNode = node;
            node = nextNode;
        }
        return null;
    }

    /**
     * Associa o valor especificado à chave especificada nesta tabela hash.
     * Se a tabela já contiver um mapeamento para a chave, o valor antigo é substituído.
     *
     * @param key A chave com a qual o valor especificado deve ser associado.
     * @param value O valor a ser associado à chave especificada.
     * @return O valor inserido (para compatibilidade com Map.put).
     *
     * Se o bucket estiver vazio, cria nova entrada.
     * Se a chave já existir, atualiza o valor.
     * Se ocorrer colisão, adiciona no início da lista encadeada.
     * Verifica redimensionamento após cada inserção.
     */
    public V put(K key, V value){
        int hash = hash(key);
        int index = indexFor(hash);

        if(Objects.isNull(table[index])){
            table[index] = new EntryData<>(hash, key, value);
        }else{
            var actualNode = table[index];
            while (actualNode != null){
                if(key.equals(actualNode.getKey())){
                    actualNode.setValue(value);
                    return value;
                }
                actualNode = actualNode.getNext();
            }
            EntryData<K, V> newEntryData = new EntryData<>(hash, key, value);
            newEntryData.setNext(table[index]);
            table[index] = newEntryData;
        }
        this.size ++;
        if (size > bound) resize();
        return value;
    }
    /**
     * Redimensiona a tabela hash quando o número de elementos excede o bound.
     * Dobra a capacidade, encontra o próximo número primo como nova capacidade,
     * recalcula o bound e transfere todas as entradas para a nova tabela.
     *
     * Cada entrada é reindexada com base na nova capacidade.
     * Mantém a ordem inversa nas listas encadeadas (inserção no início).
     */
    private void resize() {
        this.capacity = getNextPrimeNumberSize(capacity);
        this.bound = (int) (capacity * LOAD_FACTOR);

        EntryData<K, V>[] newTable = new EntryData[capacity];

        for (EntryData<K, V> node : table) {
            while (node != null) {
                var nextNode = node.getNext();

                int index = indexFor(node.getHash());

                node.setNext(newTable[index]);
                newTable[index] = node;

                node = nextNode;
            }
        }
        this.table = newTable;
    }
    /**
     * Encontra o próximo número primo maior ou igual ao dobro do tamanho atual.
     * @param size A capacidade atual da tabela.
     * @return O próximo número primo adequado para nova capacidade.
     * @throws IllegalArgumentException Se size for negativo.
     */
    private int getNextPrimeNumberSize(int size){
        if(size < 0) throw new IllegalArgumentException();
        if (size <= 1) return 2;
        int nextPrimeNumber = size * 2;
        while (true){
            if (isPrimeNumber(nextPrimeNumber)) return nextPrimeNumber;
            nextPrimeNumber++;
        }
    }
    private boolean isPrimeNumber(int number){
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return size;
    }

    public EntryData<K, V>[] getTable() {
        return table;
    }
}
