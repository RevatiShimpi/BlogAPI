package com.BlogAPI.API.controller;

import com.BlogAPI.API.entities.entities;
import com.BlogAPI.API.service.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService ps;
    //create blog
    @PostMapping("/create")
    public ResponseEntity<entities> createBlog(@RequestBody entities en){
        entities en1=ps.savePost(en);
        return ResponseEntity.ok(en);
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<entities> getid(@PathVariable int id) {
        Optional<entities> en1 = ps.getbyid(id);
        if (en1.isPresent()) {
            return ResponseEntity.ok(en1.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //getAll
    @GetMapping
    public ResponseEntity<List<entities>> getAll(){
        List<entities> allUser=ps.getAll();
        return ResponseEntity.ok(allUser);
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<entities> update(@PathVariable int id, @RequestBody entities en) {
        Optional<entities> en1 = ps.getbyid(id);
        if (en1.isPresent()) {
            entities en2 = en1.get();
            if (en.getID() != 0) {
                en2.setID(en.getID());
            } else {
                en2.setID(en2.getID());
            }
            //title

            if (en.getID() != 0) {
                en2.setID(en.getID());
            } else {
                en2.setID(en2.getID());
            }
            //author

            if (en.getAuthor() != null) {
                en2.setAuthor(en.getAuthor());
            } else {
                en2.setAuthor(en2.getAuthor());
            }
            //contents

            if (en.getTitle() != null) {
                en2.setTitle(en.getTitle());
            } else {
                en2.setTitle(en2.getTitle());
            }
            //tags

            if (en.getTags() != null) {
                en2.setTags(en.getTags());
            } else {
                en2.setTags(en2.getTags());
            }
            ps.savePost(en2);
            return ResponseEntity.ok(en2);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<entities> delete(@PathVariable int id){
        Optional<entities> en=ps.getbyid(id);
        entities en2=en.get();
        ps.deletebyid(id);
        return ResponseEntity.ok(en2);

    }




}
