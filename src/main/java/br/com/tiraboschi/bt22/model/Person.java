package br.com.tiraboschi.bt22.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(of = "id")
@AttributeOverrides(value = {
    @AttributeOverride(name = "id", column = @Column(name = "id_pes")),
    @AttributeOverride(name = "version", column = @Column(name = "ver_pes")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "cre_at_pes")),
    @AttributeOverride(name = "updatedAt", column = @Column(name = "upd_at_pes"))
})
@Generated
public class Person extends BaseEntity {

  @Column(name = "nom_pes")
  private String name;

  @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
  @JsonManagedReference
  @JoinColumn(name = "id_pes")
  @ToString.Exclude
  private User user;

}