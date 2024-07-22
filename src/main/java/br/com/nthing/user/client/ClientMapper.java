package br.com.nthing.user.client;

import org.mapstruct.Mapper;


@Mapper(componentModel = "cdi")
public interface ClientMapper {

    Client toEntity(ClientDTO clientDTO);

    ClientDTO toDto(Client client);
}
