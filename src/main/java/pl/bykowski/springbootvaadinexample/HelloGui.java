package pl.bykowski.springbootvaadinexample;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("hello")
public class HelloGui extends VerticalLayout {

    private TextField textFieldId = new TextField();
    private Label labelid = new Label("Id: ");

    private TextField textFieldName = new TextField();
    private Label labelName = new Label("Name: ");

    private TextField textFieldLastName = new TextField();
    private Label labelLastName = new Label("Last name: ");

    private TextField textFieldAge = new TextField();
    private Label labelLastage = new Label("Age: ");

    private TextField textFieldSex = new TextField();
    private Label labelSex = new Label("Sex: ");

    private Button button = new Button("add user");


    @Autowired
    private UserService userService;

    public HelloGui() {
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(labelid, textFieldId);

        HorizontalLayout h2 = new HorizontalLayout();
        h2.add(labelName, textFieldName);

        HorizontalLayout h3 = new HorizontalLayout();
        h3.add(labelLastName, textFieldLastName);

        HorizontalLayout h4 = new HorizontalLayout();
        h4.add(labelLastage, textFieldAge);

        HorizontalLayout h5 = new HorizontalLayout();
        h5.add(labelSex, textFieldSex);

        add(h1);
        add(h2);
        add(h3);
        add(h4);
        add(h5);
        add(button);

        button.addClickListener(clickEvent -> addUser());
    }

    private void addUser() {
        userService.addUserToApi(Long.parseLong(textFieldId.getValue()),
                textFieldName.getValue(),
                textFieldLastName.getValue(),
                Integer.parseInt(textFieldAge.getValue()),
                textFieldSex.getValue());
    }
}
