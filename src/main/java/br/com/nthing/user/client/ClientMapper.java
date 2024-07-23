package br.com.nthing.user.client;

import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "cdi")
public interface ClientMapper {

    Client toEntity(ClientDTO clientDTO);

    ClientDTO toDto(Client client);

    List<Client> toEntityList(List<ClientDTO> clientDTOList);

    List<ClientDTO> toDtoList(List<Client> clientList);

}
