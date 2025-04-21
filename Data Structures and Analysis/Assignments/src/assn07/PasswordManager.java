package assn07;

import java.util.*;

import static java.lang.Math.abs;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "s"; // You can change this
    private Account[] _passwords;
    private int _size;

    public PasswordManager() {
        _passwords = new Account[50];
    }

    // Creates an account at the appropriate index using hashing
    @Override
    public void put(K key, V value) {
        Account<K, V> account = new Account<>(key, value);
        int index = abs(key.hashCode()) % 50;
        Account<K, V> ptr = _passwords[index];

        if (ptr == null){ // no collision
            _passwords[index] = account;
        }else{ // collision
            if (ptr.getWebsite() == account.getWebsite()){ // duplicate found; update password
                ptr.setPassword(account.getPassword());
                return;}

            while (ptr.getNext() != null){
                if (ptr.getWebsite() == account.getWebsite()){ // duplicate found; update password
                    ptr.setPassword(account.getPassword());
                    return;}
                ptr = ptr.getNext();
            }
            ptr.setNext(account); // No duplicate found; add new password at end of LL
        }
        _size++;
    }

    // Gets password(s) given a website
    @Override
    public V get(K key) {
        Account<K, V> account = _passwords[abs(key.hashCode()) % 50];
        if (account == null){ return null;}// no object found
        while (account != null){
            if (account.getWebsite() == key){
                return account.getPassword();
            }
            account = account.getNext();
        }
        return null;
    }

    // Gets number of accounts
    @Override
    public int size() {
        return _size;
    }

    // Returns a set of all the websites in the password manager
    @Override
    public Set<K> keySet() {
        Account<K, V> ptr;
        Set<K> set = new HashSet<>();
        for (int i = 0; i < _passwords.length; i++){
            if (_passwords[i] != null){
                ptr = _passwords[i];
                while (ptr != null){
                    set.add(ptr.getWebsite());
                    ptr = ptr.getNext();
                }
            }
        }
        return set;
    }

    // Removes the key and returns the matching value pair
    @Override
    public V remove(K key) {
        Account<K, V> ptr = _passwords[abs(key.hashCode()) % 50];
        if (ptr == null) {return null;} // No account to remove
        if (ptr.getWebsite() == key) { // Update array
            _passwords[abs(key.hashCode()) % 50] = ptr.getNext();
            _size--;
            return ptr.getPassword();
        }
        while (ptr.getNext() != null){
            if (ptr.getNext().getWebsite() == key){
                V password = (V) ptr.getNext().getPassword();
                ptr.setNext(ptr.getNext().getNext());
                _size--;
                return password;
            }
            ptr = ptr.getNext();
        }
        return null;
    }

    // Checks for websites with duplicate passwords
    @Override
    public List<K> checkDuplicates(V value) {
        Account<K, V> ptr;
        List<K> set = new ArrayList<>();
        for (int i = 0; i < _passwords.length; i++){
            if (_passwords[i] != null){
                ptr = _passwords[i];
                while (ptr != null){
                    if (ptr.getPassword() == value){
                        set.add(ptr.getWebsite());
                    }
                    ptr = ptr.getNext();
                }
            }
        }
        if (set.isEmpty()){return null;} // no matches
        return set;
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
