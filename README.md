Lab1 - Gerenciador de produtos 1.0
==================================

# INSTALAÇÃO
1. Em uma nova instalação do postGreSQL ou em uma existente, crie um banco de dados chamado **Lab1**
2. Atualize o arquivo **persistence.xml** com a URL e os dados de acesso a esta base
3. Ainda neste arquivo, certifique-se de que a linha _<property name="hibernate.hbm2ddl.auto" value="create" />_ não esteja comentada para que as tabelas no banco de dados sejam automaticamente criadas
4. Baixe e instale o [JBOSS Wildfly 10.0](http://wildfly.org/downloads/)
5. No Eclipse, crie um server Wildfly (requer a instalação prévia do JBoss Tools através do Eclipse Marketplace, siga as instruções neste [link](http://www.planetofbits.com/eclipse/how-to-install-wildfly-in-eclipse/)
6. Adicione o projeto Lab1 a este server normalmente e inicie-o
7. Acesse a aplicação via navegador através da URL local publicada

Observação: comente ou remova o codigo especificado no item 3 a partir da segunda execução em diante, caso contrário a aplicação irá reconstruir a base, removendo todos os dados.

# FUNCIONALIDADES NÃO IMPLEMENTADAS
Todas as funcionlidades solicitadas em emails enviado dia 24 de janeiro de 2018 foram implementadas, exceto:
1. Produto também tem um relacionamento ManyToOne com si mesmo (Muitos produtos para um produto pai).
2. O Maven deve ser usado para realizar o build e rodar o projeto.
Como justificativa para o não atendimento destes requisitos, informamos sobre a dificuldade do candidato em conseguir um computador para a implementação da atividade prática, fato que comprometeu o tempo disponível para a execução completa da tarefa em 3 dias.
