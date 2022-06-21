### Termos e acordos

Ao iniciar este projeto, você concorda com as diretrizes do Código de Ética e Conduta e do Manual da Pessoa Estudante da Trybe.

---

# Boas vindas ao repositório do desafio da Aceleração Java!

Você já usa o GitHub diariamente para desenvolver os exercícios, certo? Agora, para desenvolver o desafio, você deverá seguir as instruções a seguir. Fique atento a cada passo, e se tiver qualquer dúvida, nos envie por _Slack_! #vqv 🚀

Aqui você vai encontrar os detalhes de como estruturar o desenvolvimento do seu desafio a partir deste repositório, utilizando uma branch específica e um _Pull Request_ para colocar seus códigos.

---
# Instruções para entregar seu projeto

## Não se esqueça de consultar as documentações!

⚠️ **Importante**:

Esse projeto tem como intuito te treinar para ter mais familiaridade com a documentação de aplicações, por tanto, poderão haver alguns comandos ou atributos que não estão no curso, mas que devem ser descritos no decorrer dos requisitos.

Nesses casos, é importante se atentar a aquilo que o requisito pede, e lembrar sempre de utilizar a [documentação oficial](https://docs.oracle.com/en/java/javase/11/) do Java para pesquisar detalhes sobre comandos.


## Antes de começar a desenvolver

Lembre-se que você pode consultar nosso conteúdo sobre [Git & GitHub](https://course.betrybe.com/intro/git/) sempre que precisar!

1. Clone o repositório
  * Por exemplo: `git clone git@github.com:tryber/desafio-aceleracao.git`
  * Entre no diretório do repositório que você acabou de clonar:
    * neste caso `cd desafio-aceleracao`

2. Instale as dependências:
    * `mvn install`

3. Crie uma branch a partir da branch `main`

  * Verifique que você está na branch `main`
    * Exemplo: `git branch`
  * Se não estiver, mude para a branch `main`
    * Exemplo: `git checkout main`
  * Agora, crie uma branch onde você vai guardar os commits do seu desafio
    * Você deve criar uma branch no seguinte formato: `nome-de-usuario-nome-do-desafio`
    * Exemplo:
      * `git checkout -b joaozinho-acc-java-sample`

4. Adicione a sua branch com o novo `commit` ao repositório remoto

  - Usando o exemplo anterior:
    - `git push -u origin joaozinho-acc-java-sample`

5. Crie um novo `Pull Request` _(PR)_
  * Vá até a aba de _Pull Requests_ deste repositório no GitHub
  * Clique no botão verde _"New pull request"_
  * Clique na caixa de seleção _"Compare"_ e escolha a sua branch **com atenção**
  * Clique no botão verde _"Create pull request"_
  * Adicione uma descrição para o _Pull Request_ e clique no botão verde _"Create pull request"_
  * **Não se preocupe em preencher mais nada por enquanto!**
  * Volte até a página de _Pull Requests_ do repositório e confira que o seu _Pull Request_ está criado
 
 ⚠️ **Lembre-se do CheckStyle! Deixe seu Eclipse configurado para arrumar o estilo automaticamente. Qualquer dúvida, volte no conteúdo.**

---

## Durante o desenvolvimento

* ⚠ **PULL REQUESTS COM ISSUES NO CHECKSTYLE NÃO SERÃO AVALIADAS, ATENTE-SE PARA RESOLVÊ-LAS ANTES DE FINALIZAR O DESENVOLVIMENTO!** ⚠

* Faça `commits` das alterações que você fizer no código regularmente

* Lembre-se de sempre após um (ou alguns) `commits` atualizar o repositório remoto

* Os comandos que você utilizará com mais frequência são:
  1. `git status` _(para verificar o que está em vermelho - fora do stage - e o que está em verde - no stage)_
  2. `git add` _(para adicionar arquivos ao stage do Git)_
  3. `git commit` _(para criar um commit com os arquivos que estão no stage do Git)_
  4. `git push -u origin nome-da-branch` _(para enviar o commit para o repositório remoto na primeira vez que fizer o `push` de uma nova branch)_
  5. `git push` _(para enviar o commit para o repositório remoto após o passo anterior)_

---

## Depois de terminar o desenvolvimento (opcional)

Para **"entregar"** seu projeto, siga os passos a seguir:

* Vá até a página **DO SEU** _Pull Request_, adicione a label de _"code-review"_ e marque seus colegas
  * No menu à direita, clique no _link_ **"Labels"** e escolha a _label_ **code-review**
  * No menu à direita, clique no _link_ **"Assignees"** e escolha **o seu usuário**
  * No menu à direita, clique no _link_ **"Reviewers"** e digite `students`, selecione o time `tryber/students-sd-0x`

Se ainda houver alguma dúvida sobre como entregar seu projeto, [aqui tem um video explicativo](https://vimeo.com/362189205).

---

# Requisitos do desafio

## Simulador de Pix

Neste desafio, vamos simular um processo de transferência bancária via Pix, realizada por meio de um aplicativo mobile. O processo é muito simples: a pessoa usuária do aplicativo preenche um valor e uma chave Pix e o aplicativo envia essas informações para o servidor do banco na nuvem. O nosso foco aqui vai ser **tratar os erros que podem acontecer** ao longo desta operação.

O seu objetivo principal é escrever dois componentes em Java:

1. **Processador de Pix:** é o componente que contém a lógica de negócio da operação. Dadas as entradas (valor e chave Pix), o processador de Pix será responsável por validá-las e enviá-las ao servidor na nuvem, interpretando a resposta recebida.

1. **Controlador de Pix:** é o componente que contém a lógica de apresentação deste fluxo. Ele é responsável por invocar o processador de Pix, passando as informações preenchidas pela pessoa usuária na tela do aplicativo. Também é responsabilidade do componente capturar qualquer erro que possa acontecer durante o processo e informar a pessoa usuária sobre o resultado da operação.

O processador de Pix interage com outros dois componentes que você não vai precisar programar:

1. **Conexão:** representa um canal de comunicação entre o aplicativo mobile e o servidor na nuvem. O processador de Pix vai usar uma conexão para enviar os dados de entrada (valor e chave Pix).

1. **Servidor:** é o componente que será utilizado pelo processador de Pix para abrir uma nova conexão com o servidor na nuvem.


## Requisitos do código

Você tem à sua disposição os seguintes componentes em Java:

- `Conexao.java`
```java
import java.io.Closeable;
import java.io.IOException;

public interface Conexao extends Closeable {

  String enviarPix(int valor, String chave) throws IOException;
}
```

- `Servidor.java`
```java
import java.io.IOException;

public interface Servidor {

  Conexao abrirConexao() throws IOException;
}
```

Você deve programar as classes `ProcessadorDePix` e `ControladorDePix` a partir dos modelos a seguir:

- `ProcessadorDePix.java`
```java
import java.io.IOException;

public class ProcessadorDePix {

  private final Servidor servidor;

  public ProcessadorDePix(Servidor servidor) {
    this.servidor = servidor;
  }

  public void executarPix(int valor, String chave) throws ErroDePix, IOException {
    // TODO: Implementar.
  }
}
```

- `ControladorDePix.java`
```java
import java.io.IOException;

public class ControladorDePix {

  private final ProcessadorDePix processadorDePix;

  public ControladorDePix(ProcessadorDePix processadorDePix) {
    this.processadorDePix = processadorDePix;
  }

  public String aoConfirmarPix(int valor, String chave) {
    return null; // TODO: Implementar.
  }
}
```

### Tratamento de erros

Durante a operação do Pix, é possível que ocorra uma série de erros:

- Erros de aplicação validados localmente
    - Valor a ser transferido menor ou igual a zero
    - Chave Pix em branco

- Erros de aplicação validados pelo servidor
    - Saldo insuficiente
    - Chave Pix não encontrada
    - Erro interno (por exemplo, falha no servidor)

- Erros de comunicação (por exemplo, timeout de conexão)

Cada um desses erros se traduz em uma exceção Java.

Os erros de comunicação equivalem a exceções derivadas de `java.io.IOException`. Elas podem vir tanto da biblioteca padrão Java, como `java.net.SocketException` e afins, quanto de bibliotecas usadas para implementar a comunicação do aplicativo com o servidor — o que está fora do escopo deste desafio.

Quanto aos erros da aplicação, não existem exceções que os representem na biblioteca padrão. Por isso vamos criar _exceções customizadas_. Você deve criar as seguintes classes:

- `ErroValorNaoPositivo`
- `ErroChaveEmBranco`
- `ErroSaldoInsuficiente`
- `ErroChaveNaoEncontrada`
- `ErroInterno`

Como parte do projeto, você deve utilizar _exatamente_ os nomes acima, para garantir uma entrega alinhada aos requisitos. Além disso, cada uma das classes acima deve estender a classe `ErroDePix`, cujo código segue abaixo:

- `ErroDePix.java`
```java
public abstract class ErroDePix extends Exception {

  public ErroDePix(String mensagem) {
    super(mensagem);
  }
}
```

### `ProcessadorDePix.executarPix`

Na implementação do método `ProcessadorDePix.executarPix`, você deve seguir os seguintes passos:

- Garantir que `valor` (em centavos) seja um inteiro positivo.
    - Caso contrário, lançar exceção `ErroValorNaoPositivo`.
- Garantir que a String `chave` não esteja em branco.
    - Uma String será considerada em branco se estiver vazia ou for composta apenas por espaços em branco.
    - Se a chave estiver em branco, lançar exceção `ErroChaveEmBranco`.
- Abrir uma conexão com o servidor.
- Utilizar a conexão para enviar os dados.
- Interpretar a resposta do servidor.
- Fechar conexão com o servidor.

Ao abrir a conexão e enviar os dados, é possível que seja lançada alguma exceção derivada de `java.io.IOException`. Você não deve capturar essas exceções aqui, deixe que elas se propaguem.

Após o envio dos dados, o servidor enviará de volta um código que indica o resultado da operação, no caso a String retornada pelo método `Conexao.enviarPix`. Você deve proceder de acordo com o valor do código:

- `sucesso`: nenhuma ação necessária.
- `saldo_insuficiente`: lançar exceção `ErroSaldoInsuficiente`.
- `chave_pix_nao_encontrada`: lançar exceção `ErroChaveNaoEncontrada`.
- Para qualquer outro valor, vamos assumir que ocorreu um erro interno: lançar exceção `ErroInterno`.

Esses códigos estão definidos na classe `CodigosDeRetorno`, que estará disponível para você:

- `CodigosDeRetorno.java`
```java
public class CodigosDeRetorno {

  public static final String SUCESSO = "sucesso";
  public static final String SALDO_INSUFICIENTE = "saldo_insuficiente";
  public static final String CHAVE_PIX_NAO_ENCONTRADA = "chave_pix_nao_encontrada";
}
```

Para fechar a conexão com o servidor, você deve chamar o método `Conexao.close`.

⚠️ **Importante!!** A conexão com o servidor deve ser fechada sempre, _mesmo em caso de erro_. Tome cuidado para que o método `Conexao.close` seja chamado antes de retornar do método `ProcessadorDePix.executarPix`.

**Dica:** `Conexao.close` está em inglês porque vem da interface `AutoCloseable`, fornecida pela biblioteca padrão Java. Aliás, essa interface é tratada de forma especial pelo compilador. Existe uma forma de utilizar recursos derivados de `AutoCloseable`, garantindo que o método `close` seja chamado ao final da operação (mesmo em caso de erro) sem precisar fazê-lo manualmente. 😉


### `ControladorDePix.aoConfirmarPix`

O método `ControladorDePix.aoConfirmarPix` representa o evento da pessoa usuária clicando em um botão na tela do seu dispositivo mobile para confirmar os dados que acabou de preencher e prosseguir com a transferência. Na implementação desse método, você deve seguir os seguintes passos:

- Executar o Pix utilizando o objeto `processadorDePix`.
- Capturar qualquer exceção que seja lançada durante a operação.
- Retornar uma mensagem para informar a pessoa usuária sobre o resultado da operação.

⚠️ **Importante!!** Você não deve "deixar vazar" nenhuma exceção daqui. Uma exceção não tratada nesta camada resulta em um crash do aplicativo.

Você deve retornar a mensagem correta de acordo com o resultado:
- Sucesso: `Pix realizado com sucesso.`
- Valor menor ou igual a zero: `O valor do Pix não pode ser menor nem igual a zero.`
- Chave em branco: `A chave Pix não pode estar em branco.`
- Saldo insuficiente: `Seu saldo é insuficiente.`
- Chave Pix não encontrada: `Chave Pix não encontrada.`
- Erro interno: `Erro interno.`
- Qualquer exceção derivada de `IOException`: `Erro de conexão.`

Mais uma vez, precisamos que você utilize _exatamente_ as mensagens acima, cumprindo o que foi solicitado para o produto. Para evitar possíveis erros de digitação, as mensagens acima estarão disponíveis na classe `Mensagens`:

- `Mensagens.java`
```java
public class Mensagens {

  public static final String SUCESSO =
      "Pix realizado com sucesso.";

  public static final String VALOR_NAO_POSITIVO =
      "O valor do Pix não pode ser menor nem igual a zero.";

  public static final String CHAVE_EM_BRANCO =
      "A chave Pix não pode estar em branco.";

  public static final String SALDO_INSUFICIENTE =
      "Seu saldo é insuficiente.";

  public static final String CHAVE_NAO_ENCONTRADA =
      "Chave Pix não encontrada.";

  public static final String ERRO_INTERNO =
      "Erro interno.";

  public static final String ERRO_DE_CONEXAO =
      "Erro de conexão.";
}
```

É possível validar aqui os dados de entrada (valor e chave Pix), mas você não deve fazer isso, pois a validação já terá sido feita em `ProcessadorDePix.executarPix`.


## Validação do código

As classes que você vai programar dependem de interfaces que não são implementadas em lugar nenhum. Isso faz com que seja mais difícil rodar o seu código e ter certeza de que ele está funcionando como o esperado. Para adiantar essa parte, vamos disponibilizar para você as classes `ServidorFake` e `Principal`:

- `ServidorFake.java`
```java
public class ServidorFake implements Servidor {

  @Override
  public Conexao abrirConexao() {
    return new Conexao() {

      @Override
      public void close() {
      }

      @Override
      public String enviarPix(int valor, String chave) {
        return CodigosDeRetorno.SUCESSO;
      }
    };
  }
}
```

- `Principal.java`
```java
public class Principal {

  public static void main(String[] args) {
    Servidor servidor = new ServidorFake();
    ProcessadorDePix processadorDePix = new ProcessadorDePix(servidor);
    ControladorDePix controladorDePix = new ControladorDePix(processadorDePix);
    String mensagem = controladorDePix.aoConfirmarPix(2000, "abc123");
    System.out.println(mensagem);
  }
}
```

Para saber como seu código se comporta em diferentes situações, experimente alterar os valores retornados ou lançar exceções no código da classe `ServidorFake`.

Boa sorte! Fica de olho em cada detalhe do desafio, combinado? 👀

---

# Avisos Finais

Ao finalizar e submeter o desafio, não se esqueça de avaliar sua experiência preenchendo o formulário. Leva menos de 3 minutos!

Link: [Formulário](https://be-trybe.typeform.com/to/PsefzL2e)

O avaliador automático não necessariamente avalia seu projeto na ordem em que os requisitos aparecem no readme. Isso acontece para deixar o processo de avaliação mais rápido. Então, não se assuste se isso acontecer, ok?

---
