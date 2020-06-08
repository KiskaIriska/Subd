package ru.ulstu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.ulstu.model.EduGroup;
import ru.ulstu.service.CrudService;

@SpringBootApplication
public class JpaApplication{
    private final CrudService crudService;

    public JpaApplication(CrudService crudService) {
        this.crudService = crudService;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() {
        for (int course = 1; course < 7; course++) {
            EduGroup eduGroup = crudService.createGroup("ЦПИбв", course, 1);
            for (int j = 0; j < 20 * Math.random(); j++) {
                crudService.createStudent("Иванов", "Иван", "Иванович" + course + " " + j, eduGroup);
            }
        }
        crudService.showAllRecords();
        crudService.showFirstPageOfRecords();

        crudService.showFilteredRecords();

        crudService.showStatistic();
    }
}
