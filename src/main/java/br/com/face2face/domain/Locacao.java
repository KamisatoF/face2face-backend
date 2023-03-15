package br.com.face2face.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locacao")
public class Locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario.id")
    @JsonBackReference
    private Usuario usuario;

    private String espaco;
    private Date dataInicioReserva;

    private Date dataFimReserva;

    private BigDecimal valorTaxas;

    private BigDecimal valorServicos;

    private BigDecimal valorEspaco;

    private BigDecimal valorTotal;

}
