package ru.serafim.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductForm {

    @Size(min = 3, max = 20)
    @NotBlank
    private String name;

    @DecimalMax(value = "100000")
    @DecimalMin(value = "1")
    private Integer mass;

    @NotBlank
    @Size(min = 10, max = 10)
    private String vin;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @PastOrPresent
    private LocalDate date;

}
