package ma.ensa.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Parametre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //Quotidien
    private double maxSomAgence=20000;
    private double maxSomWallet=2000;
    private double maxRetraitGAB=2000;
    private int maxnbrTranfAgence=50;

    //En jours
    private int delaiExpiration=15;
    private int delaiDesherence=10;

    //Commission en %
    private double commision=0.2;
    //Commision en MAD
    private double commissionNotification=5;

    //Heures de batch
    private Date heureBatchBlocage;
    private Date heureBatchDesherence;
}
