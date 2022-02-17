package com.cqu.stu_manager;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.cqu.stu_manager.excel.StudentWrite;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import lombok.SneakyThrows;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class StuManagerApplicationTests {
@Autowired
    StudentMapper studentMapper;
@Autowired
    ReceiveMapper receiveMapper;
@Autowired
    ContestMapper contestMapper;
@Autowired
PaperMapper paperMapper;
@Autowired
PatentMapper patentMapper;
@Autowired
ProjectMapper projectMapper;
@Autowired
DispatchMapper dispatchMapper;
@Autowired
Voluntary_activitiesMapper voluntary_activitiesMapper;

    @SneakyThrows
    @Test
    void contextLoads() {
        StudentWrite studentWrite=new StudentWrite(studentMapper);
        studentWrite.studentinfo_out();

    }
}
