package com.fedex.core.slingmodels;

import lombok.Getter;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * This RssItemModel class.
 */
@Model(adaptables = Resource.class,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class RssItemModel {

  /**
   * Inject title.
   */
  @Getter
  @ValueMapValue
  String title;

  /**
   * Inject description.
   */
  @Getter
  @ValueMapValue
  String description;

  /**
   * Inject pubDate.
   */
  @Getter
  @ValueMapValue
  String pubDate;
}
