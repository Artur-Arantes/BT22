package br.com.tiraboschi.bt22.integration;

import org.testcontainers.containers.MySQLContainer;

public class Bt22DatabaseContainer extends MySQLContainer<Bt22DatabaseContainer> {

  public static final String MYSQL_VERSION = "mysql:5.7";
  public static final String APP_NAME = "offnance";

  private boolean isActive;

  public static Bt22DatabaseContainer container;

  public static Bt22DatabaseContainer getInstance() {
    return getInstance(true);
  }

  public static Bt22DatabaseContainer getInstance(final boolean isActive) {
    if (container == null) {
      container = new Bt22DatabaseContainer(isActive);
    }
    return container;
  }

  public Bt22DatabaseContainer(final boolean isActive) {
    super(MYSQL_VERSION);
    this.withUsername(APP_NAME).withDatabaseName(APP_NAME).withPassword(APP_NAME)
        .isActive(isActive).withReuse(false);
  }

  private Bt22DatabaseContainer isActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  @Override
  public void start() {
    if (this.isActive) {
      super.start();
      System.setProperty("DB_URL", container.getJdbcUrl());
      System.setProperty("DB_USR", container.getUsername());
      System.setProperty("DB_PASS", container.getPassword());
    }
  }

  @Override
  public void stop() {
  }
}