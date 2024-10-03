import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<PessoaDTO> createPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setIdade(pessoaDTO.getIdade());

        Pessoa savedPessoa = pessoaRepository.save(pessoa);
        PessoaDTO savedPessoaDTO = new PessoaDTO(savedPessoa.getNome(), savedPessoa.getCpf(), savedPessoa.getIdade());

        return ResponseEntity.ok(savedPessoaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> getPessoaById(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));

        PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getNome(), pessoa.getCpf(), pessoa.getIdade());
        return ResponseEntity.ok(pessoaDTO);
    }
}
