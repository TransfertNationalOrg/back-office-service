package ma.ensa.converter;

import ma.ensa.dto.ParametreDTO;
import ma.ensa.model.Parametre;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ParametreConverter extends AbstractConverter<Parametre, ParametreDTO> {

    private final ModelMapper modelMapper;

    public ParametreConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public Parametre convertToDM(ParametreDTO parametreDTO) { return modelMapper.map(parametreDTO, Parametre.class); }

    @Override
    public ParametreDTO convertToDTO(Parametre parametre) { return modelMapper.map(parametre, ParametreDTO.class); }
}
