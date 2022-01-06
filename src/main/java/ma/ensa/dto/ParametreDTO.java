package ma.ensa.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ParametreDTO {

    private Long id;
    private double maxSomAgence=20000;
    private double maxSomWallet=2000;
    private double maxRetraitGAB=2000;
    private int maxnbrTranfAgence=50;
    private int delaiExpiration=15;
    private int delaiDesherence=10;
    private double commision=0.2;
    private double commissionNotification=5;
    private Date heureBatchBlocage;
    private Date heureBatchDesherence;
}
