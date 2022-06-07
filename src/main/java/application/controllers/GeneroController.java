//Utilizando a Classe GeneroController.java do projeto bibliotecaagricola

//acessando o pacote application.controlers//
package application.controllers;
 
//importando o java.util.Optional , é uma classe que foi implementada no Java 8, que tem o objetivo de simplificar os códigos, facilitando a vida dos desenvolvedores//
import java.util.Optional;
 
//importando do framework o Autowired beans, ele fornece controle sobre onde e como a ligação entre os beans deve ser realizada. Pode ser usado para em métodos setter, no construtor, em uma propriedade ou métodos com nomes arbitrários e / ou vários argumentos.//
import org.springframework.beans.factory.annotation.Autowired;
//importando do framework o Controller stereotype, um Controller é uma classe responsável pela preparação de um modelo de Map com dados a serem exibidos pela view e pela escolha da view correta. Basicamente ele é o responsável por controlar as requisições indicando quem deve receber as requisições para quem deve responde-las//
import org.springframework.stereotype.Controller;
//importando do framework o ui Model, Modelo de interface pública, Interface que define um titular para atributos de modelo, Projetado principalmente para adicionar atributos ao modelo, Permite acessar o modelo geral como um arquivo java.util.M//
import org.springframework.ui.Model;
//importando do SpringFrameword o Path Variable, é utilizado quando o valor da variável é passada diretamente na URL, mas não como um parametro que você passa após o sinal de interrogação //
import org.springframework.web.bind.annotation.PathVariable;
//importando do Spring framework o requestMapping, é a anotação utilizada tradicionalmente para implementar URL handler, ela suporta os métodos Post/
import org.springframework.web.bind.annotation.RequestMapping;
//importando o requestmethod, que é utilizado para fazer os requests com o springframework//
import org.springframework.web.bind.annotation.RequestMethod;
//importando o Requestparam, que são os parametros do spring framework//
import org.springframework.web.bind.annotation.RequestParam;
 
import application.models.Genero;
//importando do projeto o modelo genero, criado la no pacote models//
import application.repositories.GeneroRepository;
//importando o GeneroRepository que criamos la no pacote Repositores do projeto//



//chamando a notação controller, que é uma classe responsável pela preparação de um modelo de Map com dados a serem exibidos pela view e pela escolha da view correta. Basicamente ele é o responsável por controlar as requisições indicando quem deve receber as requisições para quem deve responde-las//
@Controller
//chamando a notação Requetmapping para acessar a url do projeto /genero//
@RequestMapping("/genero")
//criando um metodo publico para o genero controller//
public class GeneroController {
    //chamando a notação autowired, que é responsavel por controlar as requisoçoes//
    @Autowired
    // criando uma variavel denerorepo privada//
    private GeneroRepository generoRepo;
 //chamando a notação Requetmapping para acessar a url do projeto "/list"//
    @RequestMapping("/list")

    //Craindo uma metodo list do tipo String acessando a camada model e atribuindo os nomes para a variavel generoRepo//
    public String list(Model model) {
        model.addAttribute("generos", generoRepo.findAll());
        //retornando as modiicações para o "list.jsp"//
        return "list.jsp"; 
    }
 //chamando a notação Requetmapping para acessar a url do projeto "/insert"//
    @RequestMapping("/insert")
    //criando um metodo String publico e retornando para o "insert.jsp"
    public String formInsert() {
        return "insert.jsp";
    }
  //chamando a notação Requetmapping para acessar a url do projeto "/insert" e aplicando o metodo post//
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    //craindo um metodo public String para salvar os inserts //
    public String saveInsert(@RequestParam("nome") String nome) {
        //criando um objeto genero//
        Genero genero = new Genero();
        //salvando a variavel nome dentro do objeto criado//
        genero.setNome(nome);

        //salvando o objeto genero dentro da varaivel generoRepo//
        generoRepo.save(genero);
 
        //redirecionando a url para /genero/list"
        return "redirect:/genero/list";
    }
 //chamando a notação Requetmapping para acessar a url do projeto "/update/{id}"//
    @RequestMapping("/update/{id}")
    //craindo um metodo public String para salvar os updates //
    public String formUpdate(Model model, @PathVariable int id) {
        Optional<Genero> genero = generoRepo.findById(id);

        //criando uma condição para verificar o genero//
        if(!genero.isPresent())
            return "redirect:/genero/list";
        model.addAttribute("genero", genero.get());
        //retornando para a url genero/update.jsp//
        return "/genero/update.jsp";
    }
    //chamando a notação Requetmapping para acessar a url do projeto "/update e gerar uma postagem "//
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    //craindo um metodo public String para salvar os updates //
    public String saveInsert(@RequestParam("nome") String nome) {
    public String saveUpdate(@RequestParam("nome") String nome, @RequestParam("id") int id) {
        Optional<Genero> genero = generoRepo.findById(id);
        //craindo uma condição para redirecionar a url para /genero/list//
        if(!genero.isPresent())
            return "redirect:/genero/list";

            //modificando o nome da variavel nome //
        genero.get().setNome(nome);

        //salvando o genero.ger na varivael generoREPO//
        generoRepo.save(genero.get());
        //redirecionando a url para /genero/list//
        return "redirect:/genero/list";
    }
 
    //chamando a notação Requetmapping para acessar a url do projeto "/delete/{id}"//
    @RequestMapping("/delete/{id}")
    //craindo um metodo public String para gerar os deletes//
    public String formDelete(Model model, @PathVariable int id) {
        Optional<Genero> genero = generoRepo.findById(id);
        //criando uma condição para a variavel genero//
        if(!genero.isPresent())
        //retornando o redirecionamento para /genero/list//
            return "redirect:/genero/list";
            //atribuindo um nome e um get para o model//
        model.addAttribute("genero", genero.get());
        //retornando para o caminho da url "/genero/delete.jsp"//
        return "/genero/delete.jsp";
    }
 //chamando a notação Requetmapping para utilizar um metodo post no caminho "/delete"//
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    //craindo um metodo public String para confirmar os deletes//
    public String confirmDelete(@RequestParam("id") int id) {
        generoRepo.deleteById(id);
        //retornando um redirect para o caminho da url "genero/list"//
        return "redirect:/genero/list";
    }
}