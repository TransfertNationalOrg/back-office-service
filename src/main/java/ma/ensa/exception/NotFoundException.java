package ma.ensa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class NotFoundException extends Exception{

    private Long id;

}
