package com.fedex.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/**
 * This interface contains the all configuration properties for the Fedex Site.
 */
@ObjectClassDefinition(name = "Fedex Service Configuration",
                       description = "Fedex Common Configuration Details")
public @interface FedexConfig {

  /**
   * RSS Feed Endpoint.
   *
   * @return rss feed endpoint
   */
  @AttributeDefinition(name = "rssFeedEndpoint",
                       description = "RSS Feed Endpoint") String getRssFeedEndpoint() default "https://www.nba.com/bucks/rss.xml";

}

