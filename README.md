# Gerando PDFs com a Biblioteca iText

## Objetivo do Repositório

Este repositório foi criado com o objetivo de fornecer um exemplo prático de como gerar arquivos PDF utilizando a biblioteca iText no contexto de uma disciplina de Programação Orientada a Objetos (POO). Meu nome é Ester Pequeno Trevisan, e sou monitora da disciplina de POO no Instituto Federal da Paraíba, campus Monteiro. Neste repositório, explico e disponibilizo um código que demonstra como adicionar texto, imagens e tabelas em um PDF, com um exemplo focado na criação de uma nota fiscal para um mercadinho.

Aqui, você encontrará exemplos de código para:

- Adicionar texto ao PDF
- Inserir imagens no documento
- Criar e formatar tabelas

Esses exemplos são aplicáveis para diversas situações, como a geração de relatórios ou documentos automatizados. No caso específico deste repositório, o foco é a criação de uma nota fiscal para um mercadinho, mostrando como essas funcionalidades podem ser combinadas em um contexto prático.

### Link para o Vídeo Tutorial

- https://www.youtube.com/watch?v=kgL-eOVBGHs

### Links utilizados para pesquisa

- https://www.baeldung.com/java-pdf-creation

- https://mvnrepository.com/artifact/com.itextpdf/itextpdf

## Como Rodar o Projeto e Gerar o JAR

### Pré-requisitos

- **Java 8 ou superior**: Certifique-se de ter o Java Development Kit (JDK) instalado na sua máquina.
- **Maven**: O projeto utiliza Maven para gerenciamento de dependências e construção do projeto. Verifique se o Maven está instalado e configurado corretamente.

### Passos para Rodar o Projeto

1. **Clone o Repositório**:

   Clone este repositório na sua máquina local usando o comando:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git

2. **Navegue até o Diretório do Projeto**:

   Acesse a pasta do projeto:

   ```bash
   cd gerar-pdf-itext

3. **Compile o Projeto e Gere o JAR:**:

   Use o Maven para compilar o projeto e gerar o arquivo .jar executável:

   ```bash
   mvn compile
   mvn clean package

O comando `mvn clean package` é usado no Maven para realizar uma série de tarefas necessárias para compilar e empacotar o projeto em um arquivo `.jar`. Vamos entender o que cada parte desse comando faz:

- **`mvn clean`**: Esta parte do comando é responsável por limpar o projeto, o que significa que o Maven remove todos os arquivos gerados em builds anteriores, como os arquivos compilados e o próprio `.jar`. Isso garante que você esteja trabalhando com um ambiente de compilação limpo, evitando conflitos e problemas decorrentes de arquivos antigos ou corrompidos.

- **`mvn package`**: Após limpar o projeto, o Maven compila o código-fonte e empacota o projeto em um arquivo `.jar`. Este processo inclui:
  - **Compilação do código**: Todos os arquivos `.java` são compilados em arquivos `.class`.
  - **Empacotamento**: Os arquivos `.class`, recursos, e bibliotecas dependentes são empacotados em um único arquivo `.jar`, pronto para ser executado.

O uso do comando `mvn clean package` é uma prática recomendada para garantir que a compilação do projeto seja feita de maneira correta e consistente, sem resíduos de builds anteriores que possam interferir no resultado final.

## Classes Utilizadas para Gerar o PDF

### 1. `Document`

A classe `Document` representa o documento PDF em si. Ela é o ponto central onde todas as operações relacionadas ao conteúdo do PDF são realizadas. Um `Document` deve ser aberto antes que qualquer conteúdo possa ser adicionado, e deve ser fechado após todas as operações de escrita.

- **Principais Métodos**:
  - `open()`: Abre o documento para permitir a escrita.
  - `close()`: Fecha o documento e finaliza o PDF.
  - `add(Element element)`: Adiciona um elemento (como um parágrafo, tabela, imagem, etc.) ao documento.

### 2. `PdfWriter`

A classe `PdfWriter` é responsável por gravar o conteúdo do `Document` no arquivo PDF. Ela atua como um intermediário entre o `Document` e o arquivo de saída.

- **Principais Métodos**:
  - `getInstance(Document document, OutputStream os)`: Cria uma instância de `PdfWriter` que escreve o conteúdo do `Document` no fluxo de saída especificado (por exemplo, um arquivo).

### 3. `FileOutputStream`

A classe `FileOutputStream` é usada para escrever dados em um arquivo no sistema de arquivos. No contexto de geração de PDFs, ela é utilizada para especificar o arquivo de destino onde o PDF será salvo.

- **Principais Métodos**:
  - `FileOutputStream(String name)`: Constrói um `FileOutputStream` que escreve em um arquivo com o nome especificado.

### 4. `Paragraph`

A classe `Paragraph` é usada para representar um parágrafo de texto no PDF. Você pode adicionar texto simples ou formatado, como negrito, itálico, e sublinhado, usando esta classe.

- **Principais Métodos**:
  - `Paragraph(String text)`: Cria um novo parágrafo com o texto especificado.
  - `setAlignment(int alignment)`: Define o alinhamento do texto dentro do parágrafo (por exemplo, alinhado à esquerda, à direita, ou centralizado).

### 5. `PdfPTable`

A classe `PdfPTable` é usada para criar tabelas no PDF. Ela permite adicionar células e definir o layout das tabelas, como o número de colunas e alinhamento.

- **Principais Métodos**:
  - `PdfPTable(int numColumns)`: Cria uma nova tabela com o número especificado de colunas.
  - `addCell(PdfPCell cell)`: Adiciona uma célula à tabela.
  - `setWidths(float[] widths)`: Define as larguras das colunas da tabela.

### 6. `PdfPCell`

A classe `PdfPCell` representa uma célula individual dentro de uma `PdfPTable`. Ela pode conter texto, imagens ou outros elementos, e você pode personalizar seu estilo, como bordas e alinhamento.

- **Principais Métodos**:
  - `PdfPCell(Phrase phrase)`: Cria uma nova célula com o conteúdo especificado (geralmente uma instância de `Phrase`).
  - `setHorizontalAlignment(int alignment)`: Define o alinhamento horizontal do conteúdo da célula.

### 7. `Phrase`

A classe `Phrase` é uma sequência de `Chunk`s, que são os menores elementos de texto no iText. `Phrase` pode ser usada para adicionar texto formatado dentro de células de tabela ou parágrafos.

- **Principais Métodos**:
  - `Phrase(String text)`: Cria uma nova frase com o texto especificado.
  - `add(Chunk chunk)`: Adiciona um `Chunk` à `Phrase`.

### 8. `Image`

A classe `Image` é usada para adicionar imagens ao documento PDF. Ela pode ser criada a partir de uma imagem existente no sistema de arquivos ou de uma URL.

- **Principais Métodos**:
  - `getInstance(String filename)`: Cria uma instância de `Image` a partir de um arquivo de imagem.
  - `setAlignment(int alignment)`: Define o alinhamento da imagem no documento.
  - `scaleToFit(float width, float height)`: Redimensiona a imagem para caber dentro das dimensões especificadas.
