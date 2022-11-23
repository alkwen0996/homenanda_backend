package com.home.nanda.board.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Article {
    @ApiModelProperty(value = "글번호")
    private String userId;

    @ApiModelProperty(value = "작성자 아이디")

    private String articleId;

    @ApiModelProperty(value = "글제목")
    private String subject;

    @ApiModelProperty(value = "글내용")
    private String content;

    @ApiModelProperty(value = "작성일")
    private String createdDate;

    @ApiModelProperty(value = "수정일")
    private String updatedDate;

    @ApiModelProperty(value = "조회수")
    private Long hit;

    @ApiModelProperty(value = "공지사항, 게시글 확인")
    private String type; // 게시글인지 공지사항글인지 QnA글인지 확인.
}
