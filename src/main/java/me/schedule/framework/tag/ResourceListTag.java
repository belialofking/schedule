package me.schedule.framework.tag;

import me.schedule.framework.AuthorityService;
import me.schedule.framework.ResourceModel;
import org.nutz.mvc.Mvcs;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;


public class ResourceListTag extends SimpleTagSupport {

    private String parentId;

    private String var="item";

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        AuthorityService service = Mvcs.getIoc().get(AuthorityService.class);
        //super.doTag();
        List<ResourceModel> list = service.queryResourceByParent(parentId);
        for (ResourceModel model:list){
            this.getJspContext().setAttribute(var,model);
            this.getJspBody().invoke(null);
        }
    }
}
