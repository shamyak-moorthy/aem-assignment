package com.fedex.core.services.impl;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.fedex.core.models.rss.RssFeed;
import com.fedex.core.services.FedexConfigurations;
import com.fedex.core.services.RssFeedImportService;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.osgi.services.HttpClientBuilderFactory;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Service to import RSS feed.
 */
@Slf4j
@Component(immediate = true,
           service = RssFeedImportService.class)
public class RssFeedImportServiceImpl implements RssFeedImportService {

  /**
   * Inject HttpClientBuilderFactory.
   */
  @Reference
  private HttpClientBuilderFactory httpClientBuilderFactory;

  /**
   * Inject FedexConfigurations.
   */
  @Reference
  private FedexConfigurations fedexConfigurations;

  /**
   * Method returns rss feed java object.
   *
   * @return rssFeed
   */
  @Override public RssFeed getRssFeed() {
    RssFeed rssFeed = null;
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(RssFeed.class);
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
      rssFeed = (RssFeed) unmarshaller.unmarshal(new StringReader(getRssFeedResponse()));
    } catch (Exception e) {
      log.error("Exception in getRssFeed :: RssFeedImportServiceImpl ", e);
    }

    return rssFeed;
  }

  /**
   * Method returns rss feed response.
   *
   * @return response
   * @throws IOException exception
   */
  private String getRssFeedResponse() throws IOException {
    HttpPost post = new HttpPost(fedexConfigurations.getRssFeedEndpoint());
    post.addHeader("Content-Type", "application/xml");
    CloseableHttpClient httpClient = httpClientBuilderFactory.newBuilder().build();
    CloseableHttpResponse execute = httpClient.execute(post);
    return EntityUtils.toString(execute.getEntity(), "UTF-8");
  }
}
