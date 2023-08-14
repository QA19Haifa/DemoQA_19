import helpers.HelperStudent;
import models.StudentDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTests extends TestBase implements HelperStudent {

@BeforeMethod
    public void precondition(){
    selectItemForms();
    selectPracticeForm();
    hideAds();
    hideFooter();
}

@Test
    public void studentFormPositive(){
    StudentDTO studentDTO = StudentDTO.builder()
            .firstName("Johanna")
            .lastName("Doe")
            .email("joahnna@mail.com")
            .gender("Female")
            .phone("1234567890")
            .birthday("14 08 2000")
            .subjects("Maths,Physics")
            .hobbies("Sports,Music")
            .address("Main street, 5")
            .state("NCR")
            .city("Delhi")
            .build();

    fillForm(studentDTO);
    submitForm();
}

}
