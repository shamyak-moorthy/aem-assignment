package com.fedex.core.slingmodels;

import lombok.Getter;

import java.util.List;

import javax.annotation.PostConstruct;

import com.fedex.core.models.rss.RssFeed;
import com.fedex.core.services.RssFeedImportService;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * This RssFeedModel class.
 */
@Model(adaptables = Resource.class,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class RssFeedModel {

  /**
   * Inject rssFeedImportService.
   */
  @OSGiService
  private RssFeedImportService rssFeedImportService;

  /**
   * rssFeed.
   */
  @Getter
  private RssFeed rssFeed;

  /**
   * Inject rssFeedDataSource.
   */
  @Getter
  @ValueMapValue
  private String rssFeedDataSource;

  /**
   * Inject limit.
   */
  @Getter
  @ValueMapValue
  private int limit;

  /**
   * Inject rssItems
   */
  @Getter
  @ChildResource
  private List<RssItemModel> rssItems;

  /**
   * init method for slingModel.
   */
  @PostConstruct private void init() {
    rssFeed = rssFeedImportService.getRssFeed();
  }
}
