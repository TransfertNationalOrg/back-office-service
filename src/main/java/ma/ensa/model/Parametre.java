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
    protected Long id;

    //Quotidien
    protected double maxSomAgence=20000;
    protected double maxSomWallet=2000;
    protected double maxRetraitGAB=2000;
    protected int maxnbrTranfAgence=50;

    //En jours
    protected int delaiExpiration=15;
    protected int delaiDesherence=10;

    //Commission en %
    protected double commision=0.2;
    //Commision en MAD
    protected double commissionNotification=5;

    //Heures de batch
    protected Date heureBatchBlocage;
    protected Date heureBatchDesherence;
}
