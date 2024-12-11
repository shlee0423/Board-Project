package com.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Integer no;
    private String userId;
    private Integer boardNo;
    private String comment;
    private LocalDateTime commentDateTime;
}
