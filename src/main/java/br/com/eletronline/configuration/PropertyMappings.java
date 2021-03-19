package br.com.eletronline.configuration;

import static java.util.Objects.nonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.modelmapper.PropertyMap;

public class PropertyMappings {

  private List<PropertyMap<?, ?>> mappings = new ArrayList<>();

  public PropertyMappings(final PropertyMap<?, ?>... properties) {
    if (!nonNull(properties) || properties.length == 0) {
      this.mappings = Collections.emptyList();
    } else {
      this.mappings = Arrays.asList(properties);
    }
  }

  public List<PropertyMap<?, ?>> getMappings() {
    return Collections.unmodifiableList(mappings);
  }
}
