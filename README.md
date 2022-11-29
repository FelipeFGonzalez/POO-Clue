# POO-Clue
Trabalho da disciplina Programação Orientada a Objetos, realizada em 2022.2
Jogo Detetive para a matéria de Programação Orientada ao Objeto

1.	Participantes:
•	Felipe Frighetto Gonzalez - 1910438
•	João Gabriel Cavalcanti Dini Nielsen - 1820419
•	Gabriel Mac Gregor - 1820591

2.	Professor: Ivan Mathias Filho
3.	Disciplina: INF1636
4.	Descrição:
Fizemos um jogo, em java, nos baseando no jogo de tabuleiro conhecido como “Detetive”, implementamos as mesmas opções e funcionalidades que temos no jogo de tabuleiro no formato digital como demonstrado abaixo nas telas.

5.	Instruções do Jogo:

Seu anfitrião, Dr John Black, encontrou um fim irreversível – ele foi assassinado. Para resolver este mistério, digo, vencer este jogo, você precisa encontrar as respostas para as seguintes perguntas:

Quem cometeu o crime?
Onde tudo aconteceu?
Que arma o assassino usou?

Movendo a sua peça:

Em cada jogada, tente chegar um cômodo diferente na Mansão, jogue o dado ou selecione os valores e mova a peça de acordo com eles, clicando onde gostaria que ela fosse no mapa. Caso o movimento não seja permitido selecione outro local.

Passagens Secretas:

Os cômodos em cantos opostos da Mansão são conectados por Passagens Secretas. Se está em um desses locais, na sua vez de jogar, você pode usar a Passagem Secreta ao invés de jogar os dados. Para isso basta clicar no botão “Passagem Secreta”, sua peça então será movida para outra sala.

Dar um palpite:
Ao entrar em um cômodo, dê um palpite! Dessa maneira, você tenta determinar – por processo de eliminação – quais as três cartas no Envelope Confidencial. Ao palpitar, apertando o botão, selecione o Suspeito e uma Arma, que serão movidos para o cômodo que você acabou de entrar.

Se sua peça foi movida, na sua próxima vez você pode fazer uma de duas coisas, mover-se do cômodo através de uma das maneiras normais de locomoção ou dar um Palpite para aquele cômodo. Caso decida dar um palpite, não poderá jogar o dado ou mover sua peça.

Fazendo uma Acusação:
Quando você acreditar ter solucionado a identidade das três cartas presentes no Envelope Confidencial, você pode, na sua vez, fazer uma Acusação e indicar o suspeito, o cômodo e a arma que você acredita que foi usada no assassinato. Primeiramente diga, “Eu acuso (nome do suspeito) de cometer o crime no (Cômodo) com a (Arma).” Então, sem deixar ninguém ver, cheque as cartas presentes no envelope.

Em um Palpite, o Cômodo que você menciona deve ser o Cômodo em que a sua peça está. Mas em uma Acusação, você pode dizer qualquer Cômodo.

6.	Desenvolvimento e iterações:
Iteração	Data de Início	Data de Fim
Primeira Iteração	27/09/2022	16/10/2022
Segunda Iteração	17/10/2022	30/10/2022
Terceira Iteração	31/10/2022	13/11/2022
Quarta Iteração	14/11/2022	27/11/2022

7.	Arquivo de salvamento:

Para salvar o estado de uma partida, foi utilizado o seguinte formato para os arquivos:

Nome do suspeito que está no envelope

Nome da arma que está no envelope

Nome da sala que está no envelope

Número de jogadores

(

Nome do suspeito

Bloco de notas (ex: true,true,false,false,false...)

Cartas separadas por ‘,’ (ex: Cozinha, Faca...)

Jogador eliminado (true se o jogador estiver eliminado, false caso contrário)

) Para cada jogador

Sala da Corda

Sala do Cano de Chumbo

Sala da Faca

Sala da Chave Inglesa

Sala do Castiçal

Sala do Revólver

Posição do Coronel Mustard (x,y)

Posição do Professor Plum (x,y)

Posição do Reverendo Green (x,y)

Posição da Sra. Peacock (x,y)

Posição da Sra. White (x,y)

Posição da Srta. Scarlet (x,y)

Turno atual

Palpite (true se o botão palpite estiver habilitado, false caso contrário)


