package br.com.mockforge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGeneration {

    private List<FieldDTO> field;
    private Integer amount;

}
