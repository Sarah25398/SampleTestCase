package Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
public class BankPageAdmin {
    public WebDriver driver;
    public BankPageAdmin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="//ul[@class='leftmenu']/li/a")
    private List <WebElement> TitlePages;
    public List<WebElement> TitlePageLists (){
        return List.of(TitlePages.get(0),TitlePages.get(1),TitlePages.get(4));
    }
    public List<String> TitlePageAttributes(){
        List<String> TitlePageAttributes = new ArrayList<>();
        for(WebElement TitlePageList: TitlePageLists()){
            String href =  TitlePageList.getAttribute("href") ;
            String clean_Url = href.split(";jsessionid=")[0];
            TitlePageAttributes.add(clean_Url);

        }
        return TitlePageAttributes;
    }





}
