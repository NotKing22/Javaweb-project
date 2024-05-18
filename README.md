<span align="center">

##  Hellooo Helloo World! 👋 

</span>

<div align="center">
<img src="https://desblogada.files.wordpress.com/2021/05/kaka-cordovil-java-developer-2.gif" width="300px" />
</div>

<h1>Introdução:</h1>

O projeto consiste em um sistema web para uma academia, permitindo que usuários se cadastrem, façam login, escolham entre diferentes planos de assinatura e visualizem seus planos. 

<h3>Objetivos da Aplicação: 🎯</h3>
Facilitar o gerenciamento de usuários e planos de uma academia.
Permitir que usuários façam login, escolham planos e visualizem suas informações.
Oferecer aos administradores ferramentas para gerenciar clientes e administradores.

<h1>Funções/Lista de Eventos:</h1>
<h3>Requisitos Funcionais (RF):</h3>

<ul>
  <li>Cadastro de usuários.</li>
  <li>Login de usuários.</li>
  <li>Escolha de planos (mensal, trimensal, semestral, anual) por usuários.</li>
  <li>Visualização dos planos pelo usuário logado.</li>
  <li>Painel de controle para administradores.</li>
  <li>Gerenciamento de clientes por administradores (editar, excluir).</li>
  <li>Gerenciamento de administradores por outros administradores (adicionar, editar, excluir).</li>
</ul>

<h2>Requisitos Não Funcionais (RNF):</h2>

<ul>
  <li>Performance otimizada para carregamento rápido das páginas. </li>
  <li>Usabilidade aprimorada e intuitiva, com um design de interface de usuário amigável e uma navegação clara.</li>
</ul>

<h1>Especificação de Programas:</h1>

<h2>Regras de Negócio: 📝</h2>
<ul>
  <li>Todos os usuários cadastrando precisam inserir algumas informações pessoais e precisam obrigatoriamente ter um plano comprado na academia.</li>
  <li>A adição de novos administradores exigem informações pessoais, uma definição de salário e uma função.</li>
  <li>Qualquer usuário/administrador cadastrado no banco pode ter seus dados alterados ou excluídos por um admin.</li>
</ul>

<h1>DER ou Diagrama de Classe:</h1>
<h2>Entidades Envolvidas (Classes) / Tabelas: 📊</h2>

<ul>
    <li>
        <strong>1. Relação Um para Um (1:1):</strong>
        <br>
        AdminModel &harr; Admin_db: Cada Administrador tem uma conta no banco de dados, e cada conta está associada a apenas um administrador.
        <br>
    </li>
    <li>
        <strong>2. Relação Um para Muitos (1:N):</strong>
        <br>
        UserModel &rarr; Login_db: Cada usuário tem uma conta no banco de dados, e cada conta está associada a apenas um usuário.
        <br>
        UserModel &rarr; UserPlans: Cada usuário pode ter um plano na academia, mas cada plano de academia está associado a vários usuários.
    </li>
    <li>
        <strong>3. Relação Muitos para Muitos (N:M):</strong>
        <br>
        Não há uma relação muitos para muitos.
    </li>
</ul>

<h2>Artefato Gráfico: 🖼️</h2>
<div align="center">
<img src="https://i.imgur.com/RlXSbMb.jpg" width="800px" />
</div>

<h2>Dicionário de Dados (DD): 📚</h2>

<ul>
  <li>UserModel
    <ul> 
      <li>ID</li>
      <li>MATRICULA</li>
      <li>DATA_NASCIMENTO</li>
      <li>ENDEREÇO</li>
      <li>NOME_COMPLETO</li>
      <li>PLANO_ACADEMIA</li>
      <li>RG</li>
      <li>SEXO</li>
      <li>STATUS_ACADEMIA</li>
    </ul>
  </li>
