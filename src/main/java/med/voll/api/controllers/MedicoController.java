package med.voll.api.controllers;

import com.electronwill.nightconfig.core.conversion.Path;
import med.voll.api.entities.EnderecoEntity;
import med.voll.api.entities.MedicoEntity;
import med.voll.api.models.Medico;
import med.voll.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping
    public List<MedicoEntity> buscar() {
        return medicoRepository.findAll();
    }
    @GetMapping( {"/{id}","/{id}/"} )
    public MedicoEntity buscarUm(@PathVariable long id) {
        try {
            return medicoRepository.findById(id).get();
        }catch (Exception e) {
            return new MedicoEntity();
        }
    }

    @PostMapping
    public MedicoEntity cadastrar(@RequestBody Medico dadosMedico) {
        return medicoRepository.save(new MedicoEntity(dadosMedico));
    }
    @DeleteMapping({"/{id}","/{id}/"})
    public void deletar(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }

    @PutMapping({"/{id}","/{id}/"})
    public Medico editar(@PathVariable Long id, @RequestBody Medico dados) {
        medicoRepository.findById(id).map(medicoEntity -> {
            medicoEntity.setNome(dados.nome());
            medicoEntity.setEmail(dados.email());
            medicoEntity.setCrm(dados.crm());
            medicoEntity.setEspecialidade(dados.especialidade());
            medicoEntity.setEndereco(new EnderecoEntity(dados.endereco()));

            return medicoRepository.save(medicoEntity);
        });
        return dados;
    }

}
