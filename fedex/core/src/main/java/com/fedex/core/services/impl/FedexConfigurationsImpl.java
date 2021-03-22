package com.fedex.core.services.impl;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import com.fedex.core.config.FedexConfig;
import com.fedex.core.services.FedexConfigurations;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

/**
 * This class contains McLaren project configurations.
 */
@Slf4j
@Component(immediate = true,
           service = FedexConfigurations.class)
@Designate(ocd = FedexConfig.class)
public class FedexConfigurationsImpl implements FedexConfigurations {

  /**
   * Variable holds the rssFeedEndpoint.
   */
  @Getter
  private String rssFeedEndpoint;

  /**
   * This method gets triggered on Activation or modification of configurations.
   *
   * @param fedexConfig FedexConfig
   */
  @Activate @Modified protected void activate(final FedexConfig fedexConfig) {
    log.debug("FedexConfigurations Activated/Modified");

    rssFeedEndpoint = fedexConfig.getRssFeedEndpoint();
  }
}
