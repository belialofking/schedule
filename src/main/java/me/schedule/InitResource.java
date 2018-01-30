package me.schedule;

import me.schedule.framework.ResourceModel;
import org.nutz.dao.Dao;

import java.util.ArrayList;
import java.util.List;


public class InitResource {
    List<ResourceModel> resourceList = new ArrayList<>();
    private ResourceModel generateResource(){
        ResourceModel model = new ResourceModel();

        return model;
    }
    public void init(Dao dao){

    }
}
