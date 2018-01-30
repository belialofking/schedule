package me.schedule;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/",
                                           "*anno", "me.schedule",
                                           "*tx"})
@Modules(scanPackage=true)
@SetupBy(value=MainSetup.class)
@Ok("json")
@Fail("json")
public class MainApp {

}
