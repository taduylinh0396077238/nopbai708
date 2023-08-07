package org.aptech.t2109e.springdemo.dto;
import lombok.Data;
        import lombok.NoArgsConstructor;
        import lombok.experimental.SuperBuilder;

        import java.time.LocalDateTime;
@Data
@SuperBuilder
@NoArgsConstructor
public class EmployeeDto extends PageDto<PageDto> {
    private long id;
    private String name;
    private long price;
    private LocalDateTime insert_time;
    private LocalDateTime update_time;
    private String createBy;
    private String updateBy;
}




