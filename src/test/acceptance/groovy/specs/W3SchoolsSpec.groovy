package specs

import geb.spock.GebReportingSpec
import pages.Home
import pages.Tutorials
import spock.lang.Stepwise


@Stepwise
class W3SchoolsSpec extends GebReportingSpec {
    def homePage = new Home()
    def "The user can search tutorials"() {
        given: "User goes to w3schools page"
            to homePage
        when: "The user searches for a tutorial"
            homePage.search("sql")
        then: "The tutorial page is loaded "
            at Tutorials
            report "The tutorial page is loaded"
    }
}