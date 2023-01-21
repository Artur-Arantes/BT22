CREATE TABLE IF NOT EXISTS pessoa(
    id_pes BIGINT(20) NOT NULL AUTO_INCREMENT,
    nom_pes VARCHAR(255) NOT NULL,
    ver_pes INT(11) NOT NULL DEFAULT 1,
    cre_at_pes DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    upd_at_pes DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_pessoa PRIMARY KEY (id_pes)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS permissao(
    id_per BIGINT(20) NOT NULL AUTO_INCREMENT,
    nom_per VARCHAR(255) NOT NULL,
    ver_per INT(11) NOT NULL DEFAULT 1,
    cre_at_per DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    upd_at_per DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_permissao PRIMARY KEY(id_per)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS usuario(
    id_usu BIGINT(20) NOT NULL AUTO_INCREMENT,
    log_usu VARCHAR(10) NOT NULL,
    sen_usu VARCHAR(255) NOT NULL,
    id_pes BIGINT(20) NOT NULL,
    ver_usu INT(11) NOT NULL DEFAULT 1,
    acc_non_exp_usu BIT(1),
    ena_usu BIT(1),
    cre_non_exp_usu BIT(1),
    acc_non_loc_usu BIT(1),
    cre_at_usu DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    upd_at_usu DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_usuario PRIMARY KEY(id_usu),
    CONSTRAINT fk_usuario_pessoa FOREIGN KEY (id_pes) REFERENCES pessoa(id_pes)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS usuario_permissao(
    id_per BIGINT(20) NOT NULL,
    id_usu BIGINT(20) NOT NULL,
    CONSTRAINT pk_usuario_permissao PRIMARY KEY (id_per, id_usu),
    CONSTRAINT fk_usuario_permissao_permissao FOREIGN KEY(id_per) REFERENCES permissao(id_per),
    CONSTRAINT fk_usuario_permissao_usu FOREIGN KEY(id_usu) REFERENCES usuario(id_usu)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;