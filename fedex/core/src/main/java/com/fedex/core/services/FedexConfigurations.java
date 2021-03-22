package com.fedex.core.services;

/**
 * Interface for Fedex Configurations Service to expose only required methods.
 */
public interface FedexConfigurations {

  /**
   * this method should return the rss feed endpoint.
   *
   * @return String rss feed endpoint.
   */
  String getRssFeedEndpoint();
}
