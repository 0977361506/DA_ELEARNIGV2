package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vnpost.e_learning.entities.AnswerComment;
import com.vnpost.e_learning.entities.Comment;
@Component
@Getter
@Setter
public class CommentDTO {
    private long id;

    private String contents;

    private String createdBy;

    private Date createdDate;

    private String  modifiedBy;

    private Date modifiedDate;

    //bi-directional many-to-one association to Course
    
	private List<AnswerComment> list;
    //bi-directional many-to-one association to User
    public CommentDTO  convertFromComment(Comment comment) {
    	CommentDTO commentDTO = new CommentDTO();
    	commentDTO.setContents(comment.getContents());
    	commentDTO.setId(comment.getId());
    	commentDTO.setCreatedBy(comment.getCreatedBy());
    	commentDTO.setCreatedDate(comment.getCreatedDate());
    	commentDTO.setModifiedBy(comment.getModifiedBy());
    	commentDTO.setList(comment.getList());
    	commentDTO.setModifiedDate(comment.getModifiedDate());
    	return commentDTO;
    }

}
