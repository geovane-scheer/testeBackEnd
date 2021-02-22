# testeBackEnd
Avaliação técnica para desenvolvedor backend

#### Começando a integração

Assim que o projeto estiver rodando, para que seja feita a carga inicial de dados, é necessário chamar o endpoint */testeBackEnd/linhaOnibus/integrar*, que é responsável pela integração das linhas de ônibus. Para completar a carga inicial é preciso chamar o endpoint */testeBackEnd/itinerarios/integrar*, que é responsável pela integração dos itinerários das linhas. Após esses dois passos os dados já estão disponíveis para consulta ou alteração.


##### Operações Disponíveis

**LINHAS DE ÔNIBUS**\
-Cadastrar/Atualizar:\
Descrição: Método para cadastrar ou atualizar uma linha de ônibus. A verificação para atualização é feito pelo atributo *id*.\
Método: POST\
URL: /testeBackEnd/linhaOnibus/\
Formato requisição: JSON\
Exemplo do body:\
    {
        "id": "602d3f52fd7bf17bff7a1566",
        "codigo": "666-2",
        "nome": "Teste Geovane UPDATE3"
    }
\
\
-Consultar pelo ID:\
Método: GET\
URL: /testeBackEnd/linhaOnibus/{id} - informar o ID da linha que deseja-se consultar\
exemplo: /testeBackEnd/linhaOnibus/5518\
\
-Consultar pelo NOME:\
Método: GET\
URL: /testeBackEnd/linhaOnibus/buscarPorNome?nome={nome} - infomar o NOME da linha que deseja-se consultar\
exemplo: /testeBackEnd/linhaOnibus/buscarPorNome?nome=teste geovane update2\
\
Consultas TODAS:\
Método: GET\
URL: /testeBackEnd/linhaOnibus/all
exemplo: /testeBackEnd/linhaOnibus/all\
\
-Deletar linha :\
Método: DELETE\
URL: /testeBackEnd/linhaOnibus/delete/{id} - informar o ID da linha que deseja-se excluir
exemplo: /testeBackEnd/linhaOnibus/delete/5518\
\
-Buscar linhas dentro de um raio:\
Descrição: filtro de linhas por meio de um raio. Exemplo: passando uma atitude, longitude e um raio em KM, traz as as linhas dentro do raio informado.\
Método: POST\
URL: /testeBackEnd/linhaOnibus/dentroDoRaio\
Formato requisição: JSON\
Exemplo do body:\
   {
    "latitude": -29.0485523,
    "longitude": -51.1849287,
    "raio": 1
}
\
\
**ITINERÁRIOS**\
