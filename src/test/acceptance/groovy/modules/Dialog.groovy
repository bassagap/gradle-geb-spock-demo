package modules
import geb.Module

class Dialog extends Module {
    static content = {
        button(wait:true)    {$("div", id: divId)}
    }
    String divId
}
