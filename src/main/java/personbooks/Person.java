/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package personbooks;

import java.util.ArrayList;

public class Person {

    private String id;
    private String name;
    private int age;
    private boolean active;
    private ArrayList<Book> books;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Person() {
        this.books = new ArrayList<Book>();
    }

    public Person(String Id, String Name, int Age, boolean Active) {
        this.books = new ArrayList<Book>();
        this.id = Id;
        this.name = Name;
        this.age = Age;
        this.active = Active;
    }

    /**
     * @return the _books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }
}
