var ioc = {
  dataSource: {
    type: "com.alibaba.druid.pool.DruidDataSource",
    events: {
      create: "init",
      depose: 'close'
    },
    fields: {
      url: "jdbc:mysql://127.0.0.1:3306/task",
      username: "root",
      password: "root",
      testWhileIdle: true,
      validationQuery: "select 1",
      maxActive: "5"
    }
  },
  dao: {
    type: "org.nutz.dao.impl.NutDao",
    args: [{refer: "dataSource"}]
  }

};

