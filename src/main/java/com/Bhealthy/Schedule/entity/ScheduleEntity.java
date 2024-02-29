package com.Bhealthy.schedule.entity;


import java.time.ZonedDateTime;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "schedule")
@Entity

public class ScheduleEntity {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
		
			private String title;
			
			@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
			private Date start;
			
			@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
			private Date end;
			
			@UpdateTimestamp
			@Column(name = "createdAt", updatable = false)
			private ZonedDateTime createdAt;
			
			@UpdateTimestamp
			@Column(name = "updatedAt")
			private ZonedDateTime updatedAt;
}
