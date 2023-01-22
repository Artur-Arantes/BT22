package br.com.tiraboschi.bt22.model;

import br.com.tiraboschi.bt22.enums.EnumUserPermission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(callSuper = true)
@Getter
@Builder
@AttributeOverrides(value = {
    @AttributeOverride(name = "id", column = @Column(name = "id_per")),
    @AttributeOverride(name = "version", column = @Column(name = "ver_per")),
    @AttributeOverride(name = "createdAt", column = @Column(name = "cre_at_per")),
    @AttributeOverride(name = "updatedAt", column = @Column(name = "upd_at_per"))
})
@Generated
public class Permission extends BaseEntity implements GrantedAuthority {


  @Convert(converter = EnumUserPermission.Converter.class)
  @Column(name = "nom_per")
  @Getter(onMethod = @__(@JsonIgnore))
  EnumUserPermission permission;

  @Override
  public String getAuthority() {
    return permission.getRole();
  }
}
