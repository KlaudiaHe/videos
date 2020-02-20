package com.turowska.videoRentalApp.Dao;


import com.turowska.videoRentalApp.Dao.Entity.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepo extends CrudRepository<Video, Long> {
}
