package com.BlogAPI.API.service;

import com.BlogAPI.API.entities.entities;
import com.BlogAPI.API.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private BlogRepo blogrepo;

    //save post
    public entities savePost(entities post){
        return blogrepo.save(post);
    }
    //getby id
    public Optional<entities> getbyid(int id){ //what is this optional
        return blogrepo.findById(id);
    }

    //get All
    public List<entities> getAll(){
        return blogrepo.findAll();
    }

    //delete
    public void deletebyid(int id){
        blogrepo.deleteById(id);
    }

}
