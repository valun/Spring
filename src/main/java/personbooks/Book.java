
package personbooks;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.Validator;


public class Book {
    private String id;
    
    @NotNull(message="required Title")
    private String title;
    
    private String person;

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getPerson() {
        return person;
    }
    public void setPerson(String person) {
        this.person = person;
    }
    
    
public static void validate(Object object, Validator validator) {
    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
    
    System.out.println(object);
    System.out.println(String.format("Errors count: %d",
        constraintViolations.size()));
    
    for (ConstraintViolation<Object> cv : constraintViolations)
      System.out.println(String.format(
          "Warning. ERROR! property: [%s], value: [%s], message: [%s]", 
          cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
  }    
    
    public Book(String id, String title){
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();      
        this.id = id;
        this.title = title;
        validate(this.title, validator);
        this.person = null;
    }
}
