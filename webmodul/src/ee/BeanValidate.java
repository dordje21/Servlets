package ee;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.IOException;
import java.util.Set;

@WebServlet("/validate")
public class BeanValidate extends HttpServlet {
    @Inject
    Person2 person;
    @Inject
    Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        person.name = "Max";
        person.age = 18;

//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//
//        Set<ConstraintViolation<Person2>> validate = validator.validate(person);
//        if(validate.size()>0){
//            System.out.println("some error");
//        }
//        for (ConstraintViolation<Person2> violation : validate){
//            System.out.println(violation.getMessage());
//            System.out.println(violation.getInvalidValue());
//        }
//        validatorFactory.close();
    }
}
@RequestScoped
class Person2 {
    @Pattern(regexp = "[A-Z][a-z]*")
    String name;
    @Min(15)
    int age;
}