
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bills")
public class Bills implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="fio")
    private String fio;
    
    @Column(name="billsum")
    private float billsum;
    
    @Column(name="overall")
    private float overall;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public float getBillsum() {
        return billsum;
    }

    public void setBillsum(float billsum) {
        this.billsum = billsum;
    }

    public float getOverall() {
        return overall;
    }

    public void setOverall(float overall) {
        this.overall = overall;
    }
    
    public Bills(){}
    
    public Bills(String fio, float billsum, float overall){
        this.fio=fio;
        this.billsum=billsum;
        this.overall=overall;
    }
}
