<h1 align="center">Documentação da API Kitsu</h1>

> **Nome da dupla:** Felipe Carvalho e Felipe Cipriano

> **URL da documentaçãp:** https://kitsu.docs.apiary.io/#

> **URL da Api:** https://kitsu.io/api/edge

**Métodos e dados de Autenticação:**
Para se utilizar o método POST na api é preciso fazer uma autenticação por meio de um token, nele será preciso passar o seu o email e a senha do seu respectivo login, deixando o parâmetro grand-type sendo igual a password.

Métodos disponíveis e indicação de qual/quais serão implementados na aplicação:
https://kitsu.io/api/edge/anime e https://kitsu.io/api/edge/manga.

Atributos/parâmetros solicitados por cada método:

**Método Anime:**

| Nome | Descrição |
| ---- | --------- |
| filter[categories] | string que especifica a categoria |
| filter[text] | pesquisa o nome do anime por string |
| page[limit] | limita o quanto de dados podem ser retornados pela pesquisa |
| page[offset] | número de páginas dentro do limite |
| season | especifica a época do ano em que deve filtrar a pesquisa |
| seasonYear | especifica o ano em que deve filtrar a pesquisa |
| streamers | especifica a plataforma oferece o streaming do anime |
| ageRating | filtra a pesquisa por classificação de idade |

**Método Episodes:**

| Nome | Descrição |
| ---- | --------- |
| number | específica o número do episódio |
| page[limit] | limita o quanto de dados podem ser retornados pela pesquisa | 
| page[offset] | número de páginas dentro do limite |

**Método Trending Anime:**
Esse método apenas tráz os animes em alta sem possibilidade de filtro;

**Método Manga:**

| Nome | Descrição |
| ---- | --------- |
| chapterCount | número de capítulos |
| filter[text] | pesquisa o nome do anime por string |
| filter[categories] | string que especifica a categoria |
| page[limit] | limita o quanto de dados podem ser retornados pela pesquisa | 
| page[offset] | número de páginas dentro do limite |

**Método Chapters:**

| Nome | Descrição |
| ---- | --------- |
| mangaId | específica o id do manga |
| number | específica o número do capítulo |
| page[limit] | limita o quanto de dados podem ser retornados pela pesquisa | 
| page[offset] | número de páginas dentro do limite |

**Método Trending Manga:**
Esse método apenas tráz os manga em alta sem possibilidade de filtro;

Dicionário de dados:

**Método Anime:**

| Nome | Descrição |
| ---- | --------- |
| createdAt | retorna a data de criação do anime especificado |
| updateAt | última data de atualização do anime |
| slug | formato de texto que retorna os parâmetros da pesquisa realizada |
| synopsis | sinopse do anime |
| coverImageTopOffset | tamanho da imagem |
| titles | titulo em diferentes linguagens |
| canonicalTitle | título canônico |
| abbreviatedTitles | titulos abreviados |
| averageRating | avalição média no anime |
| ratingFrequencies | notas dadas para o anime |
| userCount | número de requisições de usuário |
| favoritesCount | incidências de favarotismos |
| startDate | data de criação do anime |
| endDate | data de finalização do anime |
| popularityRank | rank de popularidade |
| ratingRank | posisão de ranqueamento |
| ageRating | classificação de idade |
| ageRatingGuide | idade minima e descrição de classificação |
| subtype | onde foi passado |
| status | status do anime |
| tba | se há um evento relacionado ao anime que foi confirmado |
| posterImage | postagem de imagem sobre o anime |
| coverImage | uma previa de imagens do anime |
| episodeCount | quantidade de episódios |
| episodeLength | duração média dos episódios |
| youtubeVideoId | link para vídeo no youtube sobre o anime |
| showType | tipo de produção (ex.: tv, filme, OVA, etc) |
| nsfw | se tem conteúdo explícito |

**Método Episódio:**

| Nome | Descrição |
| ---- | --------- |
| createdAt | retorna a data de criação do episódio especificado |
| updateAt | última data de atualização do episódio |
| synopsis | sinopse do episódio |
| titles | titulo em diferentes linguagens |
| canonicalTitle | título canônico |
| seasonNumber | número da temporada do episódio |
| number | número do episódio |
| relativeNumber | número do episódio relativo a todos os outros / total de episódios |
| airdate | data de lançamento do primeiro episódio da série |
| lenght | comprimento do episódio |
| thumbnail | imagem de capa do episódio |

**Método Trending Anime:**
Retorna o mesmo que o método Anime, porém filtrando para retornar apenas as isformações sobre os animes em alta.

**Método Manga:**

| Nome | Descrição |
| ---- | --------- |
| createdAt | retorna a data de criação do manga especificado |
| updateAt | última data de atualização do manga |
| slug | formato de texto que retorna os parâmetros da pesquisa realizada |
| synopsis | sinopse do manga |
| coverImageTopOffset | tamanho da imagem |
| titles | titulo em diferentes linguagens |
| canonicalTitle | título canônico |
| abbreviatedTitles | titulos abreviados |
| averageRating | avalição média no manga |
| ratingFrequencies | notas dadas para manga |
| userCount | número de requisições de usuário |
| favoritesCount | incidências de favarotismos |
| startDate | data de criação do manga |
| endDate | data de finalização do manga |
| popularityRank | rank de popularidade |
| ratingRank | posisão de ranqueamento |
| ageRating | classificação de idade |
| ageRatingGuide | idade minima e descrição de classificação |
| subtype | onde foi passado |
| status | status do manga |
| tba | se há um evento relacionado ao anime que foi confirmado |
| posterImage | postagem de imagem sobre o anime |
| coverImage | uma previa de imagens do anime |
| chapterCount | números de capitulos |
| volumeCount | números de volumes |
| serialization | publicador que suporta o autor |
| mangaType | tipo de manga (ex.: manhwa, oel, oneshot, ETC) 

**Método Chapters:**

| Nome | Descrição |
| ---- | --------- |
| createdAt | retorna a data de criação do capítulo especificado |
| updatedAt | última data de atualização do capítulo |
| titles | titulo em diferentes linguagens |
| canonicalTitle |  título canônico |
| volumeNumber | números de volumes |
| number | númerp do capítulo |
| synopsis | sinopse do capítulo |
| published | quando foi publicado |
| length | comprimento do capítulo |
| thumbnail | imagem de capa do capítulo |

**Método Trending Manga:**
Retorna o mesmo que o método Manga, porém filtrando para retornar apenas as isformações sobre os Manga mais lidos.
