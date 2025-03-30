package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> _patients;

    public SimpleEmergencyRoom() {
        _patients = new ArrayList<>();
    }

    /**
     * TODO (Task 1): dequeue
     * @return return patient with the highest priority
     */
    public Patient dequeue() {
        Patient hp = _patients.get(0);
        for (int i = 0; i < _patients.size(); i++){
            Patient cp = _patients.get(i);
            if (hp.getPriority().compareTo(cp.getPriority()) < 0){
                hp = cp;
            }
        }
        _patients.remove(hp);
        return hp;
    	}

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        _patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        _patients.add(patient);
    }

    public List getPatients() {
        return _patients;
    }

    public int size() {
        return _patients.size();
    }

}
