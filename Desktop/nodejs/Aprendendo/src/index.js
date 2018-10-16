//Importações de pacotes
const banco = require("./banco.json");
const express = require('express');
const bodyParser = require('body-parser'); // para o node entender as requisições, recebendo informações
                                          // em json e entender parâmetros por url. 

const app = express(); //criando core da aplicação.

app.use(bodyParser.json()); //para o node entender as requisições em json.
app.use(bodyParser.urlencoded({ extended: false}));// para o node entender parâmetros via url e decodar-los.                                                   
                                                    
/*
* Cada um desses métodos abaixo, é uma endpoint, que também podem ser chamadas de rotas.
*/

app.get('/food', (req,res) => {
    //Retorna ao usuário todas comidas cadastradas no banco.
    var comidas = Object.keys(banco);
    var tamanho = comidas.length;
    if(tamanho>0){
        res.send(comidas);
    }else{
        console.log("Não existe comidas cadastradas!");
    }
    res.end();
});

app.get('/food/:comida', (req,res) => {
    //Retorna ao usuário as calorias de uma determinada comida passada na url 
    try{        
        var calorias = banco[req.params.comida];
        res.send(calorias.toString());
    }catch(err){
        res.status(500);
        console.log("Não existe essa comida");
    }
    res.end();
});

app.post('/food', (req,res) => {
    /*Recebe uma chave e um valor no json pelo body,
    * verifica se a chave já existe no banco. Caso não exista, a chave é criada no banco, e é associado
    * a respectiva chave ao mesmo.
    */
    var body = Object.keys(req.body);
    body.forEach( (val)=>{
        if(!banco.hasOwnProperty(val)){
            banco[val] = req.body[val];
        }else{
            console.log("Essa chave ja está cadastrada!");
        }
    });
    res.end();       
});

app.patch('/food', (req,res) => {
    /*Recebe uma chave e um valor no json pelo body,
    * verifica se a chave já existe no banco. Caso já exista, o valor daquela chave é substituida pelo
    * valor da respectiva chave que está no json.
    */
    var body = Object.keys(req.body);
    body.forEach( (val)=>{
        if(banco.hasOwnProperty(val)){
            banco[val] = req.body[val];
        }else{
            console.log("Essa comida não está cadastrada!");
        }

    });
    res.end();        
});

app.delete('/food/:comida', (req,res)=>{
    //Recebe o nome de uma comida pela url, e deleta do banco aquela determinada comida, caso a mesma exista!
    try{        
        delete banco[req.params.comida];        
    }catch(err){
        console.log("Essa comida não está cadastrada!");
    }
    res.end();
});

/*
  Nos parametros da funçao anonima:
  O "req" é os dados da requisição como por exemplo
  parametros a receber ou tokens de autenticação.

  Ja o res é o objeto para enviar alguma resposta para o usuario
  quando ele acessar essa rota.
*/                       

app.listen(3000); //Para a api ficar sendo ouvida na porta 3000.

