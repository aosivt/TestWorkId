package aos.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * класс содержащий объект сушности file_format
 * */
@Entity
@Table(name = "date_up_down_link")
public class DateUpDownLink implements Serializable {
    /**
     * интендификатор таблици date_up_down_link
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)

    private Long id;

    /**
     * дата трафика
     * дата с точностью до секунд?
     * */
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "info_date")
    private java.util.Date infoDate;

    /**
     * Подключение сущности Abonent
     * идентификатор абонента
     * */
    @ManyToOne(targetEntity = Abonent.class,fetch = FetchType.EAGER)
    private Abonent abonent;


    /**
     *  количество трафика, переданного в направлении uplink (байт)
     * */
    @Column(name = "count_up_link")
    private Long countUpLink;
    /**
     *  количество трафика, переданного в направлении downlink(байт).
     * */
    @Column(name = "count_down_link")
    private Long countDownLink;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(Date infoDate) {
        this.infoDate = infoDate;
    }

    public Abonent getAbonent() {
        return abonent;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }

    public Long getCountUpLink() {
        return countUpLink;
    }

    public void setCountUpLink(Long countUpLink) {
        this.countUpLink = countUpLink;
    }

    public Long getCountDownLink() {
        return countDownLink;
    }

    public void setCountDownLink(Long countDownLink) {
        this.countDownLink = countDownLink;
    }
}
