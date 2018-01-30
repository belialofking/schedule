package me.schedule;

import me.schedule.framework.AuthorityFilter;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/",
                                           "*anno", "me.schedule",
                                           "*tx"})
@Modules(scanPackage=true)
@SetupBy(value=MainSetup.class)
@Filters({@By(type=AuthorityFilter.class, args={"ioc:authorityFilter"})})
@Ok("json")
@Fail("json")
public class MainApp {

}
