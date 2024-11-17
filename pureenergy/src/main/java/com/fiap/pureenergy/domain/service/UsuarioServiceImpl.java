package com.fiap.pureenergy.domain.service;

import com.fiap.pureenergy.adapter.repository.entity.UsuarioEntity;
import com.fiap.pureenergy.adapter.repository.mapper.UsuarioMapper;
import com.fiap.pureenergy.domain.exception.UsuarioNotFoudException;
import com.fiap.pureenergy.domain.model.UsuarioModel;
import com.fiap.pureenergy.domain.ports.out.UsuarioPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UsuarioPortOut usuarioPortOut;

    @Override
    public UsuarioModel cadastrarUsuario(UsuarioModel usuario) {

        var entity = usuarioMapper.toEntity(usuario);
        UsuarioEntity usuarioCadastrado = usuarioPortOut.save(entity);
       return usuarioMapper.toModel(usuarioCadastrado);
    }

    @Override
    public List<UsuarioModel> listarUsuarios() {
        return usuarioPortOut.findAll().stream()
                .map(UsuarioMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioModel> atualizarUsuario(Long id, UsuarioModel usuario) {
        return usuarioPortOut.findById(id).map(entityExistente -> {
            var entityAtualizada = usuarioMapper.toEntity(usuario);
            entityAtualizada.setIdUsuario(id);

            usuarioPortOut.save(entityAtualizada);

            return UsuarioMapper.toModel(entityAtualizada);
        });
    }



    @Override
    public boolean excluirUsuario(Long id) {
        if (usuarioPortOut.existsById(id)) {
            usuarioPortOut.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<UsuarioModel> buscarUsuario(Long id) {
        return Optional.ofNullable(
                usuarioPortOut.findById(id)
                        .map(UsuarioMapper::toModel)
                        .orElseThrow(UsuarioNotFoudException::new)
        );
    }

    @Override
    public Optional<UsuarioModel> detalharUsuario(Long id) {
        return Optional.of(
                usuarioPortOut.findById(id)
                        .map(UsuarioMapper::toModel)
                        .orElseThrow(UsuarioNotFoudException::new)
        );
    }
}
