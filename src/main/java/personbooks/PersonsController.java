package personbooks;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonsController {

    private PersonsList personsList;
    private BooksList booksList;

    private void getListFromRequest(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        personsList = (PersonsList) session.getAttribute("personsList");
        if (personsList == null) {
            personsList = new PersonsList();
            session.setAttribute("personsList", personsList);
        }
        booksList = (BooksList) session.getAttribute("booksList");
        if (booksList == null) {
            booksList = new BooksList();
            session.setAttribute("booksList", booksList);
        }
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ModelAndView drawAndModifyPersons(HttpServletRequest request, HttpServletResponse responce) {
        getListFromRequest(request);
        //edit person
        String id = request.getParameter("id");
        if (id != null) {
            if (personsList.containsKey(id)) {
                Person p = personsList.get(id);
                HashMap map = new HashMap<String, Object>();
                map.put("person", p);
                map.put("freebooks", booksList.getFreeBooks());
                return new ModelAndView("person.jsp", map);
            }
        }
        //del person
        String del = request.getParameter("del");
        if (del != null) {
            if (personsList.containsKey(del)) {
                Person p = personsList.get(del);
                personsList.remove(del);
                for (Book b : p.getBooks()) {
                    b.setPerson(null);
                }
            }
        }

        //add person book
        String book = request.getParameter("addbook");
        if (book != null) {
            if (booksList.containsKey(book)) {
                Book b = booksList.get(book);
                String pid = request.getParameter("person");
                if (personsList.containsKey(pid)) {
                    Person p = personsList.findPersonById(pid);
                    p.getBooks().add(b);
                    b.setPerson(p.getId());
                    HashMap map = new HashMap<String, Object>();
                    map.put("person", p);
                    map.put("freebooks", booksList.getFreeBooks());
                    return new ModelAndView("person.jsp", map);
                }
            }
        }


        //remove person book
        book = request.getParameter("rembook");
        if (book != null) {
            if (booksList.containsKey(book)) {
                Book b = booksList.get(book);
                String pid = request.getParameter("person");
                if (personsList.containsKey(pid)) {
                    Person p = personsList.findPersonById(pid);
                    p.getBooks().remove(b);
                    b.setPerson(null);
                    HashMap map = new HashMap<String, Object>();
                    map.put("person", p);
                    map.put("freebooks", booksList.getFreeBooks());
                    return new ModelAndView("person.jsp", map);
                }
            }
        }


        return new ModelAndView("persons.jsp", "personsList", personsList);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ModelAndView modifyPerson(HttpServletRequest request,
            HttpServletResponse response, Object command, Model model, BindingResult bindingResult) {

        getListFromRequest(request);
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String active = request.getParameter("active");

        if (id != null) {
            if (personsList.containsKey(id)) {
                Person p = personsList.get(id);
                p.setName(name);
                p.setAge(Integer.parseInt(age));
                p.setActive(Boolean.parseBoolean(active));
            }
        }
        /*
         * String id = request.getParameter("id"); if (id != null){
         * if(personsList.containsKey(id)){ Person p = personsList.get(id);
         * ModelAndView mv = new ModelAndView("person.jsp");
         * mv.addObject("person", p); return mv; } }
         */
        return new ModelAndView("persons.jsp", "personsList", personsList);
    }
}
