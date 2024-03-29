package br.com.face2face.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conta_bancaria")
public class ContaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario.id")
    @JsonBackReference
    private Usuario usuario;
    private String banco;
    private String agencia;
    private String cc;
    private String digito;
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userid;
}
