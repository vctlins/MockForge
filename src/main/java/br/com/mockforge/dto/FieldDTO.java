package br.com.mockforge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldDTO {

    private String type;
    private Map<String, Object> options;

}
