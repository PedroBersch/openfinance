package br.com.xpto.opfpaymentsconsentsregulatoryapi.dto.regulatory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Schedule {
    ScheduleSingle single;
    ScheduleDaily daily;
    ScheduleWeekly weekly;
    ScheduleMonthly monthly;
    ScheduleCustom custom;
}
