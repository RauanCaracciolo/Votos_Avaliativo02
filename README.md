# Exercicio Avaliativo 2 - DMO1 🌐

## Descrição do Projeto

### Autor:

O Aplicativo Android de Pesquisa de Opinião foi desenvolvido por **Gabriel de Pauli Santos** e **Rauan Caracciolo**, alunos do curso de Análise e Desenvolvimento de Sistemas no IFSP - Campus Araraquara.


### Tecnologias utilizadas 👩‍💻

- **Kotlin:** Principal linguagem de programação utilizada, necessária para a criação de toda a lógica do programa.
- **SQLite:** Utilizado para armazenar os dados no Banco de Dados.
- **Padrões de Projeto:** MVVM (Model-View-ViewModel).
- **Aplicativos:** Android Studio.

## Sobre o projeto ℹ

Este projeto é uma aplicação Android (desenvolvida no Android Studio) com linguagem Kotlin que tem o objetivo simular uma Pesquisa de Opinião, onde o usuário efetua seu Login, caso não tiver cadastro o aplicativo o cadastra automaticamente quando feito o Login, permite ao usuário visualizar a pesquisa e fazer seu voto, além de poder visualizar qual foi a opção votada por ele por meio de um código gerado no voto e também é possível ver a quantidade de pessoas que votaram em cada opção.

Para que o sistema funcione corretamente foram adicionadas algumas funções:

- **Página inicial (MainActivity):** Esta página possui uma mensagem de "Bem-Vindo" com 3 opções de botões, "Participar da Pesquisa" que encaminhará para página de login para o usuário efetuar o login, "Checar meu voto" onde sera possível checar o voto realizado por meio do código gerado após a votação, além da opção de "Finalizar" que encaminha para página de exibir a quantidade de votos para cada opção de voto.

- **Login (LoginActivity):** Esta página possui a opção de logar com os campos para inserir o prontuário e o nome, caso não esteja registrado o usuário ainda ele automaticamente faz o registro no sistema, mas caso já esteja registrado ele faz a confrerência se o usuário já efetuou o voto para depois encaminhar. Caso já tenha votado ele gera uma mensagem avisando que o usuário já votou e se ainda não tiver votado ele encaminha para página de votação.

- **Página de Voto (VoteActivity):** Esta página possui uma pergunta de pesquisa de opinião e as opções de voto abaixo ("Ruim", "Regular", "Bom" e "Ótimo"), após clicar no botão de votar ele computa o voto e gera um código (String) do voto, este código já é copiado automaticamente para área de transferência, para uma consulta posterior.

- **Checar Voto (CheckActivity):** Esta opção encaminha para a página de checagem do voto, onde será necessário inserir o código gerado na votação e assim ele mostrará qual foi a opção de voto escolhida.

- **Finalizar (ResultActivity)** Esta opção encaminha para a página onde serão exibidos o resultado da pesquisa de opinião com a quantidade de votos em cada opção, além da quantidade de participantes totais da pesquisa.
