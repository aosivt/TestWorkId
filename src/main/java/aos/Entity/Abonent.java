package aos.Entity;

import aos.Repository.Directories;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * класс содержащий объект сушности abonent
 * */
@Entity
@Table(name = "abonent")
public class Abonent implements Serializable, Directories<Abonent>{

    /**
     * интендификатор таблици date_up_down_link
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    /**
     * короткий заголовок таблици file_format
     * */
    @Column(name = "num_tel", nullable = false, unique = true)
    private String numTel;

    /**
     * список трафика првязанного к данному абоненту
     * */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abonent")

    private List<DateUpDownLink> dateUpDownLinks = new ArrayList<>();


    public Abonent(){}
    public Abonent(String numTel){
        this.numTel = numTel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public List<DateUpDownLink> getDateUpDownLinks() {
        return dateUpDownLinks;
    }

    public void setDateUpDownLinks(List<DateUpDownLink> dateUpDownLinks) {
        this.dateUpDownLinks = dateUpDownLinks;
    }

    @Override
    public String toString(){
        return numTel;
    }

    @Override
    public Abonent getDirectories() {
        return this;
    }

    @Override
    public String getDirName() {
        return this.numTel;
    }
}
