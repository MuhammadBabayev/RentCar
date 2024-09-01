package org.example.rentcar.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCommentDTO {
    private Long id;
    private Long userId;
    private Long carId;
    private String comment;
}
