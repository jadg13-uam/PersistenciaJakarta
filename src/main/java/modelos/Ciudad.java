package modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ciudad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Long id;

    @Column(length = 100, nullable = false, name = "nombre_ciudad")
    private String nombre;

    @Column(length = 200, name = "descripcion_ciudad")
    private String descripcion;

    @Column(name = "latitud")
    private double latitud;

    @Column(name = "longitud")
    private double longitud;
}
