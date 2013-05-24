/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package personbooks;

import java.util.*;

public class PersonsList extends HashMap<String, Person> {

    public PersonsList() {
        this.Fill();
    }
    //init fill list

    private void Fill() {
        Person p;
        p = new Person("001", "Sophia SMITH", 12, true);
        this.put(p.getId(), p);
        p = new Person("002", "Isabella JOHNSON", 12, true);
        this.put(p.getId(), p);
        p = new Person("003", "Alexander WILLIAMS", 12, true);
        this.put(p.getId(), p);
        p = new Person("004", "Olivia JONES", 12, true);
        this.put(p.getId(), p);
        p = new Person("005", "William BROWN", 12, true);
        this.put(p.getId(), p);

    }

    ;
    public List<Person> getAllPersons() {
        return new ArrayList<Person>(this.values());
    }

    public Person findPersonById(String id) {
        return this.get(id);
    }

    public Person savePerson(Person person) {
        this.remove(person.getId());
        this.put(person.getId(), person);
        return person;
    }
}
