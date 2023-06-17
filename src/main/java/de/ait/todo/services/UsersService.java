package de.ait.todo.services;


import de.ait.todo.dto.ProfileDto;

public interface UsersService {

    ProfileDto getProfile(Long currentUserId);

}
