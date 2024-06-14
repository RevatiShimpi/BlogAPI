package com.BlogAPI.API.service;

import com.BlogAPI.API.entities.entities;

import java.util.List;
import java.util.Optional;

public interface PostService {
    entities savePost(entities post);
    public Optional<entities> getbyid(int id);
    public List<entities> getAll();
    public void deletebyid(int id);
}
