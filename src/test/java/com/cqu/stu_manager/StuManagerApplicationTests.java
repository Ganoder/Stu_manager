package com.cqu.stu_manager;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.cqu.stu_manager.excel.StudentReadListener;
import com.cqu.stu_manager.mapper.MsgMapper;
import com.cqu.stu_manager.mapper.ReceiveMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Msg;
import com.cqu.stu_manager.pojo.Receive;
import com.cqu.stu_manager.pojo.Student;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class StuManagerApplicationTests {
@Autowired
    StudentMapper studentMapper;
@Autowired
    ReceiveMapper receiveMapper;
@Autowired
    MsgMapper msgMapper;
    @Test
    void contextLoads() {
        Student student=new Student();
        student.setStu_no(159753);
        studentMapper.addStudentByExcel(student);


    }
    @Test
    public void simpleRead() {
        StaticComponentContainer.Modules.exportAllToAll();

        // 读取文件，读取完之后会自动关闭
        /*
        	pathName  		文件路径；
        	head			每行数据对应的实体；Student.class
        	readListener	读监听器，每读一样就会调用一次该监听器的invoke方法

        	sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字，不传默认为0
        */
        // 封装工作簿对象
        ExcelReaderBuilder workBook = EasyExcel.read
                ("E:\\student.xls", Student.class, new StudentReadListener(studentMapper));

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();

    }


}
