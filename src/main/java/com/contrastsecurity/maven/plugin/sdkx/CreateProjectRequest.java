package com.contrastsecurity.maven.plugin.sdkx;

/*-
 * #%L
 * Contrast Maven Plugin
 * %%
 * Copyright (C) 2021 Contrast Security, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Value type that represents the body of the request to the Contrast Scan API for creating a new
 * project.
 */
public final class CreateProjectRequest {

  private final String name;
  private final String language;
  private final Collection<String> includeNamespaceFilters;
  private final Collection<String> excludeNamespaceFilters;

  /**
   * Constructor.
   *
   * @param name project name
   * @param language project language
   * @param includeNamespaceFilters collection of code namespaces to include in the scan
   * @param excludeNamespaceFilters collection of code namespaces to exclude from the scan
   */
  public CreateProjectRequest(
      final String name,
      final String language,
      final Collection<String> includeNamespaceFilters,
      final Collection<String> excludeNamespaceFilters) {
    this.name = Objects.requireNonNull(name);
    this.language = Objects.requireNonNull(language);
    this.includeNamespaceFilters =
        Collections.unmodifiableCollection(new ArrayList<>(includeNamespaceFilters));
    this.excludeNamespaceFilters =
        Collections.unmodifiableCollection(new ArrayList<>(excludeNamespaceFilters));
  }

  /** @return project name */
  public String getName() {
    return name;
  }

  /** @return project language */
  public String getLanguage() {
    return language;
  }

  /** @return collection of code namespaces to include in the scan */
  public Collection<String> getIncludeNamespaceFilters() {
    return includeNamespaceFilters;
  }

  /** @return collection of code namespaces to exclude from the scan */
  public Collection<String> getExcludeNamespaceFilters() {
    return excludeNamespaceFilters;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final CreateProjectRequest that = (CreateProjectRequest) o;
    return name.equals(that.name)
        && language.equals(that.language)
        && includeNamespaceFilters.equals(that.includeNamespaceFilters)
        && excludeNamespaceFilters.equals(that.excludeNamespaceFilters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, language, includeNamespaceFilters, excludeNamespaceFilters);
  }

  @Override
  public String toString() {
    return "CreateProjectRequest{"
        + "name='"
        + name
        + '\''
        + ", language='"
        + language
        + '\''
        + ", includeNamespaceFilters="
        + includeNamespaceFilters
        + ", excludeNamespaceFilters="
        + excludeNamespaceFilters
        + '}';
  }
}
