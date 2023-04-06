<h1 align="center">Documentação da API Kitsu</h1>

**Nome da dupla:** Felipe Carvalho e Felipe Cipriano

**URL da documentaçãp:** https://kitsu.docs.apiary.io/#

**URL da Api:** https://kitsu.io/api/edge

> **Métodos e dados de Autenticação:**
Para se utilizar o método POST na api é preciso fazer uma autenticação por meio de um token, nele será preciso passar o seu o email e a senha do seu respectivo login, deixando o parâmetro grand-type sendo igual a password.

> Métodos disponíveis e indicação de qual/quais serão implementados na aplicação:
https://kitsu.io/api/edge/anime e https://kitsu.io/api/edge/manga.

> **Atributos/parâmetros solicitados por cada método:**

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
