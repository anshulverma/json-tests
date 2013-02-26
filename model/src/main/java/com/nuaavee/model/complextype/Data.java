package com.nuaavee.model.complextype;

import static org.apache.commons.lang.StringUtils.EMPTY;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonUnwrapped;
import com.nuaavee.model.company.employee.Employee;

public class Data {
  private int id;
  private String comment;
  private DataType type;
  @JsonUnwrapped
  private Comparison comparison;
  
  public Data() {
    id = 0;
    comment = EMPTY;
    type = null;
    comparison = null;
  }
  
  public Data(int id, String comment, DataType type, Comparison comparison) {
    this.id = id;
    this.comment = comment;
    this.type = type;
    this.comparison = comparison;
  }
  
  public int getId() {
    return id;
  }
  
  public String getComment() {
    return comment;
  }
  
  public DataType getType() {
    return type;
  }
  
  public Comparison getComparison() {
    return comparison;
  }
  
  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this,
        ToStringStyle.SHORT_PREFIX_STYLE);
  }
  
  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .appendSuper(super.hashCode())
      .append(id)
      .append(comment)
      .append(type)
      .append(comparison)
      .toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Data)) {
      return false;
    }

    Data other = (Data) obj;
    return new EqualsBuilder()
      .append(other.id, id)
      .append(other.comment, comment)
      .append(other.type, type)
      .append(other.comparison, comparison)
      .isEquals();
  }

}
