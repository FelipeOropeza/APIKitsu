<h1 align="center">Documentação da API Kitsu</h1>

**Nome da dupla:** Felipe Carvalho e Felipe Cipriano

**URL da documentaçãp:** https://kitsu.docs.apiary.io/#

**URL da Api:** https://kitsu.io/api/edge

> **Métodos e dados de Autenticação:**
Para se utilizar o método POST na api é preciso fazer uma autenticação por meio de um token, nele será preciso passar o seu o email e a senha do seu respectivo login, deixando o parâmetro grand-type sendo igual a password.

> **Métodos disponíveis e indicação de qual/quais serão implementados na aplicação:**

**- Métodos usados:**

**Anime:** este método permite obter informações sobre animes disponíveis na plataforma, como título, sinopse, datas de lançamento, gênero, classificação e estúdio responsável.

**Manga:** este método é semelhante ao anterior, mas em vez de animes, retorna informações sobre mangás, incluindo títulos, sinopses, datas de lançamento, gênero e classificação.

**- Métodos não usados:**

**Categories:** este método retorna uma lista de categorias disponíveis na plataforma, como gêneros, temas e públicos-alvo.

**Media Relationships:** este método permite encontrar relacionamentos entre diferentes tipos de mídia, como animes, mangás, light novels e jogos, mostrando quais obras fazem parte do mesmo universo ou história.

**Media Follows:** este método permite aos usuários acompanhar e receber atualizações sobre os animes e mangás que estão assistindo ou lendo.

**Streamers:** este método retorna informações sobre os serviços de streaming que possuem licenças para transmitir um determinado anime.

**Users:** este método permite buscar informações sobre usuários da plataforma, como nome, bio, avatar e estatísticas.

**User Libraries:** este método mostra a biblioteca de mídia de um usuário, incluindo quais animes e mangás ele já assistiu ou leu.

**Reactions:** este método retorna uma lista de reações disponíveis na plataforma, como curtidas, favoritos, notas e comentários.

**Posts:** este método permite acessar os posts feitos por usuários da plataforma sobre animes, mangás e outros assuntos relacionados.

**Comments:** este método retorna uma lista de comentários feitos em posts, animes ou mangás.

**Characters:** este método permite buscar informações sobre personagens presentes em animes e mangás, como nome, descrição, imagens e dubladores.

**Producers & Staff:** este método retorna informações sobre os produtores e membros da equipe responsáveis pela criação dos animes e mangás.

**Groups:** este método retorna informações sobre grupos e equipes de fansubbers e scanlators que trabalham na tradução de animes e mangás para outras línguas.

**Reports:** este método permite aos usuários da plataforma denunciar conteúdos inapropriados, como spams, assédios e violência.

**Site Announcements:** este método retorna informações sobre as últimas atualizações e melhorias realizadas na plataforma.

> **Atributos/parâmetros solicitados por cada método:**

**Método Anime:**

| Nome | Tipo | Descrição |
| ---- | ---- |---------- |
| filter[categories] | string | string que especifica a categoria |
| filter[text] | string | pesquisa o nome do anime por string |
| page[limit] | number | limita o quanto de dados podem ser retornados pela pesquisa |
| page[offset] | number | número de páginas dentro do limite |
| season | number | especifica a época do ano em que deve filtrar a pesquisa |
| seasonYear | number | especifica o ano em que deve filtrar a pesquisa |
| streamers | string | especifica a plataforma oferece o streaming do anime |
| ageRating | number | filtra a pesquisa por classificação de idade |

**Método Episodes:**

| Nome | Tipo | Descrição |
| ---- | ---- |---------- |
| number | number | específica o número do episódio |
| page[limit] | number | limita o quanto de dados podem ser retornados pela pesquisa | 
| page[offset] | number | número de páginas dentro do limite |

**Método Trending Anime:**
Esse método apenas tráz os animes em alta sem possibilidade de filtro;

**Método Manga:**

| Nome | Tipo | Descrição |
| ---- | ---- |---------- |
| chapterCount | number | número de capítulos |
| filter[text] | string | pesquisa o nome do anime por string |
| filter[categories] | string | string que especifica a categoria |
| page[limit] | number | limita o quanto de dados podem ser retornados pela pesquisa | 
| page[offset] | number | número de páginas dentro do limite |

**Método Chapters:**

| Nome | Tipo | Descrição |
| ---- | ---- |---------- |
| mangaId | number | específica o id do manga |
| number | number | específica o número do capítulo |
| page[limit] | number | limita o quanto de dados podem ser retornados pela pesquisa | 
| page[offset] | number | número de páginas dentro do limite |

**Método Trending Manga:**
Esse método apenas tráz os manga em alta sem possibilidade de filtro;

> **Dicionário de dados:**

**Método Anime:**

