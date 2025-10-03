package com.livoard.livoardapi.mapper;

import com.livoard.livoardapi.dto.PostCreateRequest;
import com.livoard.livoardapi.dto.PostResponse;
import com.livoard.livoardapi.dto.PostUpdateRequest;
import com.livoard.livoardapi.entity.Post;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target= "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Post toEntity(PostCreateRequest dto);

    void overwrite(@MappingTarget Post entity, PostUpdateRequest dto);

    PostResponse toResponse(Post entity);

    List<PostResponse> toResponseList(List<Post> entities);
}
