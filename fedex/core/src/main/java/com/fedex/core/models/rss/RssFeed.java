package com.fedex.core.models.rss;

import lombok.Getter;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * RssFeed class to map with the parent node in xml file.
 */
@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
public class RssFeed implements Serializable {

  /**
   * Map channel node in xml file as child of rss node.
   */
  @Getter
  @XmlElement(name = "channel")
  private Channel channel;
}