| Nome | Tipo | Descrição |
| ---- | ---- |---------- |
| createdAt | string | retorna a data de criação do anime especificado |
| updateAt | string | última data de atualização do anime |
| slug | string | formato de texto que retorna os parâmetros da pesquisa realizada |
| synopsis | string | sinopse do anime |
| coverImageTopOffset | number | tamanho da imagem |
| titles | string | titulo em diferentes linguagens |
| canonicalTitle | string | título canônico |
| abbreviatedTitles | string | titulos abreviados |
| averageRating | string | avalição média no anime |
| ratingFrequencies | string | notas dadas para o anime |
| userCount | number | número de requisições de usuário |
| favoritesCount | number | incidências de favarotismos |
| startDate | string YYYY-MM-DD date | data de criação do anime |
| endDate | string YYYY-MM-DD date | data de finalização do anime |
| popularityRank | number | rank de popularidade |
| ratingRank | number | posisão de ranqueamento |
| ageRating | enum | classificação de idade |
| ageRatingGuide | string | idade minima e descrição de classificação |
| subtype | enum | onde foi passado |
| status | enum | status do anime |
| tba | string | se há um evento relacionado ao anime que foi confirmado |
| posterImage | string | postagem de imagem sobre o anime |
| coverImage | string | uma previa de imagens do anime |
| episodeCount | number | quantidade de episódios |
| episodeLength | number | duração média dos episódios |
| youtubeVideoId | string | link para vídeo no youtube sobre o anime |
| showType | enum | tipo de produção (ex.: tv, filme, OVA, etc) |
| nsfw | boolenan | se tem conteúdo explícito |

**Método Episódio:**

| Nome | Tipo | Descrição |
| ---- | ---- |---------- |
| createdAt | string | retorna a data de criação do episódio especificado |
| updateAt | string | última data de atualização do episódio |
| titles | string | titulo em diferentes linguagens |
| canonicalTitle | string | título canônico |
| seasonNumber | number | número da temporada do episódio |
| number | number | número do episódio |
| relativeNumber | number | número do episódio relativo a todos os outros / total de episódios |
| synopsis | string | sinopse do episódio |
| airdate | string YYYY-MM-DD date | data de lançamento do primeiro episódio da série |
| lenght | string | comprimento do episódio |
| thumbnail | string | imagem de capa do episódio |

**Método Trending Anime:**
Retorna o mesmo que o método Anime, porém filtrando para retornar apenas as isformações sobre os animes em alta.

**Método Manga:**

| Nome | Tipo | Descrição |
| ---- | ---- |---------- |
| createdAt | string | retorna a data de criação do manga especificado |
| updateAt | string | última data de atualização do manga |
| slug | string | formato de texto que retorna os parâmetros da pesquisa realizada |
| synopsis | string | sinopse do manga |
| coverImageTopOffset | number | tamanho da imagem |
| titles | string | titulo em diferentes linguagens |
| canonicalTitle | number | título canônico |
| abbreviatedTitles | number | titulos abreviados |
| averageRating | string | avalição média no manga |
| ratingFrequencies | string | notas dadas para manga |
| userCount | number | número de requisições de usuário |
| favoritesCount | number | incidências de favarotismos |
| startDate | string YYYY-MM-DD date | data de criação do manga |
| endDate | string YYYY-MM-DD date | data de finalização do manga |
| popularityRank | number | rank de popularidade |
| ratingRank | number | posisão de ranqueamento |
| ageRating | enum | classificação de idade |
| ageRatingGuide | string | idade minima e descrição de classificação |
| subtype | enum | onde foi passado |
| status | enum | status do manga |
| tba | string | se há um evento relacionado ao anime que foi confirmado |
| posterImage | string | postagem de imagem sobre o anime |
| coverImage | string | uma previa de imagens do anime |
| chapterCount | number | números de capitulos |
| volumeCount | number | números de volumes |
| serialization | string | publicador que suporta o autor |
| mangaType | enum | tipo de manga (ex.: manhwa, oel, oneshot, ETC) | 

**Método Chapters:**

| Nome | Tipo | Descrição |
| ---- | ---- |---------- |
| createdAt | string |retorna a data de criação do capítulo especificado |
| updatedAt | string | última data de atualização do capítulo |
| titles | string | titulo em diferentes linguagens |
| canonicalTitle | string | título canônico |
| volumeNumber | number | números de volumes |
| number | number | número do capítulo |
| synopsis | string | sinopse do capítulo |
| published | string YYYY-MM-DD date | quando foi publicado |
| length | string | comprimento do capítulo |
| thumbnail | string | imagem de capa do capítulo |

**Método Trending Manga:**
Retorna o mesmo que o método Manga, porém filtrando para retornar apenas as isformações sobre os Manga mais lidos.

**Descrição detalhada da aplicação:**
A apliacação tem o foco em mostrar para o usuário suas pesquisa por meio da API Kitsu, onde o mesmo fara a sua pesquisa baseado
no nome do anime desejado

**<h1 align="center">Mapa de navegação: </h1>**

![Cópia de Mapa de navegação (2)](https://user-images.githubusercontent.com/101806766/235957623-bf760044-d5ef-4389-aa1f-fd51c84d698f.jpeg)

**<h1 align="center">Diagramas do banco de dados local:</h1>**

![Diagrama sem nome](https://user-images.githubusercontent.com/101806766/236074493-179f726b-9c86-4b09-89e4-2a4fe2fed289.jpg)

**<h1 align="center">Diagram de Classes: </h1>**
<p align="center">
  <img width="550" height="500" src="https://user-images.githubusercontent.com/101806766/236340414-fc84acca-bd27-436f-abd9-22f9071aab73.jpg">
</p>
