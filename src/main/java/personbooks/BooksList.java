/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package personbooks;

import java.util.*;

public class BooksList extends Hashtable<String,Book>{
    public BooksList(){
        this.Fill();
    }
    //init fill list
    private void Fill(){
        Person p;
        for( int i = 0; i < 20; i++ ){
            this.put(String.format("%d", i), new Book(String.format("%d", i), String.format("Book - %d", i)));
        }
    };

    public List<Book> getFreeBooks() {
        ArrayList<Book> res = new ArrayList<Book>();
        for( Book b: this.values()){
            if(b.getPerson() == null) res.add(b);
        }
        return res;
    }
}
