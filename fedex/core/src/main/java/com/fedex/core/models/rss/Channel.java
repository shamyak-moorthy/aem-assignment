package com.fedex.core.models.rss;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Channel class to map with the channel node in xml file.
 */
@XmlRootElement(name = "channel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel implements Serializable {

  /**
   * Map list of items in the xml file.
   */
  @Getter
  @XmlElement(name = "item")
  private List<Item> items;
}
