# testeBackEnd
Avaliação técnica para desenvolvedor backend

#### Justificativas
Spring = facilita todo o processo de desenvolvimento na parte do java.\
MongoDB: pois oferece um desempenho muito bom, e não há necessidade de fazer "JOIN" entre as tabelas, portanto não há necessidade bd relacional.

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
Consultar TODAS:\
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
-Cadastrar/Atualizar:\
Descrição: Método para cadastrar ou atualizar um itinerário. A verificação para atualização é feito pelo atributo *id*.\
Método: POST\
URL: /testeBackEnd/itinerarios/\
Formato requisição: JSON\
Exemplo do body:\
   
    {
        
        "idlinha": "66666666",
        "nome": "geovane linha",
        "codigo": "666-52",
        "mapItinerario": {
            "0": {
                "lat": "-30.03155263324200000",
                "lng": "-51.22779631648400000"
            },
            "1": {
                "lat": "-32.13155263324200000",
                "lng": "-61.92779631648400000"
            }
        }
    }

\
\
-Consultar pelo ID:\
Método: GET\
URL: /testeBackEnd/itinerarios/{id} - informar o ID da itinerário que deseja-se consultar\
exemplo: /testeBackEnd/itinerarios/60314da06d318e252e5fb1f1\
\
-Consultar pelo ID DA LINHA que o itinerário pertence:\
Método: GET\
URL: /testeBackEnd/itinerarios/byLinha/{idLinha} - infomar id da linha que deseja-se consultar o itinerário\
exemplo: /testeBackEnd/itinerarios/byLinha/5518
\
Consultar TODOS:\
Método: GET\
URL: /testeBackEnd/itinerarios/all\
exemplo: /testeBackEnd/itinerarios/all\
\
-Deletar itinerario :\
Método: DELETE\
URL: /testeBackEnd/itinerarios/delete/{id} - informar o ID do itinerário que deseja-se excluir
exemplo: /testeBackEnd/itinerarios/delete/60314da06d318e252e5fb1f1\
\
**PONTOS DE TÁXI**\
Consultar TODOS:\
Método: GET\
URL: /testeBackEnd/pontosDeTaxi/all\
exemplo: /testeBackEnd/pontosDeTaxi/all\
\
-Cadastrar:\
Descrição: Método para cadastrar um ponto de táxi\
Método: POST\
URL: /testeBackEnd/pontosDeTaxi/\
Formato requisição: JSON\
Exemplo do body:\
  {
        "nomeDoPonto": "PONTO DO GEOVANE",
        "latitude": "-41.12373379817800000",
        "longitutde": "-62.22266028234100000",
        "dataHoraCadastro": "2020-02-10T16:14:34.828"
    }






