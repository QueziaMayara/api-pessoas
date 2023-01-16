# api-pessoas
## :information_source: Como Utilizar: 

Clonar o projeto, e iniciar aplicacao, precisando [Git](https://git-scm.com). linhas de comando:

```bash
# Clone do repositório
$ git clone https://github.com/QueziaMayara/api-pessoas.git

# Entre neste repositório
$ cd api-pessoas

```


## Rotas

<blockquote>baseUrl: http://localhost:8080</blockquote>

## Address

<p>
  Listar todas pessoas (GET)
  
   <code>
    baseUrl/people
  </code>
</p>

<p>
  Mostra única Pessoa (GET)
  
   <code>
    baseUrl/people/:id
  </code>

</p>

<p>
  Criar Pessoa (POST)
  
  <code>
    baseUrl/people
  </code>
</p>

<p>
  Atualizar Pessoa (PUT)
  
  <code>
    baseUrl/people/:id
  </code>
</p>

<p>
  Deletar Pessoa (DELETE)
  
  <code>
    baseUrl/people/:id
  </code>
</p>

<p>
  Criar Endereço (POST)
  
  <code>
    baseUrl/people/:id/address
  </code>
</p>

<p>
  Atualizar Endereço como Principal (PUT)
  
  <code>
    baseUrl/people/:id/address/:idAddress
  </code>
</p>

<p>
  Buscar Endereços da Pessoa (GET)
  
  <code>
    baseUrl/people/:id/address/
  </code>
</p>
