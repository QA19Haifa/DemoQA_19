package helpers;

import models.Gender;
import models.Hobby;
import models.StudentDTO;
import models.StudentEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public interface HelperStudent extends HelperBase{

default void selectItemForms(){
    if(isElementPresent(By.id("adplus-anchor"))){
        hideAds();
    }
    click(By.xpath("//div[@class='category-cards']/div[2]"));
}

default void selectPracticeForm(){
    click(By.xpath("//span[.='Practice Form']"));
}

default void fillForm(StudentDTO studentDTO){
    type(By.id("firstName"), studentDTO.getFirstName());
    type(By.id("lastName"), studentDTO.getLastName());
    type(By.id("userEmail"), studentDTO.getEmail());
    selectGender(studentDTO.getGender());
    type(By.id("userNumber"), studentDTO.getPhone());
//    type(By.id("dateOfBirthInput"), studentDTO.getBirthday());
    typeBDay(studentDTO.getBirthday());
    addSubjects(studentDTO.getSubjects());
    selectHobby(studentDTO.getHobbies());
    uploadPicture();
    type(By.id("currentAddress"), studentDTO.getAddress());
    selectState(studentDTO.getState());
    selectCity(studentDTO.getCity());
}
default void fillForm(StudentEnum studentDTO){
    type(By.id("firstName"), studentDTO.getFirstName());
    type(By.id("lastName"), studentDTO.getLastName());
    type(By.id("userEmail"), studentDTO.getEmail());
    selectGender(studentDTO.getGender());
    type(By.id("userNumber"), studentDTO.getPhone());
    typeBDaySelect(studentDTO.getBirthday());
    addSubjects(studentDTO.getSubjects());
    selectHobby(studentDTO.getHobbies());
    uploadPicture();
    type(By.id("currentAddress"), studentDTO.getAddress());
    selectState(studentDTO.getState());
    selectCity(studentDTO.getCity());
}

default void selectGender(String gender){
    if(gender.equals("Male")){
        click(By.xpath("//label[@for='gender-radio-1']"));
    } else if(gender.equals("Female")){
        click(By.xpath("//label[@for='gender-radio-2']"));
    } else {
        click(By.xpath("//label[@for='gender-radio-3']"));
    }
}
default void selectGender(Gender gender){
    if(gender.equals(Gender.MALE)){
        click(By.xpath("//label[@for='gender-radio-1']"));
    } else if(gender.equals(Gender.FEMALE)){
        click(By.xpath("//label[@for='gender-radio-2']"));
    } else {
        click(By.xpath("//label[@for='gender-radio-3']"));
    }
}

default void typeBDay(String birthday){
    WebElement date = wd.findElement(By.id("dateOfBirthInput"));
    date.click();
    String os = System.getProperty("os.name");
    System.out.println(os);
    if(os.startsWith("Win")){
        date.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    } else {
        date.sendKeys(Keys.chord(Keys.COMMAND, "a"));
    }
    date.sendKeys(birthday);
    date.sendKeys(Keys.ENTER);
    pause(5000);

}

default void typeBDaySelect(String birthday){
    // 06 29 2000
    String[] date = birthday.split(" ");
    click(By.id("dateOfBirthInput"));
    new Select(wd.findElement(By.className("react-datepicker__month-select"))).selectByValue("" + (Integer.parseInt(date[0]) - 1));
    new Select(wd.findElement(By.className("react-datepicker__year-select"))).selectByValue(date[2]);
    String day = String.format("//div[.='%s']", date[1]);
    List<WebElement> days = wd.findElements(By.xpath(day));
    if(days.size() > 1 && Integer.parseInt(date[1]) > 15){
        days.get(1).click();
    } else {
        days.get(0).click();
    }
//    click(By.xpath("//div[.='" + date[1] + "']"));

}

default void addSubjects(String subject){
    String[] subjects = subject.split(",");
    String locator = "subjectsInput";
    click(By.id(locator));
    for(String subj : subjects){
        wd.findElement(By.id(locator)).sendKeys(subj);
//        click(By.id("react-select-2-option-0"));
        wd.findElement(By.id(locator)).sendKeys(Keys.ENTER);
    }
}

default void selectHobby(String hobby){
    String[] hobbies = hobby.split(",");
    for (String hobb : hobbies){
        switch (hobb){
            case "Sports":
                click(By.xpath("//label[@for='hobbies-checkbox-1']"));
                break;
            case "Reading":
                click(By.xpath("//label[@for='hobbies-checkbox-2']"));
                break;
            case "Music":
                click(By.xpath("//label[@for='hobbies-checkbox-3']"));
                break;
        }
    }
}
default void selectHobby(List<Hobby> hobbies){
    for (Hobby hobby : hobbies){
        switch (hobby){
            case SPORTS:
                click(By.xpath("//label[@for='hobbies-checkbox-1']"));
                break;
            case READING:
                click(By.xpath("//label[@for='hobbies-checkbox-2']"));
                break;
            case MUSIC:
                click(By.xpath("//label[@for='hobbies-checkbox-3']"));
                break;
        }
    }
}

default void uploadPicture(){
    wd.findElement(By.id("uploadPicture")).sendKeys("C:\\QA_Auto_Projects\\QA_19\\DemoQA_19\\student.jpg");
}

default void selectState(String state){
    WebElement element = wd.findElement(By.id("react-select-3-input"));
    element.sendKeys(state);
    element.sendKeys(Keys.ENTER);
}
default void selectCity(String city){
    WebElement element = wd.findElement(By.id("react-select-4-input"));
    element.sendKeys(city);
    element.sendKeys(Keys.ENTER);
}

default void submitForm(){
    if(isElementPresent(By.id("fixedban"))){
        hideDiv();
    }
    click(By.id("submit"));
}
}
