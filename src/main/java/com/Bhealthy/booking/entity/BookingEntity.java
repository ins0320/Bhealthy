package com.Bhealthy.booking.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "booking")
@Entity

public class BookingEntity {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
		
			private String title;
			
			@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
			private LocalDateTime start;
			
			@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
			private LocalDateTime end;
			
			@UpdateTimestamp
			@Column(name = "createdAt", updatable = false)
			private ZonedDateTime createdAt;
			
			@UpdateTimestamp
			@Column(name = "updatedAt")
			private ZonedDateTime updatedAt;
}
