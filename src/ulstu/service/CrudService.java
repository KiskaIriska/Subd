package ru.ulstu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.ulstu.model.EduGroup;
import ru.ulstu.model.Student;

import java.util.Date;
import java.util.Optional;

@Service
public class CrudService {
    private static final Logger log = LoggerFactory.getLogger(CrudService.class);

    private final static String GROUP_NAME_PATTERN = "%s-%s%s";
    private final static int PAGE_OF_RECORDS_SIZE = 10;
    private final StudentService studentService;
    private final EduGroupService eduGroupService;

    public CrudService(StudentService studentService,
                       EduGroupService eduGroupService) {
        this.studentService = studentService;
        this.eduGroupService = eduGroupService;
    }

    public Student createStudent(String lastName, String firstName, String patronymic, EduGroup eduGroup) {
        log.info("Create student:\n");
        if (eduGroup == null) {
            throw new RuntimeException("Edu group must not empty");
        }
        if (eduGroup.getId() == null) {
            throw new RuntimeException("Edu group id must not null");
        }
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPatronymic(patronymic);
        student.setEduGroup(eduGroup);
        student.setBirthDate(new Date());
        log.info(student.toString());
        return studentService.create(student);
    }

    public EduGroup createGroup(String groupNamePart, int course, int groupNumber) {
        log.info("Create group:\n");
        EduGroup eduGroup = new EduGroup();
        eduGroup.setName(String.format(GROUP_NAME_PATTERN, groupNamePart, course, groupNumber));
        eduGroup.setCourse(course);
        eduGroup.setGroupNumber(groupNumber);
        log.info(eduGroup.toString());
        return eduGroupService.create(eduGroup);
    }

    public void showAllRecords() {
        log.info("All records:\n");
        log.info(studentService.findAll().toString());
        log.info(eduGroupService.findAll().toString());
    }

    public void showFirstPageOfRecords() {
        log.info("First page of records:\n");
        log.info(studentService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(eduGroupService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
    }

    public void showFilteredRecords() {
        log.info("Filtered records:\n");
        Optional<EduGroup> foundGroup = eduGroupService.findByName("ЦПИбв-11").stream().findAny();
        if (foundGroup.isPresent()) {
            log.info(foundGroup.get().toString());
            log.info(studentService.findByEduGroup(foundGroup.get()).toString());
        }
        log.info(eduGroupService.findByPartOfName("цпибв-1").toString());
    }

    public void showStatistic() {
        log.info("Group statistic:\n");
        log.info(eduGroupService.getGroupsCountByCourse(1).toString());
    }
}
