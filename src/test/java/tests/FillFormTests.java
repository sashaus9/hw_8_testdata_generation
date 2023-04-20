package tests;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static utils.TestDataGenerator.*;

public class FillFormTests extends BaseTest {

    private final Map<String, String> resultValues = new HashMap<>() {{
        put("Student Name", firstName + " " + lastName);
        put("Student Email", userEmail);
        put("Gender", gender);
        put("Mobile", mobilePhone);
        put("Date of Birth", day + " " + month + "," + year);
        put("Subjects", subject);
        put("Hobbies", hobby);
        put("Picture", photo);
        put("Address", currentAddress);
        put("State and City", state + " " + city);
    }};

    @Test
    void fillFormTest() {
        automationPracticeFormPage.openPage()
                .removeBannerAndFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(mobilePhone)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(photo)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        automationPracticeFormPage.checkThatRegistrationResultsBlockAppears()
                .checkResultValues(resultValues)
                .closeResultModalWindow();
    }
}
