package pageUI;

public class RegistrationToeicExamPageUI {
    //name, identification card, place,
    public static final String INFOR_PERSIONAL_DYNAMIC_TEXTBOX_BY_LABEL = "XPATH=//h4[text()='THÔNG TIN CÁ NHÂN']/following-sibling::div//label[contains(text(),'%s')]/following-sibling::input";
    public static final String INFOR_PERSIONAL_DYNAMIC_DATE_BY_LABEL = "XPATH=//h4[text()='THÔNG TIN CÁ NHÂN']/following-sibling::div//label[text()='%s']/following-sibling::div/input";
    public static final String ACTIVE_DAY = "CSS=td.active";
    public static final String PHONE_TEXTBOX = "XPATH=//input[@name='Phone']";

    public static final String CITY_CONTACT_DROPDOWN = "XPATH=//select[@id='CityContact']";
    public static final String DISTRICT_CONTACT_DROPDOWN = "XPATH=//select[@id='DistrictContact']";
    public static final String WARD_CONTACT_DROPDOWN = "XPATH=//select[@id='WardContact']";
    public static final String CITY_WORK_DROPDOWN = "XPATH=//select[@id='CityWork']";
    public static final String DISTRICT_WORK_DROPDOWN = "XPATH=//select[@id='DistrictWork']";
    public static final String WARD_WORK_DROPDOWN = "XPATH=//select[@id='WardWork']";
    public static final String CITY_RECEIVER_DROPDOWN = "XPATH=//select[@id='ReceiverCity']";
    public static final String DISTRICT_RECEIVER_DROPDOWN = "XPATH=//select[@id='ReceiverDistrict']";
    public static final String WARD_RECEIVER_DROPDOWN = "XPATH=//select[@id='ReceiverWard']";


    public static final String DYNAMIC_DEFAULT_DROPDOWN_BY_NAME = "XPATH=//select[@name='%s']";
    public static final String DYNAMIC_DEFAULT_DROPDOWN_BY_ID = "XPATH=//select[@id='%s']";
    public static final String DYNAMIC_CHECKBOX_BY_TEXT = "XPATH=//label[contains(string(),'%s')]/input";
    public static final String DYNAMIC_RADIO_BUTTON_BY_TEXT = "XPATH=//select[@id='%s']";
    public static final String SCORE_GOAL_TEXTBOX = "XPATH=//label[text()='Mục tiêu điểm số']/following-sibling::input";
    public static final String DYNAMIC_STATUS_EXAM_CHECKBOX_BY_ID = "XPATH=//input[@id='%s']";
    public static final String AGREE_CHECKBOX = "XPATH=//label[contains(string(),'Tôi xin cam kết')]/preceding-sibling::input";
    public static final String SUBMIT_BUTTON = "CSS=button#SubmitProfile";
    public static final String ICON_LOADING = "XPATH=//div[@class='spinner-border']";
    public static final String ERROR_FADING = "XPATH=//div[not(@style='display: none;') and @class='toast error fading']//div[text()='Vui lòng đăng ký lại sau 2 ngày từ ngày đăng ký gần nhất']";
    public static final String SUBMIT_SUCCESSFULLY_MESSAGE = "XPATH=//p[text()='Thí sinh đã đặt lịch hẹn để hoàn thiện hồ sơ đăng ký dự thi thành công! ']";
    public static final String CLOSE_BUTTON = "XPATH=//button[@onclick='CloseNotifySuccess()']";
    public static final String UPLOAD_AVATAR_FILE = "XPATH=//input[@id='Image3x4' and @type='file']";
    public static final String UPLOAD_CARD_FRONT_FILE = "XPATH=//input[@id='IDCardFront' and @type='file']";
    public static final String UPLOAD_CARD_BACK_FILE = "XPATH=//input[@id='IDCardBack' and @type='file']";
    public static final String CROP_BUTTON = "XPATH=//button[@id='cropImageBtn']";

}
