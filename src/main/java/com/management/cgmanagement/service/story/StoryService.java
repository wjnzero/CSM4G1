package com.management.cgmanagement.service.story;

import com.management.cgmanagement.model.entity.Story;
import com.management.cgmanagement.repository.IStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoryService implements IStoryService{
    @Autowired
    private IStoryRepository storyRepository;

    @Override
    public Iterable<Story> findAll(){
        return storyRepository.findAll();
    }
    @Override
    public Optional<Story> findById(Long id){
        return  storyRepository.findById(id);
    }
    @Override
    public Story save(Story story){
        return storyRepository.save(story);
    }
    @Override
    public  void  remove(Long id){
        storyRepository.deleteById(id);
    }

}
