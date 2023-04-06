
package com.mertkagan.hobbyto.business.concretes;

import com.mertkagan.hobbyto.business.abstracts.CityService;
import com.mertkagan.hobbyto.business.abstracts.PostService;
import com.mertkagan.hobbyto.business.abstracts.UserService;
import com.mertkagan.hobbyto.business.requests.CreatePostRequest;
import com.mertkagan.hobbyto.business.responses.PostsResponse;
import com.mertkagan.hobbyto.core.utilities.mappers.ModelMapperService;
import com.mertkagan.hobbyto.dataAccess.abstracts.PostRepository;
import com.mertkagan.hobbyto.entities.concretes.City;
import com.mertkagan.hobbyto.entities.concretes.Post;
import com.mertkagan.hobbyto.entities.concretes.User;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostManager implements PostService {

    private PostRepository postRepository;
    private ModelMapperService modelMapperService;

    private UserService userService;
    private CityService cityService;



    @Override
    public List<PostsResponse> getAllPosts(Optional<Long> userId) {
        List<Post> posts;
        if(userId.isPresent()){
            posts = postRepository.findByUserId(userId.get());
            List<PostsResponse> response = posts.stream()
                    .map(post -> this.modelMapperService.forResponse().map(post, PostsResponse.class))
                    .collect(Collectors.toList());
            return response;
        }

        posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "creationDate"));
        List<PostsResponse> response = posts.stream()
                .map(post -> this.modelMapperService.forResponse().map(post, PostsResponse.class))
                .collect(Collectors.toList());

        return response;

    }

    @Override
    public Post createOnePost(CreatePostRequest createPostRequest) {
        User user = userService.getUserById(createPostRequest.getUserId());
        City city = cityService.getCityById(createPostRequest.getCityId());
        if(user==null && city==null){
            return null;
        }else {
            Post toSave = new Post();
            toSave.setTitle(createPostRequest.getTitle());
            toSave.setText(createPostRequest.getText());
            toSave.setEventDate(createPostRequest.getEventDate());
            toSave.setCreationDate(createPostRequest.getCreationDate());
            toSave.setImg(createPostRequest.getImg());
            toSave.setCity(city);
            toSave.setUser(user);
            return postRepository.save(toSave);
        }


    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }


}
