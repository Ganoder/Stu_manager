package com.cqu.stu_manager;

import com.cqu.stu_manager.excel.NationalGrantsExcel;
import com.cqu.stu_manager.excel.StudentListHeadmasterExcel;
import com.cqu.stu_manager.mapper.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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
@Autowired
AccommodationMapper accommodationMapper;
@Autowired
CollegeEntranceExaminationMapper collegeEntranceExaminationMapper;
@Autowired
FamilyMapper familyMapper;
@Autowired
ClassMapper classMapper;

    @SneakyThrows
    @Test
    void contextLoads() {
//        NationalGrantsExcel national_grantsExcel =new NationalGrantsExcel(studentMapper);
//        String s= national_grantsExcel.write_National_grants_excel();
//        System.out.println(s);
////        National_scholarship_excel national_scholarship_excel=new National_scholarship_excel(studentMapper);
////        national_scholarship_excel.write_National_scholarship_excel_forSelf_Improvement();
////                    StudentRead studentRead=new StudentRead(studentMapper);
////                    studentRead.simpleRead();
        System.out.println(classMapper.findClassByTeacher("2"));
    }
}
