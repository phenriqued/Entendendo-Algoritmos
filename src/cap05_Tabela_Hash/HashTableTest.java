package cap05_Tabela_Hash;

import cap05_Tabela_Hash.HashTable.HashTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    HashTable<String, Integer> hashTableTest = new HashTable<>();

    @Test
    @DisplayName("Deve inserir dados no Hash Table")
    void put() {
        hashTableTest.put("a", 1);
        hashTableTest.put("b", 2);
        hashTableTest.put("c", 3);

        assertEquals(3, hashTableTest.size());
    }
    @Test
    @DisplayName("Deve lançar NullPointerException quando tentar inserir uma chave nula")
    void shouldThrowNullPointerExceptionWhenAttemptingInsertNullKey() {
        hashTableTest.put("a", 1);
        hashTableTest.put("b", 2);
        hashTableTest.put("c", 3);

        Exception exception = assertThrows(NullPointerException.class, () -> hashTableTest.put(null, 4));
        assertEquals("key cannot be null", exception.getMessage());
    }
    @Test
    @DisplayName("Deve sobrescrever valor quando chave já existente")
    void shouldOverrideValueWhenKeyAlreadyExists() {
        hashTableTest.put("a", 1);
        hashTableTest.put("a", 100);

        assertEquals(1, hashTableTest.size());
        assertEquals(100, hashTableTest.get("a"));
    }
    @Test
    @DisplayName("Deve lidar com colisões corretamente")
    void shouldHandleCollisionsCorrectly() {
        // Para testar colisões, colocar Strings que tem o mesmo hashCode para irem para o mesmo bucket
        //"Aa" e "BB" tem o mesmo hashCode()
        hashTableTest.put("Aa", 1);
        hashTableTest.put("BB", 2);  // COLISÃO - por tem o mesmo hashCode()
        hashTableTest.put("c", 3);

        assertEquals(3, hashTableTest.size());
        assertEquals(1, hashTableTest.get("Aa"));
        assertEquals(2, hashTableTest.get("BB"));
    }
    @Test
    @DisplayName("Deve funcionar após redimensionamento automático")
    void shouldWorkAfterResize() {
        // Inserir muitos elementos para forçar resize
        for (int i = 0; i < 50; i++) {
            hashTableTest.put("key" + i, i);
        }

        assertEquals(50, hashTableTest.size());
        assertEquals(25, hashTableTest.get("key25"));
        assertEquals(49, hashTableTest.get("key49"));
    }


    @Test
    @DisplayName("Deve buscar um dado inserido a partir de uma chave")
    void get() {
        hashTableTest.put("a", 1);
        hashTableTest.put("b", 2);
        hashTableTest.put("c", 3);

        assertEquals(3, hashTableTest.size());
        assertEquals(3, hashTableTest.get("c"));
        assertEquals(2, hashTableTest.get("b"));
        assertEquals(1, hashTableTest.get("a"));
    }
    @Test
    @DisplayName("Deve retornar NULL quando não tem a chave armazenada no Hash Table")
    void shouldReturnNullWhenThereIsNoKeyStoredInHashTable() {
        hashTableTest.put("a", 1);
        hashTableTest.put("b", 2);
        hashTableTest.put("c", 3);

        assertEquals(3, hashTableTest.size());
        assertNull(hashTableTest.get("z"));
    }

    @Test
    @DisplayName("Deve remover o dado e retornar o valor deste dado")
    void remove() {
        hashTableTest.put("a", 1);
        hashTableTest.put("b", 2);
        hashTableTest.put("c", 3);

        assertEquals(3, hashTableTest.remove("c"));
        assertEquals(1, hashTableTest.remove("a"));
        assertEquals(1, hashTableTest.size());
    }
    @Test
    @DisplayName("Deve retornar NULL quando tentar remover um dado inexistente")
    void shouldReturnNullWhenAttemptingRemoveNonExistentData() {
        hashTableTest.put("a", 1);
        hashTableTest.put("b", 2);
        hashTableTest.put("c", 3);

        assertNull(hashTableTest.remove("z"));
        assertEquals(3, hashTableTest.size());
    }

}