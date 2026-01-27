package com.sahil.lombok.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTO {
  private String custName;
  private UUID custId;
  private Integer version;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;
  
}
