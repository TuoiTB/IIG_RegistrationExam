package test.interview;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.gson.GsonFactory;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveDataFromSeleniumToGG {

    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "Sheet1"; // Thay bằng ID của Google Sheet
    private static String RANGE = "Sheet1!A1"; // Vị trí bắt đầu

    public static void main(String[] args) throws IOException {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://ratings.fide.com/topfed.phtml?ina=1&country=AUS");

        // Lấy dropdown và tất cả các options
        List<WebElement> SpeedDropDownList = driver.findElements(By.xpath("//b[text()='Australia']/parent::font//following::tbody//tr/td[2]"));
        List<String> listText = new ArrayList<>();
        for (WebElement tempItem : SpeedDropDownList){
            String itemText = tempItem.getText();
            listText.add(itemText);
        }

        //------------------------
        // Google Sheets API
        // Đường dẫn đến file credentials JSON
        FileInputStream serviceAccountStream = new FileInputStream("D:\\Automation\\IIG_RegistrationExam\\src\\test\\java\\test\\interview\\credential.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccountStream)
                .createScoped(Arrays.asList("https://www.googleapis.com/auth/spreadsheets"));
        HttpTransport httpTransport = new NetHttpTransport();
        JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        sheetsService = new Sheets.Builder(httpTransport, jsonFactory, (HttpRequestInitializer) credentials)
                .setApplicationName("Selenium-Google-Sheets")
                .build();
        // Chuyển List<String> thành List<List<Object>> để gửi cho Google Sheets
        List<List<Object>> values = new ArrayList<>();
        for (String item : listText) {
            values.add(Arrays.asList(item));  // Mỗi phần tử trong listText sẽ thành một danh sách (để tương thích với Sheets API)
        }
        ValueRange body = new ValueRange().setValues(values);
        UpdateValuesResponse result = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, RANGE, body)
                .setValueInputOption("RAW")
                .execute();

        System.out.println(result.getUpdatedCells() + " cells updated.");
    }
}