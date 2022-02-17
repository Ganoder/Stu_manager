package com.cqu.stu_manager.excel;

import com.alibaba.excel.EasyExcel;
import com.cqu.stu_manager.excel.pojo.Nationalgrants;
import com.cqu.stu_manager.excel.pojo.Nationalscholarship;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class National_grants_excel {
    @Autowired
    StudentMapper studentMapper;
    public National_grants_excel(StudentMapper studentMapper){
        super();
        this.studentMapper=studentMapper;
    }
    public String write_National_grants_excel(){
        StaticComponentContainer.Modules.exportAllToAll();
        List<Student> studentList=new ArrayList<>();
        studentList=studentMapper.findAllStudent();
        List<Nationalgrants> nationalgrants=new ArrayList<>();
        for(int i=0;i<studentList.size();i++){
            Nationalgrants nationalgrants1 =new Nationalgrants();
            nationalgrants1.setExcel_no(i+1);
            nationalgrants1.setStu_class(studentList.get(i).getStu_class());
            nationalgrants1.setStu_no(studentList.get(i).getStu_no());
            nationalgrants1.setStu_name(studentList.get(i).getStu_name());
            nationalgrants1.setStu_ethnic(studentList.get(i).getStu_ethnic());
            nationalgrants1.setStu_telephone(studentList.get(i).getStu_telephone());
            if(studentList.get(i).getStu_gender().equals(1)){
                nationalgrants1.setStu_gender("男");
            }else nationalgrants1.setStu_gender("女");
            nationalgrants.add(nationalgrants1);

        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        System.out.println(format+"sdsddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        String Path="C:\\Users\\lenovo\\IdeaProjects\\Stu_manager\\";
        String FileName=Path+"助学金信息表"+format+".xls";
        EasyExcel.write(FileName, Nationalgrants.class).sheet("助学金信息表").doWrite(nationalgrants);
        return  FileName;
    }}
