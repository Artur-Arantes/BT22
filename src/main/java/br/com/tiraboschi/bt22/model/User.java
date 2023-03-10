package br.com.tiraboschi.bt22.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@AttributeOverrides(value = {
    @AttributeOverride(name = "id", column = @Column(name = "id_usu")),
    @AttributeOverride(name = "version", column = @Column(name = "ver_usu")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "cre_at_usu")),
    @AttributeOverride(name = "updatedAt", column = @Column(name = "upd_at_usu"))
})
@ToString(callSuper = true)
@Generated
public class User extends BaseEntity implements UserDetails {

  @OneToOne(fetch = FetchType.EAGER, targetEntity = Person.class)
  @JsonManagedReference
  @JoinColumn(name = "id_pes")
  @ToString.Exclude
  private Person person;

  @NotNull
  @NotEmpty
  @Column(name = "sen_usu")
  @Size(min = 3)
  @Getter(onMethod = @__(@Override))
  private String password;

  @NotNull
  @NotEmpty
  @Size(min = 3)
  @Column(name = "log_usu")
  @Getter(onMethod = @__(@Override))
  private String username;
  @ManyToMany(fetch = FetchType.EAGER)
  @ToString.Exclude
  @JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "id_usu", referencedColumnName = "id_usu"),
      inverseJoinColumns = @JoinColumn(name = "id_per", referencedColumnName = "id_per"))
  List<Permission> permissions;

  @Column(name = "acc_non_exp_usu")
  @Getter(onMethod = @__(@Override))
  private boolean accountNonExpired;

  @Column(name = "cre_non_exp_usu")
  @Getter(onMethod = @__(@Override))
  private boolean credentialsNonExpired;

  @Column(name = "ena_usu")
  @Getter(onMethod = @__(@Override))
  private boolean enabled;

  @Column(name = "acc_non_loc_usu")
  @Getter(onMethod = @__(@Override))
  private boolean accountNonLocked;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.permissions;
  }


}