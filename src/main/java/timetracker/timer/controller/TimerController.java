package timetracker.timer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import timetracker.timer.service.TimerService;
import timetracker.timer.dto.ProjectTimeSpentDto;

import java.math.BigDecimal;

@RestController("/timer")
@RequiredArgsConstructor
public class TimerController {

    private final TimerService timerService;

    @GetMapping("/get-remaining-budget/{projectName}")
    public BigDecimal getRemainingBudget(@PathVariable String projectName) {
        return timerService.calculateRemainingBudget(projectName);
    }

    @GetMapping("/get-remaining-time/{projectName}")
    public Integer getRemainingTime(@PathVariable String projectName) {
        return timerService.calculateRemainingTime(projectName);
    }

    @PostMapping("/book-time-to-project")
    public void bookTimeToProject(@RequestBody ProjectTimeSpentDto projectTimeSpentDto) {
        timerService.bookSpentTimeToProject(projectTimeSpentDto);
    }

}