</ul>
<ul>
  <li>AdminModel
    <ul> 
      <li>ID</li>
      <li>NOME</li>
      <li>RG</li>
      <li>ENDEREÇO</li>
      <li>SALARIO</li>
    </ul>
  </li>
</ul>
<ul>
  <li>UserPlans
    <ul> 
      <li>ID</li>
      <li>MATRICULA</li>
      <li>NOME</li>
      <li>RG</li>
      <li>EMAIL</li>
      <li>PLANO_ACADEMIA</li>
    </ul>
  </li>
</ul>
<ul>
  <li>Admin_db
    <ul> 
      <li>ID</li>
      <li>EMAIL</li>
      <li>SENHA</li>
    </ul>
  </li>
</ul>
<ul>
  <li>Login_db
    <ul> 
      <li>MATRICULA</li>
      <li>EMAIL</li>
      <li>SENHA</li>
    </ul>
  </li>
</ul>

<h1>Aplicação Protótipo:</h1>
<h2>Menu/Submenu: 📂</h2>
<div align="center">
<img src="https://imgur.com/D6CSn35.jpeg" width="800px" />
</div>
<div align="center">
<img src="https://imgur.com/X19g03y.jpeg" width="800px" />
</div>
<div align="center">
<img src="https://imgur.com/ZZQFIFQ.jpeg" width="800px" />
</div>
<div align="center">
<img src="https://imgur.com/6fgCSEo.jpeg" width="800px" />
</div>

<h2>Telas Funcionais: 🖥️</h2>
<h3>Logins, planos e dashboard administrativa</h3>
<div align="center">
<img src="https://imgur.com/UIwDpyQ.jpeg" width="800px" />
</div>
<br>
<div align="center">
<img src="https://imgur.com/Xd0zO19.jpeg" width="800px" />
</div>
<br>
<div align="center">
<img src="https://imgur.com/4NCPOBq.jpeg" width="800px" />
</div>
<br>
<div align="center">
<img src="https://imgur.com/dOtgzES.jpeg" width="800px" />
</div>
<br>
<div align="center">
<img src="https://imgur.com/c2wtmk6.jpeg" width="800px" />
</div>
<br>
<div align="center">
<img src="https://imgur.com/9cjIkQD.jpeg" width="800px" />
</div>
<br>
<div align="center">
<img src="https://imgur.com/knzBuIS.jpeg" width="800px" />
</div>
<br>
<div align="center">
<img src="https://imgur.com/EiavW9q.jpeg" width="800px" />
</div>

<h2>Telas de Diálogo: 💬</h2>
<h3>Mensagens de erro:</h3>
<div align="center">
<img src="https://imgur.com/gIejIpj.jpeg" width="800px" />
</div>
<br>
<div align="center">
<img src="https://imgur.com/rJ9AwpA.jpeg" width="800px" />
</div>

<h1 align="center">Finalização</h1>
<p>Este projeto foi concebido e desenvolvido exclusivamente por Matheus de Jesus Menezes Tavares (Matrícula: 202203298101) como parte da disciplina de Programação Orientada a Objetos em Java, para a Avaliação NF PBL: POO Java - Aplicação Web ou Mobile. Realizado com dedicação e comprometimento, aproveitando todo o conhecimento prévio sobre Java, este projeto representou também o desafio de criar minha primeira aplicação web utilizando Spring.</p>

## ⭐ GitHub Stats

<p align = "center">
  <img src = "https://github-readme-stats.vercel.app/api?username=NotKing22&show_icons=true&theme=tokyonight&line_height=27">
  <img src = "https://github-readme-stats.vercel.app/api/top-langs/?username=NotKing22&hide=css,html&theme=tokyonight">
</p>

<p align="center">
  💌 Text me: ⤵️
  <p align="center"> matheusdejesusgc@hotmail.com </p>
</p>

<div align="center">
<h2>Let's code!!!</h2>
<img src="https://media.giphy.com/media/LmNwrBhejkK9EFP504/giphy.gif" width="400px" />
</div>
