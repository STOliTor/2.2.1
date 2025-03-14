package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @Column(name = "car_id")
//    private Long id;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car(){}

    public Car(String model, String series) {
        this.model = model;
        this.series = series;
    }

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private String series;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }



}
