package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.VideoLecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoLectureRepository extends JpaRepository<VideoLecture,Long> {
}
