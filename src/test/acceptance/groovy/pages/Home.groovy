package pages

import geb.Page
import modules.Dialog
import org.openqa.selenium.By

class Home extends Page {
    static content = {
        cookiesModule(wait:true)            { id -> module(new Dialog(divId: id)) }
        tutorialSearchInput(wait:true)      { $(By.id("search2"))}
        searchButton(wait:true)             { $(By.xpath("//*[@id=\"learntocode_searchbtn\"]")) }
      }
    static at = { title.contains("W3Schools Online Web Tutorials")}
    void search(String tutorialName){
        cookiesModule("accept-choices").button.click()
        tutorialSearchInput.value(tutorialName)
        searchButton.click()
    }
}
