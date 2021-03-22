package com.fedex.core.models.rss;

import lombok.Getter;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Item class to map with the item node in xml file.
 */
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements Serializable {

  /**
   * Map title node in xml file as child of channel node.
   */
  @Getter
  @XmlElement(name = "title")
  private String title;

  /**
   * Map channel node in xml file as child of channel node.
   */
  @Getter
  @XmlElement(name = "description")
  private String description;

  /**
   * Map channel node in xml file as child of channel node.
   */
  @Getter
  @XmlElement(name = "pubDate")
  private String pubDate;
}
