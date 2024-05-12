package com.jpalearning.entity;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "posted_on")
	private LocalDate postedOn;

	@Column(name = "text_content")
	@Basic(fetch = FetchType.LAZY)
	private String content;

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
		this.postedOn = LocalDate.now();
	}
}
