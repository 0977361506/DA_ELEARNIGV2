package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.InterActiveLectureChapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterInteractiveLectureRepository extends JpaRepository<InterActiveLectureChapter,Long> {
}
