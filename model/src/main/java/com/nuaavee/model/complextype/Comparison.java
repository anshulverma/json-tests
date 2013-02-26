package com.nuaavee.model.complextype;

import java.util.Collections;
import java.util.Map;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.nuaavee.model.company.employee.Employee;

public class Comparison {

  private OperatorType operator;
  private Map<String, Object> expression;

  public Comparison() {
    operator = null;
    expression = Collections.emptyMap();
  }

  public Comparison(OperatorType operator, Map<String, Object> expression) {
    this.operator = operator;
    this.expression = expression;
  }

  public OperatorType getOperator() {
    return operator;
  }
  
  public Map<String, Object> getExpression() {
    return expression;
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
      .append(operator)
      .append(expression)
      .toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Comparison)) {
      return false;
    }

    Comparison other = (Comparison) obj;
    return new EqualsBuilder()
      .append(other.operator, operator)
      .append(other.expression, expression)
      .isEquals();
  }

}
