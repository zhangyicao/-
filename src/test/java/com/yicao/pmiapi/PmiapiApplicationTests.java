package com.yicao.pmiapi;

import com.yicao.pmiapi.pojo.Worker;
import com.yicao.pmiapi.service.IWorkerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class PmiapiApplicationTests {

    @Autowired
    IWorkerService IWorkerService;

	@Test
	void testAdd() throws SQLException, ParseException {
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1990-05-06");
        Worker worker = new Worker("李九", "其他", "员工", birthday, 1, "123456789", "湖南省长沙市天心区暮云街道960号", "湖南岳阳", "https://lin-xin.gitee.io/images/post/wms.png", "无");
//        System.out.println(worker);
        Integer result = IWorkerService.addWorker(worker);
        System.out.println(result);
    }

    @Test
    void testDel() {
        System.out.println(IWorkerService.deleteWorker(5));
    }

    @Test
    void testUpdate() throws ParseException {
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1990-05-06");
        Worker worker = new Worker(6,"李九", "其他", "部长", birthday, 1, "123456789", "湖南省长沙市天心区暮云街道960号", "湖南岳阳", "https://lin-xin.gitee.io/images/post/wms.png", "无");
        Integer result = IWorkerService.updateWorker(worker);
        System.out.println(result);
    }

    @Test
    void testCount(){
        System.out.println(IWorkerService.countWorker());
    }

}
