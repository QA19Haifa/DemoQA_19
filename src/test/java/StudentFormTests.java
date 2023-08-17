import helpers.HelperStudent;
import models.Gender;
import models.Hobby;
import models.StudentDTO;
import models.StudentEnum;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
            .birthday("06 17 2000")
            .subjects("Maths,Physics")
            .hobbies("Sports,Music")
            .address("Main street, 5")
            .state("NCR")
            .city("Delhi")
            .build();

    fillForm(studentDTO);
    hideFooter();
    submitForm();
}
@Test
    public void studentFormEnumPositive(){

    List<Hobby> hobbies = new ArrayList<>();
    hobbies.add(Hobby.MUSIC);
    hobbies.add(Hobby.READING);

    StudentEnum studentDTO = StudentEnum.builder()
            .firstName("Johanna")
            .lastName("Doe")
            .email("joahnna@mail.com")
            .gender(Gender.FEMALE)
            .phone("1234567890")
            .birthday("06 29 2000")
            .subjects("Maths,Physics")
            .hobbies(hobbies)
            .address("Main street, 5")
            .state("NCR")
            .city("Delhi")
            .build();

    fillForm(studentDTO);
    hideFooter();
    submitForm();
}

}
