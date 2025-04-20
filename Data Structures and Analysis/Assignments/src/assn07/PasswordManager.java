package assn07;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.lang.Math.abs;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "s"; // You can change this
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }

    // Creates an account at the appropriate index using hashing
    @Override
    public void put(K key, V value) {
        Account<K, V> account = new Account<>(key, value);
        int index = abs(key.hashCode()) % 50;

        if (_passwords[index] == null){ // no collision
            _passwords[index] = account;
        }else{ // collision
            _passwords[index]._tail.setNext(account);
            _passwords[index]._tail = account;
        }
    }

    // TODO: get
    @Override
    public V get(K key) {
        return null;
    }

    // TODO: size
    @Override
    public int size() {
        return 0;
    }

    // TODO: keySet
    @Override
    public Set<K> keySet() {
        return null;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        return null;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicates(V value) {
        return null;
    }

    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        return enteredPassword.equals(MASTER_PASSWORD);
    }

    @Override
    public String generatesafeRandomPassword(int length) {
        // TODO:
        
         int leftLimit = 48; // hint: numeral '0'=48
         int rightLimit = 122; // hint: letter 'z'=122
        int targetStringLength = length;
        Random random = new Random();

        // TODO: Ensure the minimum length is 4


        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
